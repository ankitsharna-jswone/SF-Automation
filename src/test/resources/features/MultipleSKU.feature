@multi
Feature: Check Flow of order creation of order for Multiple prodcut SKU
  Scenario Outline: Setting up enviroment for the the project
    Given Set the browser and driver for the automation "<Browser>"
    And User passes driver to the other pages and files
    Examples:
      |Browser|
      | chrome |


  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username            | Password | Link                                                          |
      |v_ankit.sharma@jsw.in| @Ankit123|https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |



  Scenario Outline: User changes the App According to the Profile
    Given User clicks on the App section of Salesforce
    And User searches for the "<App>" for work
    And User selects the "<App>"
    Examples:
      | App |
      |MFG |
    #MSME Construct #MFG #Retail

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
     |MS HR Coil 2062:2011 E250A| 10     |Primary  | 10        | 1250  |        |        |
     |MS HR Sheet 2062:2011 E250A| 15    |Secondary|    15     |  1500 |  1500   |        |
     |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| 500 | | 12 | 1250 |4000| |
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
      |MS HR Coil 2062:2011 E250  | Vee |
      |MS HR Sheet 2062:2011 E250A| Test Steel Authority 2|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| Giriraj shinha |

    And  Sales team give the cost price to the category
      |Product                    | cost |
      |MS HR Coil 2062:2011 E250 | 1200|
      |MS HR Sheet 2062:2011 E250A|1500|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| 2000 |
    When the user saves the opportunity
    Then Sales team clicks on the price awaiting section
    And the user selected the category user "<Category>"
    And the user saves the category
    Then the stage of the opportunity is now "<Stage>"
    Examples:
      | Stage            | Category |
      | Awaiting Pricing | Category Test user |




  Scenario: Category will take this order and put the pricing from thier side for each product
    Given User at the Opportunity page and clicks on the process opportunity
    And Gave Category pricing for each product
      |Product                    | CategoryPrice |
      |MS HR Coil 2062:2011 E250 | 1500|
      |MS HR Sheet 2062:2011 E250A|1800|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| 2200 |


    And Gave Customer Accepted pricing for each product
      |Product                    | CustomerPrice |
      |MS HR Coil 2062:2011 E250 | 1700|
      |MS HR Sheet 2062:2011 E250A|1800|
      | JSL Stainless Steel CRAP JT 2B PVC Finish Sheets | 2200 |
    When the user saves the opportunity

  Scenario Outline: User requests PI to the category team
    Given the user requests PI to the category team
    And the user selected the category user "<Category>"
    And the user saves the category user
    And the user saves the opportunity for sales
    Then Check stage of the opportunity is "<Stage>"
    Examples:
      | Stage            | Category |
      | Awaiting PI | Category Test user |

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




