Feature: Check Flow of order creation of order for Multiple prodcut SKU

  #Config done for browser
  @ConstCreditOrder @ZohoCreditOrder
  Scenario Outline: Setting up enviroment for the the project
    Given Set the file and driver and configuration
    Given the user navigates to the Salesforce login page "<Link>"
    Examples:
      | Link                                                           |
      | https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |


  #Credentials
  @ConstCreditOrder @ZohoCreditOrder
  Scenario Outline: User logs in to Salesforce
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  |
      | v_ankit.sharma@jsw.in | @Ankit123 |



  #Account level : Construct , ZOHO , Credit, Normal
  @ConstCreditOrder
  Scenario Outline: Sales team Went to the User account and to the site
    Given the user is on the home page
    When they search for account "<Account>"
    And they click on the account for "<Account>"
    And they moved to the site tab
    Then they should be on the "<Site>" site page
    Examples:
      | Account             | Site        |
      | CHAKRESH INDUSTRIES | Global city |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account        |
      | Test Account B |

   @ZohoCreditOrder
  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account            |
      | RAHUL KIRANA STORE |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account                       |
      | RELIANCE JIO INFOCOMM LIMITED |



 #Oppportunity initializing
  @ConstructMultiSKU
  Scenario: User creates Multiple opportunity with a specific product and quantity
    When the user creates a quick opportunity
    And Add multiple products in SKU according to given Data
      | Product                                          | Quantity | UOM       | Thickness | Width | Length | Diameter |
      | MS HR Coil 2062:2011 E250A                       | 10       | Primary   | 10        | 1250  |        |          |
      | MS HR Sheet 2062:2011 E250A                      | 15       | Secondary | 15        | 1500  | 1500   |          |
      | JSL Stainless Steel CRAP JT 2B PVC Finish Sheets | 500      |           | 12        | 1250  | 4000   |          |
    Then the user saves the opportunity

  @ConstCreditOrder
  Scenario Outline: Sales team creates a cement opportunity on a site
    Given they creates an opportunity
    And they select the cement option
    And they choose the cement brand "<Brand>"
    When they specify the cement type as "<Type>" with quantity "<Quantity>"
    And they save the cement opportunity
    Examples:
      | Brand | Type   | Quantity |
      | JSW   | OPC-53 | 100      |

  @ZohoCreditOrder
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
      | MS HR Coil 2062:2011 E250A | 5        | 1000      | 1500  |




  #Credit or Non Credit
  @ConstCreditOrder
  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selectes the credit required as YES
    And User selects the credit "<Program>" for the user
    And Then User filled the advance % "<Advance>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        | Program          | Advance |
      | Self pickup   | 2    | Urgent delivery needed | BNPL-IFC-JSWSCPL | 30      |

  @ZohoCreditOrder
  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selectes the credit required as YES
    And User selects the credit "<Program>" for the user
    And Then User filled the advance % "<Advance>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        | Program          | Advance |
      | Self pickup   | 2 | Urgent delivery needed | Channel finance-TATA | 30      |


  Scenario Outline: User processes the opportunities and set the delivery process
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        |
      | Self pickup   | 2    | Urgent delivery needed |


