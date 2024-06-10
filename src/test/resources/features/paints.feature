@paint
Feature: Create Order in SF using this Script

  Scenario: Setting up enviroment for the the project
    Given Set the file and driver and configuration


  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username            | Password | Link                                                          |
      |v_ankit.sharma@jsw.in| @Ankit123|https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      | Test Account B |


  Scenario Outline: User creates an opportunity with a specific product and quantity
    Given the user is on the account page
    When the user creates a quick opportunity
    And the user adds a new opportunity
    And the user searches for the product "<Product>"
    And the user selects the product "<Product>"
    And the user sets the quantity to "<Quantity>"
    And the user saves the opportunity
    Examples:
      | Product      | Quantity |
      | JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | 5   |


  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    And the user chose the paint colour "<Colour>"
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    When the user selects the category price as "<CPrice>"

    And the user edits the cost price to "100"
    And the user saves the opportunity

    Examples:
      | Delivery Type | Days | Special Message        |Colour | Seller     |CPrice| Price |

      |     Self pickup    | 2    | Urgent delivery needed | Grey   | Auto_User_SsQg (JODL)  |   110  |   120   |


  Scenario: User sends the file to pricing to the category team
    When Sales team clicks on the price awaiting section
    And the user performs the category user test
    And the user saves the category
    And the user saves the opportunity



  Scenario Outline: User requests PI to the category team
    Given the user clicks on the process opportunity button for PI to category team
    When user sets the customer-accepted price to "<Price>"
    Given the user saves the opportunity first
    And the user verifies the customer-accepted price
    And the user requests PI to the category team
    And the user selected the "<Category>"
    And the user saves the category user
    And the user saves the opportunity for sales
    Then Check stage of the opportunity is "<Stage>"
    Then User Went to SKU requirement page
    Then User selected the SKU number "0"
    Then Click on the Opportunity Page

    Examples:
      | Stage            | Category ||Price|

      | Awaiting PI | category user test|| 120  |

  Scenario: User request PI to Seller team
    Given User processed opportunity to send PI to seller
    And the user saves the final order
    Then the user requests PI to the seller
    And the user saves the final order

  Scenario Outline: User updates the seller PI and sends it to the seller
    Given the user navigates to the file page
    And the user chooses the seller PI
    And the user sets the seller PI
    Then the stage of the opportunity is now "<Stage>"
    Examples:
      | Stage            |
      | Awaiting Payment |


  Scenario: User creates an order, captures the subtotal, and order number
    Given the user is on the account page for order creation
    And User approves the approval history
    When the user clicks on the create order button
    And the user captures the subtotal for the order
    Then the user prints the subtotal and indicates it as the total value for the order
    And the user clicks on the button to create an order for coils
    And the user captures the order number
    Then the user prints the order number
