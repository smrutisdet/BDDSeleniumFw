Feature:Add To Cart and place order
  Background:
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
  @smoke
  Scenario Outline:Search For a product and Add it To cart
    And user clicks on products button
    And user enters product search string as "<searchItem>"
    And user clicks on search button
    Then clicks on view products
    And in product details page user clicks on Add to cart button
    And user clicks on Continue Shopping on the displayed pop up window
    Then user clicks on cart link and navigates to view cart page
    And verifies the item added in the cart
    Then user clicks on proceeds To Checkout
    And user clicks on place order
    And user enter payment details and clicks on Pay and Confirm Order
    And user navigates to order Confirmation page

    Examples:
      | searchItem|
      | Blue top  |


