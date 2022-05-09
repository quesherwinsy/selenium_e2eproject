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