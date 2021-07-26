# UrbanDictionaryApp
Android application that allows users to enter a slang term such as "wbu" or "ikwym" and retrieve a list of definitions rated by the Urban Dictionary community. The green thumbs up icon indicates the number of people that agree with the definition, whereas the red thumbs down icon shows the number of people that disagree with the definition.

![Alt text](app/docs/what_about_you_screenshot.png?raw=true "What About You") ![Alt text](app/docs/i_know_what_you_mean_screenshot.png?raw=true "I Know What You Mean")

# How to Run
The Urban Dictionary API requires an API Key in order to access the API Endpoints. This project has been configured to read a properties file containing the API Key that is not checked into version control.

To run this app, you will need to:
- Sign up for a Rapid API account and generate a key here: https://rapidapi.com/community/api/urban-dictionary
- Open the source code in Android Studio
- Switch the project explorer to 'Project'
- In the root of the project create a new file called 'apikey.properties'
- Inside the file type: API_KEY = "API_KEY_HERE"
- Build the project

If successful the project should have an entry in the BuildConfig class. (Type BuildConfig.API_KEY in source code, if a match is found it was imported successfully)

Gradle has been configured to read a specific file with the above name and contents, so ensure that the naming is exact.
