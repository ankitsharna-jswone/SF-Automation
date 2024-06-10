@MultiPaint
Feature: Multi paint testing

  Scenario: Setting up environment for the project
    Given Set the file and driver and configuration

  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  | Link                                                         |
      | v_ankit.sharma@jsw.in | @Ankit123 | https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      |Test Account B|


  Scenario: User creates Multiple opportunity with a specific product and quantity
    Given the user is on the account page
    When the user creates a quick opportunity
    And Add multiple products in SKU according to given Data
      |Product                   |Quantity| UOM     | Thickness | Width | Length |Diameter|
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | 10     |Primary  |        |   |        |        |
      | JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | 500 | Primary |  |  || |
    Then the user saves the opportunity


  Scenario Outline: User processes the opportunities and set the delivery process
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        |
      |    Self pickup| 2    | Urgent delivery needed |


  Scenario Outline: Sales team will select the seller and fill the cost and required fields
    Given Sales team gives the seller for each product
      |Product                    | Seller |
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | Vee |
      |JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | Test Steel Authority 2 |

    And  Sales team give the cost price to the category
      |Product                    | cost |
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | 120 |
      |JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | 110 |
    And Sales team selected the colour
      |Product                    | colour |
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | Red Oxide |
      |JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | Brown |

    When the user saves the opportunity
    Then Sales team clicks on the price awaiting section
    And the user performs the category user test
    And the user saves the category
    Then the stage of the opportunity is now "<Stage>"
    Examples:
      | Stage            |
      | Awaiting Pricing |



  Scenario: Category will take this order and put the pricing from thier side for each product
    Given User at the Opportunity page and clicks on the process opportunity
    And Gave Category pricing for each product
      |Product                    | CategoryPrice |
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | 130 |
      |JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | 130 |

    And Gave Customer Accepted pricing for each product
      |Product                    | CustomerPrice |
      |JSW Industrial ROZP Alkyd Primer - Matt Finish [DFT: 25 - 50] (Single component) | 130 |
      |JSW Industrial Synthetic Alkyd Enamel - Glossy Finish [DFT: 20 - 25] (Single component) | 130 |
    When the user saves the opportunity

  Scenario Outline: User requests PI to the category team
    Given the user requests PI to the category team
    And the user selected the "<Category>"
    And the user saves the category user
    And the user saves the opportunity for sales
    Then Check stage of the opportunity is "<Stage>"
    Examples:
      | Stage            | Category |
      | Awaiting PI | category user test|

  Scenario: Check Stage of SKU
    Then User Went to SKU requirement page
    Then User selected the SKU number "0"
    Then Click on the Opportunity Page

  Scenario: User request PI to Seller team
    Given User processed opportunity to send PI to seller
    When the user saves the opportunity
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
    When the user clicks on the create order button
    And the user captures the subtotal for the order
    Then the user prints the subtotal and indicates it as the total value for the order
    And the user clicks on the button to create an order for coils
    And the user captures the order number
    Then the user prints the order number




