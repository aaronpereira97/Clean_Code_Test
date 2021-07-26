package com.challenger.tfl_challenger_api_clean_archichecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.challenger.domain.models.RoadInfo
import com.challenger.tfl_challenger_api_clean_archichecture.R
import com.challenger.tfl_challenger_api_clean_archichecture.utils.Resource
import com.challenger.tfl_challenger_api_clean_archichecture.viewmodels.RoadViewModel
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

import java.util.concurrent.TimeUnit

private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {
    private val roadViewModel:RoadViewModel by viewModel()
    private  var subscriptionSearh : Subscription? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        roadViewModel.get_road_info.observe(this, Observer { result->
               Log.i(TAG, result.javaClass.name)
                when(result){
                    is Resource.Success -> {
                        showStatusError(View.GONE, "")
                        showResponseValues(result.result)
                        showResponseValues(View.VISIBLE)
                        hideProgressBar()
                    }

                    is Resource.Error -> {
                        showStatusError(View.VISIBLE, getString(R.string.error_request_msg_toast) + result.message)
                        showResponseValues(View.GONE)
                        hideProgressBar()
                    }

                    is Resource.Loading ->{
                        showContainerCardView()
                        showStatusError(View.GONE, "")
                        showResponseValues(View.INVISIBLE)
                        showProgressBar()
                    }

                }

        })
    }

    private fun showStatusError(visibility: Int, message: String) {
        status_request_textview.text = message
        status_request_textview.visibility = visibility
    }


    private fun showResponseValues(visibility : Int ){
        display_name_textview.visibility = visibility
        status_textview.visibility = visibility
        status_description_textview.visibility = visibility
    }

    private fun showResponseValues(result: RoadInfo) {
        display_name_textview.text = result.displayName
        status_textview.text = result.statusSeverity
        status_description_textview.text = result.statusSeverityDescription
    }

    private fun initListeners() {

        subscriptionSearh = RxTextView.textChanges(road_id_edittext)
            .debounce(300, TimeUnit.MILLISECONDS)
            .subscribe { currentValue->
                if (currentValue?.length != 0) {
                    roadViewModel.getRoadInfo(currentValue.toString())
                }
            }

    }


    private fun showContainerCardView() {
        conteiner_info_cardview.visibility = View.VISIBLE
    }

    private fun showProgressBar(){
        progressbar.visibility = View.VISIBLE
    }
    private fun hideProgressBar(){
        progressbar.visibility = View.GONE

    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptionSearh?.unsubscribe()
    }
}