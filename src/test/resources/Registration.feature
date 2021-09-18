@all
@registration
Feature: User registration

  As a Customer I want to be able to register on the site
  To have access to addition features

  Scenario Outline: User registers on site

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
      | TITLE | NAME    | LAST NAME  | EMAIL                       | PASSWORD                      |
      | mr    | Ivan    | Ivanov     | ivan_ivanov@hello.com       | 123456                        |
      | miss  | Petr    | Petrov     | petr_petrov@hello.com       | LetterPassword                |
      | rev   | Anderei | Reentovich | andrei_reentovich@hello.com | !@#$%^&*()-=                  |
      | dr    | Alexey  | Nadenenko  | alexey_nadenenko1@hello.com | this password contains spaces |
      | mrs   | Makar   | By         | makar_by@hello.com          | pass1231!@#                   |

  #valid titles: mr, mrs, miss, ms, dr, rev

