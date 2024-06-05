@profile
Feature: Profile based order creation
  Scenario: Setting up enviroment for the the project
    Given Set the file and driver and configuration

  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username            | Password | Link                                                          |
      |salestestuser@jsw.in.replica| Spring@25 |https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |

  Scenario Outline: User navigates to a specific account from the homepage
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      | Test Account B |

  Scenario Outline: Sales user initiates the Opportunity
    Given User is on the Account page
    And User click on the dropdown and click on the quick opportunity button
    When User choose the manufacturing type of Opportunity
    And the user adds a new opportunity
    And the user searches for the product "<Product>"
    And the user selects the product "<Product>"
    And the user sets the quantity to "<Quantity>"
    And the user sets the thickness to "<Thickness>"
    And the user selects the width as "<Width>"
    And the user saves the opportunity
    Examples:
      | Product      | Quantity | Thickness | Width |
      | MS HR Coil 2062:2011 E250A  | 5   | 1000 | 1500 |


  Scenario Outline: User processes an opportunity to the sales team and fills required documents
    Given the user is on the opportunity processing page
    When the user clicks on the process opportunity button
    And the user selects to edit the opportunity
    And the user edits the delivery type to "<Delivery Type>"
    And the user edits the delivery time to "<Days>" days
    And the user edits the special message to "<Special Message>"
    And the user saves the opportunity
    And User saves the Opportunity name

    Examples:
      | Delivery Type | Days | Special Message        |
      |     Self pickup    | 2    | Urgent delivery needed |


  Scenario: User sends the file to pricing to the category team
    When Sales team clicks on the price awaiting section
    And the user performs the category user test
    And the user saves the category
    And the user saves the opportunity


  Scenario: Sales logs out
    Given user clicks on account button
    And User clicks on log out button

  Scenario Outline: Category team logs inside of the system

    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
    | Username | Password |
    |category123@gmail.com|Category@123|


  Scenario Outline: Category user updates the Price and seller for the Opportunity
    Given Category team Searches the opportunity
    And User opens the Opportunity page
    When the user clicks on the process opportunity button
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user selects the category price as "<Price>"
    And the user edits the cost price to "<Cost>"
    And the user saves the opportunity
  Examples:
    | Cost  | Seller     | Price |
    |  150  |    Vee     |  160  |

