Feature: User Login

Scenario:Successful login
Given I am on login page
When I login with "johndoe@gmail.com" and "123456"
Then I should see home page
