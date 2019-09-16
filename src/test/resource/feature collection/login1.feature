#Author: your.email@your.domain.com
#Date: 12/09/2019
#Keywords Summary :

@SmokeTest
Feature: Title of your feature
  To verify login functionality of mercury tours application

  @Background
  Scenario: Title of your scenario
  When user opens "chrome" browser
  And user enters application url "http://www.newtours.demoaut.com/mercurywelcome.php"
  And user waits "15" seconds to login screen to be loaded
  And user maximizes chrome  browser
  Then user is on login screen of mercury tours application

  @SmokeTest
  Scenario: Title of your scenario outline
  Given user access login screen of mercury tours application
  When user enters "Suvidyap1" as username
  And user enters "P@ssword1" as password
  And user clicks on signin button
  Then user is on flight finder screen
  When user clicks on signoff link
  Then  user is on singon screen

    