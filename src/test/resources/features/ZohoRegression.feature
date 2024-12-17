@ZOHOcredit @regression
Feature: Zoho regression on Boarding for testing

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
      | Username                         | Password     | Link                                                                         |
      | ankit.sharma@jsw.in.uat  | @Bhuvi176  | https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/page/home |


  Scenario Outline: User changes the App According to the Profile
    Given User clicks on the App section of Salesforce
    And User searches for the "<App>" for work
    And User selects the "<App>"
    Examples:
      | App |
      |MFG |

  @smoke
  Scenario Outline: User navigates to a specific account from the homepage
    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      | VEDANTA LIMITED - TPP |




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
      | Product      | Quantity | Thickness | Width |
      |  MS HR Coil 2062:2011 E250A | 10   | 1000 | 1500 |


  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selected the Delivery address "<Address>"
    And the user selectes the credit required as YES
    And User selects the credit "<Program>" for the user
    And the user Selects the "<Credit Days>" for the program
    And Then User filled the advance % "<Advance>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        | Program         | Advance | Address | Credit Days |
      | Self pickup   | 2    | Urgent delivery needed | BNPL - JODL-BNPL |   30  | A-104725|  2    |

  Scenario Outline: User sends the file to pricing to the category team
    When the user selects the category price as "<CPrice>"
    And the user edits the cost price to "<Price>"
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user Selects the source seller type "<SourceSeller>"
    And the user saves the opportunity
    When Sales team clicks on the price awaiting section
    And the user selected the category user "<Category>"
    And the user saves the category
    And the user saves the opportunity
    Examples:
      | CPrice | Price | Seller | SourceSeller| Category |
      | 120    | 100    | V K Industrial Corporation Ltd |    JODL        | Mfg Category |

  Scenario Outline: User selects the credit program on the Credit program on Opportunity page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity
    Examples:
      | Price |
      | 150    |


  Scenario Outline: User request PI to Category team
    When the user verifies the customer-accepted price
    When the user requests PI to the category team
    And the user selected the category user "<Category>"
    And the user saves the category user
    Examples:
    | Category |
    | Mfg Category |


  Scenario: User request PI to Seller team
    Then the user requests PI to the seller
    And user saved the opportunity
    Then The stage of opportunity will be printed

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



    