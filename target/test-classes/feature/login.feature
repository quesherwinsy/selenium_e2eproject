# requirement
Feature: Application Login
# test case header
  Scenario Outline: Positive test validating login 
    Given Initialize the browser with chrome
      And Navigate to "http://qaclickacademy.com/" site
      And Click on sign login link in home page to land on secure sign in page
     When User enters <username> and <password> and logs in
     Then Verify user successfully logged in
      And Close browser

Examples:
|username						|password	|
|test99@gmail.com		|123456		|
|test123@gmail.com	|12345		|

@Guru99Test1 @Regression
  Scenario Outline: Test Guru99 site
    Given Initialize the browser with chrome
      And Navigate to "https://demo.guru99.com/test/guru99home/" site
      And Test Guru99 fields and iframe
      
# test case header
@AddPlaceAPI1 @Regression
  Scenario Outline: Positive test validating login2 
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify <client_id> if existing

Examples:
|username	|password	| client_id |
|admin		|P@ssw0rd123$		|Service Provider |

# Smart Card Conne-3218
@DisplayMenu @Regression
  Scenario Outline: Verify that the application will display the SCC logo and menu bar
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify if logo profile and configuration module exist
       And Close browser

Examples:
|username	|password	|
|admin		|P@ssw0rd123$	|

# Smart Card Conne-3219 TODO

# Smart Card Conne-3110
@DisplayMenu @Regression
  Scenario Outline: Verify that the application will able to login successfully
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify if logo profile and configuration module exist
       And Close browser

Examples:
|username	|password	|
|admin		|P@ssw0rd123$	|

# Smart Card Conne-3111 TODO
@HideButton @Regression
  Scenario Outline: Verify that the application will able to show or hide the password
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User inputs <username> and <password> in SCC admin
#       And Verify if Password is <visible>
#       And Close browser

Examples:
|username	|password	|
|admin		|P@ssw0rd123$	|

# Smart Card Conne-3112 part 1
@LoginError1 @Regression
  Scenario Outline: Verify that the application performing incorrect login credentials1
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify login error <message>
       And Close browser

Examples:
|username	|password	    | message |
|admin666 |P@ssw0rd666$	| Unauthorized user. Please check your credentials.|
|admin666	|P@ssw0rd123$	| Unauthorized user. Please check your credentials.|
|admin  	|P@ssw0rd123$	| Unauthorized user. Please check your credentials.|

# Smart Card Conne-3111 part 2
@LoginError2 @Regression
  Scenario Outline: Verify that the application performing incorrect login credentials2
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User inputs <username> and <password> in SCC admin
       Then Verify if login button is disabled
       And Close browser

Examples:
|username	|password	    |
|empty 		|P@ssw0rd666$	|
|admin		|empty       	|
|empty 		|empty      	|

# Smart Card Conne-3192
@LoginError3 @Regression
  Scenario Outline: Verify that the application will not accept the service provider credentials
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify login error <message>
       And Close browser

Examples:
|username	|password	    | message |
|hsbc |P@ssw0rd123$	| Unauthorized user. Please check your credentials.|

# Smart Card Conne-3113
@UserLogout @Regression
  Scenario Outline: Verify that the application will able to logout
    Given Initialize the browser with chrome
      And Navigate to "https://10.126.228.112:80/login" site
       When User enters <username> and <password> and logs in SCC admin
       Then Verify if user logout sucessful
       And Close browser

Examples:
|username	|password	|
|admin		|P@ssw0rd123$	|
