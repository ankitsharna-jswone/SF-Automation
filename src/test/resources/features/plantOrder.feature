@plant @regression
Feature: Create Plant Supply Order in SF using this Script

  Scenario: Setting up enviroment for the the project
    Given Set the file and driver and configuration


  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  | Link                                                           |
      | v_ankit.sharma@jsw.in | @Ankit123 | https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account                       |
      | OBEROI REALTY LTD |


  Scenario Outline: User creates an opportunity with a specific product and quantity
    Given the user is on the account page
    When the user creates a quick opportunity
    And the user adds a new opportunity
    And the user searches for the product "<Product>"
    And the user selects the product "<Product>"
    And the user sets the quantity to "<Quantity>"
    And the user sets the thickness to "<Thickness>"
    And the user selects the width as "<Width>"
    And the user saves the opportunity
    Examples:
      | Product                    | Quantity | Thickness | Width |
      | MS HR Coil 2062:2011 E250A | 5        | 10        | 1500  |


  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selected the Delivery address "<Address>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    When the user searches for the source seller "<Seller>"
    And  the user selects the source seller "<Seller>"
    And the user Selects the source seller type "<SourceSeller>"
    And the user edits the cost price to "<Cost>"
    And the user saves the opportunity

    Examples:
      | Delivery Type | Days | Special Message        | SourceSeller | Seller | Cost | Address  |
      | Self pickup   | 2    | Urgent delivery needed | Marketplace         | tuka   | 100  |A-110198|

  Scenario Outline: User sends the file to pricing to the category team
    When Sales team clicks on the price awaiting section
    And the user selected the category user "<Category>"
    And the user saves the category
    And the user saves the opportunity
    Examples:
      | Category |
     |Category Test user|


  Scenario Outline: User updates the customer-accepted price after receiving pricing from the category
    Given the user clicks on the process opportunity button for pricing
    When the user selects the category price as "<CPrice>"
    When user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity for pricing
    And the user verifies the customer-accepted price
    And the user saves the opportunity for pricing
    Then the check stage of the opportunity is "<Stage>"
    Then Print the stage of the Opportunity
    Examples:
      | Price | Stage                      | CPrice |
      | 120   | Awaiting Customer Approval | 110    |


  Scenario: User accepted all SKU's
    When user accepted All SKUs
    And user click on proceed button

  Scenario: User check the TDC and completes TDC validations
    Given User click edit button to edit for TDC upload
    And User checked the TDC uploaded
    And User checked PO Uploaded
    When user saved the opportunity
    Then Print the stage of the Opportunity


  Scenario Outline: User mark the Supply Check for the order
    Given User click edit button to edit for supply
    And User check the TDC sent to customer
    And User check the TDC sent to Plant
    And User check the TDC validation
    When Check the feasibility of the order
    When Choose yes for the feasibility
    And Then User filled the advance % "<Percentage>"
    Then user saved the opportunity
    Then Print the stage of the Opportunity
    Examples:
      | Percentage |
      | 40         |

#  Scenario: User request PI to Seller team
#    Given User processed opportunity to send PI to seller
#    When the user saves the opportunity
#    Then the user requests PI to the seller
#    And the user saves the final order
#    Then Print the stage of the Opportunity
#
#  Scenario Outline: User updates the seller PI and sends it to the seller
#    Given the user navigates to the file page
#    And the user chooses the seller PI
#    And the user sets the seller PI
#    Then Print the stage of the Opportunity
#    Then the stage of the opportunity is now "<Stage>"
#    Examples:
#      | Stage            |
#      | Awaiting Payment |


  Scenario: User creates an order, captures the subtotal, and order number
    Given the user is on the account page for order creation
    When the user clicks on the create order button
#    And the user clicks on next for creation order
    And the user captures the subtotal for the order
    Then the user prints the subtotal and indicates it as the total value for the order
    And the user clicks on the button to create an order for coils
    And the user captures the order number
    Then the user prints the order number


