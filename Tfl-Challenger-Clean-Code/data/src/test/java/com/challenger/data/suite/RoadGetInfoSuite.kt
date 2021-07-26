package com.challenger.tfl_challenger_api_clean_archichecture.suite

import com.challenger.data.mappers.RoadEntityMapperTest
import com.challenger.data.source.RoadRemoteDataStoreTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(

    RoadRemoteDataStoreTest::class,
    RoadEntityMapperTest::class

)
class RoadGetInfoSuite