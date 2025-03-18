Feature:Add To Cart and place order
  Background:
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
    And user enters username as "testmiuser@gmail.com" and password as "Testmiuser@01"
    And user clicks on login button
    Then application should navigate to logged in user home page
  @smoke
  Scenario Outline:Search For a product and Add it To cart
    And user clicks on products button
    And user enters product search string as "<searchItem>"
   And user clicks on search button
    And user clicks on view products
    And in product details page user clicks on Add to cart button
    And user clicks on Continue Shopping on the displayed pop up window
    And user clicks on cart link and navigates to view cart page
    Then user verifies the "<searchItem>" added in the cart
    And user clicks on proceeds To Checkout
   And user clicks on place order
    And user enter payment details and clicks on Pay and Confirm Order
   Then user navigates to order Confirmation page

    Examples:
      | searchItem|
      | Blue top  |


