Tfl-Challenger-API-Clean-Archichecture

# Android Technical Test

## Objective

Given a valid road ID is specified
When the client is run
Then the road ‘displayName’ should be displayed

Given a valid road ID is specified
When the client is run
Then the road ‘statusSeverity’ should be displayed as ‘Road Status’

Given a valid road ID is specified
When the client is run
Then the road ‘statusSeverityDescription’ should be displayed as ‘Road Status Description’

Given an invalid road ID is specified
When the client is run
Then the application should return an informative error


## Technical Test API

TfL maintains an open data REST API at https://api.tfl.gov.uk 

Amongst the data available is the status of major roads. Some examples of this are shown below.

Example 1: Valid Road 

To get the status of the A2 (a major road in East London) you would make an HTTP GET request to https://api.tfl.gov.uk/Road/A2?app_key=your_developer_key
(where ‘your_developer_key’ is the value sent to you by TfL).

This call will return a ‘200’ response code along with the following JSON: -

[
  {
    "$type": "Tfl.Api.Presentation.Entities.RoadCorridor, Tfl.Api.Presentation.Entities",
    "id": "a2",
    "displayName": "A2",
    "statusSeverity": "Good",
    "statusSeverityDescription": "No Exceptional Delays",
    "bounds": "[[-0.0857,51.44091],[0.17118,51.49438]]",
    "envelope": "[[-0.0857,51.44091],[-0.0857,51.49438],[0.17118,51.49438],[0.17118,51.44091],[-0.0857,51.44091]]",
    "url": "/Road/a2"
  }
]

Example 2: Non-existent road

If you made a HTTP GET request to call to https://api.tfl.gov.uk/Road/A233? app_key=your_developer_key

You call will return a ‘404’ response code the following response: -

{
  "$type": "Tfl.Api.Presentation.Entities.ApiError, Tfl.Api.Presentation.Entities",
  "timestampUtc": "2017-11-21T14:37:39.7206118Z",
  "exceptionType": "EntityNotFoundException",
  "httpStatusCode": 404,
  "httpStatus": "NotFound",
  "relativeUri": "/Road/A233",
  "message": "The following road id is not recognised: A233"
}
### Architecture pattern

To solve this challenger I have used clean archichecture implementation.

There are different opinions about how many layers Clean Architecture should have. The architecture doesn’t define exact layers but instead lays out the foundation. The idea is that you adapt the number of layers to your needs.

To keep things simple, you’ll use five layers:

Presentation: A layer that interacts with the UI.
Use cases: Sometimes called interactors. Defines actions the user can trigger.
Domain: Contains the business logic of the app.
Data: Abstract definition of all the data sources.
Remote: In our implementation is the more external layer it send request to the API.

### Questions

  1. How to build the code 
  
   You will need the latest version of android studio installed. 
   After that File->New->Project From Git, Paste the url that is avaible on github to clone the
   project.After run the app.
    
  2. How to run the output
  
   The design is really simple so the only thing that you need to do is type de 
   road and you would get information about the road'status.
    
  3. How to run any tests that you have written
  
   The project has been divided in differents modules (domain,data,presentation,remote). In each module you will find a folder called test inide of this 
   another one called suite, this file have all the test avaible on this module so running the suite test you will run all the test. 
  
  4. Any assumptions that you’ve made and/or nything else you think is relevant.
  
   This project has been developed for exposure reasons,  so it must be assumed that not all the software functionalities
   have been tested and that not all areas in which it could be worked have been covered.
  
  
