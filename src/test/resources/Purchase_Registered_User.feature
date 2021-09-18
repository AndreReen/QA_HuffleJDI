@all
Feature: Item Purchase

  As a Registered Customer I want to be able to
  Make purchases on the site

  @purchase
  Background:
    Given I open site
    Then I click on "signInButton" on "MainPage"


  Scenario Outline: registered user make a purchase

    Given I open site
    When I click on "signInButton" on "MainPage"
    And I select value "<TITLE>" from "titleDropDown" on "LoginPage"
    And I type "<NAME>" in "firstNameField" on "LoginPage"
    And I type "<LAST NAME>" in "lastNameField" on "LoginPage"
    And I type "<EMAIL>" in "emailAddressField" on "LoginPage"
    And I type "<PASSWORD>" in "passwordField" on "LoginPage"
    And I type "<PASSWORD>" in "confirmPasswordField" on "LoginPage"
    And I click on "confirmCheckBox" on "LoginPage"
    And I click on "submitButton" on "LoginPage"
    Then I am on the page with "Apparel Site UK | Homepage" title
    And "Thank you for registering." message is displayed  on screen

    Examples:
      | TITLE | NAME | LAST NAME | EMAIL | PASSWORD |