#SKU eiditing
  @ConstCreditOrder @ZohoCreditOrder
  Scenario Outline: User sends the file to pricing to the category team
    When the user selects the category price as "<CPrice>"
    And the user edits the cost price to "<Price>"
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user saves the opportunity
    When Sales team clicks on the price awaiting section
    And the user performs the category user test
    And the user saves the category
    And the user verifies the customer-accepted price
    And the user saves the opportunity
    Examples:
      | CPrice | Price | Seller                |
      | 120    | 100   | Giriraj shinha (JODL) |




 @ConstructMultiSKU
  Scenario Outline: Sales team will select the seller and fill the cost and required fields
    Given Sales team gives the seller for each product
      |Product                    | Seller |
      |MS HR Coil 2062:2011 E250  | Vee |
      |MS HR Sheet 2062:2011 E250A| Test Steel Authority 2|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets | Aakash Seller India |

    And  Sales team give the cost price to the category
      |Product                    | cost |
      |MS HR Coil 2062:2011 E250 | 1200|
      |MS HR Sheet 2062:2011 E250A|1500|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| 2000 |
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
      |MS HR Coil 2062:2011 E250 | 1500|
      |MS HR Sheet 2062:2011 E250A|1800|
      |JSL Stainless Steel CRAP JT 2B PVC Finish Sheets| 2200 |

    And Gave Customer Accepted pricing for each product
      |Product                    | CustomerPrice |
      |MS HR Coil 2062:2011 E250 | 1700|
      |MS HR Sheet 2062:2011 E250A|1800|
      | JSL Stainless Steel CRAP JT 2B PVC Finish Sheets | 2200 |
    When the user saves the opportunity



  @ConstCreditOrder
  Scenario Outline: Sales team confirms the customer accepted price
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And User selects the credit "<Program>" for the user
    And User sets the Credit days "<Days>"
    When user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity
    When the user requests PI to the category team
    When the user performs the category user test
    And the user saves the category user
    Then the user requests PI to the seller
    And user saved the opportunity
    Then The stage of opportunity will be printed
    Examples:
      | Price | Program          | Days |
      | 140   | BNPL-IFC-JSWSCPL | 10   |

  @ZohoCreditOrder
  Scenario Outline: Sales team confirms the customer accepted price
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And User selects the credit "<Program>" for the user
    And User sets the Credit days "<Days>"
    When user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity
    When the user requests PI to the category team
    When the user performs the category user test
    And the user saves the category user
    Then the user requests PI to the seller
    And user saved the opportunity
    Then The stage of opportunity will be printed
    Examples:
      | Price | Program          | Days |
      | 140   | Channel finance-TATA | 0   |


  Scenario: Sales team confirms the customer accepted price
    When the user clicks on the process opportunity button
    And the user saves the opportunity
    When the user requests PI to the category team
    When the user performs the category user test
    And the user saves the category user
    Then the user requests PI to the seller
    And user saved the opportunity
    Then The stage of opportunity will be printed


  @ConstCreditOrder
  Scenario Outline: User Selects the credit on the Opportunity page
    When User click on Select Credit button
    And User marked Credit requirement as Required
    And user chose the credit program on the Opportunity "<Credit>"
    And User selects the credit Days on the Opportutnity "<Days>"
    And User fills the advance percentage "<Advance>"
    And User saves the Credit Program on the Opportunity
    Examples:
      | Credit           | Days | Advance |
      | BNPL-IFC-JSWSCPL | 10   | 40      |

  @ZohoCreditOrder
  Scenario Outline: User Selects the credit on the Opportunity page
    When User click on Select Credit button
    And User marked Credit requirement as Required
    And user chose the credit program on the Opportunity "<Credit>"
    And User selects the credit Days on the Opportutnity "<Days>"
    And User fills the advance percentage "<Advance>"
    And User saves the Credit Program on the Opportunity
    Examples:
      | Credit           | Days | Advance |
      | Channel finance-TATA | 0   | 40      |

  @ConstCreditOrder @ZohoCreditOrder
  Scenario Outline: User updates the seller PI and sends it to the seller
    Given the user navigates to the file page
    And the user chooses the seller PI
    And the user sets the seller PI
    Then the stage of the opportunity is now "<Stage>"
    Examples:
      | Stage            |
      | Awaiting Payment |

  @ConstCreditOrder @ZohoCreditOrder
  Scenario: User creates an order, captures the subtotal, and order number
    Given the user is on the account page for order creation
    When the user clicks on the create order button
    And the user captures the subtotal for the order
    Then the user prints the subtotal and indicates it as the total value for the order
    And the user clicks on the button to create an order for coils
    And the user captures the order number
    Then the user prints the order number
    And the date and time of the report is given





