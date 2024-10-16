@const
Feature: Check Flow of order creation of order for Multiple prodcut SKU

  Scenario Outline: Setting up enviroment for the the project
    Given Set the file and driver and configuration
    Given the user navigates to the Salesforce login page "<Link>"
    Examples:
    | Link                                                          |
    | https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |

  Scenario Outline: User logs in to Salesforce
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username            | Password |
      |v_ankit.sharma@jsw.in| @Ankit123|


  Scenario Outline: Sales team Went to the User account and to the site
    Given the user is on the home page
    When they search for account "<Account>"
    And they click on the account for "<Account>"
    And they moved to the site tab
    Then they should be on the "<Site>" site page
    Examples:
     | Account             | Site |
     | CHAKRESH INDUSTRIES | Global city |


  Scenario Outline: Sales team creates a cement opportunity on a site
    Given they creates an opportunity
    And they select the cement option
    And they choose the cement brand "<Brand>"
    When they specify the cement type as "<Type>" with quantity "<Quantity>"
    And they save the cement opportunity
     Examples:
    | Brand | Type | Quantity |
    |  JSW  |  OPC-53 |  100  |


  Scenario Outline: User processes the opportunities and set the delivery process
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selected the Delivery address "<Address>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        | Address |
      |    Self pickup| 2    | Urgent delivery needed | A-109299 |


  Scenario Outline: Sales team select the seller and gave the cost price
    When the user searches for the source seller "<Seller>"
    And  the user selects the source seller "<Seller>"
    And the user Selects the source seller type "<SourceSeller>"
    And the user edits the cost price to "<Price>"
    When the user selects the category price as "<CPrice>"
    And the user saves the opportunity
    And the opportunity is processed to the Category team for pricing
    And the user selected the category user "<Category>"
    And the user saves the category
    And the user saves the opportunity
    Examples:
       | Price  | Seller     | CPrice | SourceSeller| Category |
       | 100    | Vee        |150   | Marketplace          | Category Test user |



  Scenario Outline: Sales team confirms the customer accepted price
    When the user clicks on the process opportunity button
    When user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity
    And the user verifies the customer-accepted price
    And the user saves the opportunity for sales team
    Examples:
      | Price |
      | 160  |


  Scenario Outline: User request PI to Category team
    When the user clicks on the process opportunity button
    When the user saves the opportunity
    When the user requests PI to the category team
    And the user selected the category user "<Category>"
    And the user saves the category user
    Examples:
      | Category |
      | Category Test user |

  Scenario: User request PI to Seller team
      Given User processed opportunity to send PI to seller
      When the user saves the opportunity
      Then the user requests PI to the seller
      And user saved the opportunity

  Scenario: User updates the seller PI and sends it to the seller
    Given the user navigates to the file page
    And the user chooses the seller PI
    And the user sets the seller PI


  Scenario: User creates an order, captures the subtotal, and order number
    Given the user is on the account page for order creation
    When the user clicks on the create order button
    And the user captures the subtotal for the order
    Then the user prints the subtotal and indicates it as the total value for the order
    And the user clicks on the button to create an order for coils
    And the user captures the order number
    Then the user prints the order number
    And the date and time of the report is given