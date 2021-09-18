@all
@purchase
Feature: Item Purchase

  As a Registered Customer I want to be able to
  Make purchases on the site

  Background: As a registered user
    Given I open site
    And I click on "signInButton" on "MainPage"
    And  I perform login

  Scenario Outline: Registered user make a purchase

    Given I open Item page
    When I click on "addToBagButton" on "StoreItemPage"
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
    Then "Thank you for your Order!" message is displayed  on screen

    Examples:
      | COUNTRY | NAME   | SURNAME | ADDRESS | CITY | POST CODE | SHIPPING      | CARD TYPE | CARD NUMBER      | exp MONTH | exp YEAR | CVV |
      | GB      | Alexey | Girin   | SPB     | SPB  | SPB       | premium-gross | 001       | 1234567890123456 | 1         | 2031     | 000 |
      | GG      | Alexey | Girin   | SPB     | SPB  | SPB       | premium-gross | 002       | 1234567890123456 | 2         | 2030     | 123 |
      | IM      | Alexey | Girin   | SPB     | SPB  | SPB       | premium-gross | 003       | 1234567890123456 | 11        | 2022     | 555 |
      | JE      | Alexey | Girin   | SPB     | SPB  | SPB       | premium-gross | 024       | 1234567890123456 | 12        | 2021     | 999 |

#shipping values:   standard-gross, premium-gross
#Counries: GB, GG, IM, JE
# card types: 001,002,003,005,024
# months: 1,2,3,4,5,6,7,8,9,10,11,12
# years: 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031