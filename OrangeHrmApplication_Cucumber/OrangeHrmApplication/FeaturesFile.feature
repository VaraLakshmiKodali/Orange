Feature: OrangeHrm Application Functionalities Test

Background:
Given User should open the chrome browser in the system

Scenario:
OrangeHrm Application LogIn Page Test
#Given User should open the chrome browser in the system
When User enters OrangeHrm Application Url Address
Then User should be navigated to OrangeHrm Application LogIn Page
Then User should close the OrangeHrm Application with the browser


Scenario:
OrangeHrm Application LogIn Functionality Test
#Given User should open the chrome browser in the system
When User enters OrangeHrm Application Url Address
Then User should be navigated to OrangeHrm Application LogIn Page
Then User should enter username and password and click on logIn button
Then User should be able to navigate to OrangeHrm Application Home Page
Then User should logout from the OrangeHrm Application
Then User  should close the OrangeHrm Application with the browser

Scenario Outline:

OrangeHrm Application LogIn Functionality Test with Test Data

#Given User should open the chrome browser in the system
When User enters OrangeHrm Application Url Address
Then User should be navigated to OrangeHrm Application LogIn Page
Then User should enter "<username>" and "<password>" and click on logIn button
Then User should be able to navigate to OrangeHrm Application Home Page
Then User should logout from the OrangeHrm Application
Then User  should close the OrangeHrm Application with the browser

Examples:
| VaraLakshmi | Lovely 					|
|	VamshiKumar	|	Vamshi 					|
|	Mukesh			| Mukesh 					|
| Jashwanth		|	Jessi	 					|
| VaraLakshmi	| LovelyVaram@1998|