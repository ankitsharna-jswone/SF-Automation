@prof @regression

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
      |salestestuser@jsw.in.replica| @Sales123 |https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |

  Scenario Outline: User navigates to a specific account from the homepage
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      | Test Account B |

  Scenario Outline: Sales user initiates the Opportunity
    Given User is on the Account page
    When the user creates a quick opportunity
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
    And the user saves the opportunity
    And User saves the Opportunity name

    Examples:
      | Delivery Type | Days | Special Message        |
      |     Self pickup    | 2    | Urgent delivery needed |


  Scenario Outline: Sales team Handover the Opportunity to the respective Category folk
    Given User is on Opportunity page
    When User clicks on the Handover Opportunity to category team
    Then User Searches the "<Category>" user for that opportunity
    Then User clicked on next button
    Examples:
     |Category |
     | Category Test user |



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
#
#
  Scenario Outline: Category user updates the Price and seller for the Opportunity
    Given Category team Searches the opportunity
    And User opens the Opportunity page
    When the user clicks on the process opportunity button
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user selects the category price as "<Price>"
    And the user edits the cost price to "<Cost>"
    And the user saves the opportunity
#    And the user verifies the customer-accepted price
    And the user saves the opportunity
  Examples:
    | Cost  | Seller     | Price |
    |  150  |    Vee     |  160  |


  Scenario: Category team logs out
    Given user clicks on account button
    And User clicks on log out button

#
  Scenario Outline: Sales team logs inside of the system

    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username | Password |
      |salestestuser@jsw.in.replica| @Sales123 |



    Scenario Outline: Sales user Request PI to Category
      Given Sales team Searches the opportunity
      Given User opens the Opportunity page
      Given the user clicks on the process opportunity button for PI to category team
      When the user saves the opportunity
      Given the user requests PI to the category team
      And the user selected the "<Category>"
      When the user saves the category user
      And the user saves the opportunity for sales
    Examples:
    | Category|
    |category user test|

  Scenario: Sales team logs out
    Given user clicks on account button
    And User clicks on log out button

  Scenario Outline: Category team log in again inside of the system
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username | Password |
      |category123@gmail.com|Category@123|


  Scenario: User request PI to Seller team
    Given Category team Searches the opportunity
    And User opens the Opportunity page
    When the user clicks on the process opportunity button
    Given User processed opportunity to send PI to seller
    And the user saves the final order
    Then the user requests PI to the seller
    And the user saves the final order



