@Test
Feature: Zoho regression on Boarding for testing

  Scenario Outline: Setting up enviroment for the the project
    Given Set the browser and driver for the automation  "<Browser>"
    Given the user navigates to the Salesforce login page "<Link>"
    Examples:
      |Browser| Link                                                          |
      | chrome | https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Opportunity/006Hz00000Uzx6uIAB/view |
  Scenario Outline: User logs in to Salesforce
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  |
      | v_ankit.sharma@jsw.in | @Ankit123 |


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
      | Delivery Type | Days | Special Message        | Program           | Advance | Address           | Credit Days |
      | Self pickup   | 2    | Urgent delivery needed | BNPL-Ankit-Credit | 30      | NEAR BAJAJ AGENCY | 5           |

  Scenario Outline: User sends the file to pricing to the category team
    When the user selects the category price as "<CPrice>"
    And the user edits the cost price to "<Price>"
    And the user searches for the source seller "<Seller>"
    And the user selects the source seller "<Seller>"
    And the user Selects the source seller type "<SourceSeller>"
    And the user saves the opportunity
    When Sales team clicks on the price awaiting section
    And the user performs the category user test
    And the user saves the category
    And the user verifies the customer-accepted price
    And the user saves the opportunity
    Examples:
      | CPrice | Price | Seller | SourceSeller |
      | 120    | 100   | Vee    | JOPL         |