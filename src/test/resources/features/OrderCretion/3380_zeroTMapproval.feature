@zeroTM @regression
Feature: Advance Approval Automation Script SF 3453

  Scenario Outline: Setting up enviroment for the the project
    Given Set the browser and driver for the automation "<Browser>"
    And User passes driver to the other pages and files
    Examples:
      | Browser |
      | chrome  |

  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username                | Password  | Link                                                                         |
      | ankit.sharma@jsw.in.uat | @Bhuvi176 | https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/page/home |

  Scenario Outline: User changes the App According to the Profile
    Given User clicks on the App section of Salesforce
    And User searches for the "<App>" for work
    And User selects the "<App>"
    Examples:
      | App |
      | MFG |


  Scenario Outline: User navigates to a specific account from the homepage
    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account           |
      | VEDANTA LIMITED - TPP|

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
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user Selects the source seller type "<SourceSeller>"
    And Then User filled the advance % "<Advance>"
    And the user edits the cost price to "<Cost>"
    And the user saves the opportunity

    Examples:
      | Delivery Type | Days | Special Message        | Advance | Seller | SourceSeller | Address  |Cost|
      | Self pickup   | 2    | Urgent delivery needed | 5       | Vee    | Marketplace  | A-104725 | 100|


  Scenario Outline: User sends the file to pricing to the category team
    When Sales team clicks on the price awaiting section
    And the user selected the category user "<Category>"
    And the user saves the category
    And the user saves the opportunity
    Examples:
      | Category     |
      | Mfg Category |

  Scenario Outline: User updates the customer-accepted price after receiving pricing from the category
    Given the user clicks on the process opportunity button for pricing
    And User click on Override prices button as True
    And User selects the Reason for override "<OverrideReason>"
    When the user selects the category price as "<CPrice>"
    When user sets the customer-accepted price to "<Price>"
    And the user saves the opportunity for pricing
    And the user verifies the customer-accepted price
    And the user saves the opportunity for pricing
    Examples:
      | Price | CPrice | OverrideReason      |
      | 100 | 100.1    | Price not available |


  Scenario Outline: User requests PI to the category team
    Given the user clicks on the process opportunity button for PI to category team
    And the user saves the opportunity first
    And the user requests PI to the category team
    And the user selected the category user "<Category>"
    And the user saves the category user
    And the user saves the opportunity for sales

    Examples:
      | Category     |
      | Mfg Category |

  Scenario: User request PI to Seller team
    When the user clicks on the process opportunity button
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


#https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006Ik000003MoMNIA0/view