@pricing @regression
Feature: Profile based order creation

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
      | bhushan.sawant@jsw.in.prod | Pass@123 | https://jswoneplatforms.lightning.force.com/lightning/page/home |

  Scenario Outline: User navigates to a specific account from the homepage
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account           |
      | TEST ACCOUNT B |

  Scenario: User creates Multiple opportunity with a specific product and quantity
    Given the user is on the account page
    When the user creates a quick opportunity
    And Add multiple products in SKU according to given Data
      | Product                     | Quantity | UOM     | Thickness | Width | Length | Diameter |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 2.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 3.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 4.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 5.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 6.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 7.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 8.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 9.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 10.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 11.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 12.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 13.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 14.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 15.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 16.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 17.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 18.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 19.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 20.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 21.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 22.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 23.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 24.5       | 1250  |        |          |
      | MS HR Coil 2062:2011 E250A  | 10       | Primary | 25.5       | 1250  |        |          |

    Then the user saves the opportunity


  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user selected the Delivery address "<Address>"
    And Then User filled the advance % "<Advance>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    Examples:
      | Delivery Type | Days | Special Message        | Advance | Address  |
      | JOTS          | 2    | Urgent delivery needed | 30      | A-104507 |

  Scenario Outline: User Handover the Opportunity to the Category Team
    And the user saves the opportunity
    When Sales team clicks on the price awaiting section
    And the user selected the category user "<Category>"
    And the user saves the category
    And the user saves the opportunity
    And User saves the Opportunity name
    Examples:
      | Category     |
      | Mfg Category |


#  Scenario: Sales user logs out
#    Given user clicks on account button
#    And User clicks on log out button


#  Scenario Outline: Category team logs inside of the system
#    Given the user navigates to the Salesforce login page "<Link>"
#    When the user enters the username "<Username>"
#    And the user enters the password "<Password>"
#    And the user clicks on the login button
#    Examples:
#      | Username | Password | Link |
#      |mfgcategory@yopmail.com|@Winter123|https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/page/home |
#
#
#  Scenario: Category user updates the Price and seller for the Opportunity
#    Given Category team Searches the opportunity
#    And User opens the Opportunity page