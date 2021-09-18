@all
Feature: Item Purchase

  As a Registered Customer I want to be able to
  Make purchases on the site

  Background: As a registered user
    Given I open site
    Then I click on "signInButton" on "MainPage"
    And  I perform login

  Scenario Outline: Registered user make a purchase

    Given I open Item page
    Then I click on "addToBagButton" on "StoreItemPage"
    And I click on "checkOutButton" on "StoreItemPage"

    And I am on the page with "Your Shopping Bag | Apparel Site UK" title
    And I click on "checkOutButton" on "ShoppingBagPage"

    And I am on the page with "Checkout | Apparel Site UK" title
    And I select value "<COUNTRY>" from "countryRegionDropDown" on "CheckoutPage"
    And I type "<NAME>" in "firstNameField" on "CheckoutPage"
    And I type "<SURNAME>" in "lastNameField" on "CheckoutPage"
    And I type "<ADDRESS>" in "addressLine1Fiels" on "CheckoutPage"
    And I type "<CITY>" in "cityField" on "CheckoutPage"
    And I type "<POST CODE>" in "postCodeField" on "CheckoutPage"
    And I click on "nextButton" on "CheckoutPage"

    And I select value "<SHIPPING>" from "shippingMethondDropDown" on "CheckoutPage"
    And I click on "nextButton" on "CheckoutPage"

    And I select value "<CARD TYPE>" from "cardTypeDropDown" on "CheckoutPage"
    And I type "<CARD NUMBER>" in "cardNumberField" on "CheckoutPage"
    And I select value "<exp MONTH>" from "expiryMonthDropDown" on "CheckoutPage"
    And I select value "<exp YEAR>" from "expiryYearDropDown" on "CheckoutPage"
    And I type "<CVV>" in "cardCvvField" on "CheckoutPage"
    And I click on "nextButton" on "CheckoutPage"
    
    And I click on "confirmCheckbox" on "CheckoutPage"
    And I click on "PlaceOrderButton" on "CheckoutPage"
    
    Then I am on the page with "Order Confirmation | Apparel Site UK" title

    Examples:
      | COUNTRY | NAME   | SURNAME | ADDRESS | CITY | POST CODE | SHIPPING      | CARD TYPE | CARD NUMBER      | exp MONTH | exp YEAR | CVV |
      | GB      | Alexey | Girin   | SPB     | SPB  | SPB       | premium-gross | 001       | 1234567890123456 | 12        | 2024     | 123 |

#shipping values:   standard-gross  premium-gross
#Counries: GB