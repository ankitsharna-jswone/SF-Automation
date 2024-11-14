@newCredit
Feature: Zoho regression on Boarding for testing

  Scenario Outline: Setting up enviroment for the the project
    Given Set the file and driver and configuration
    Given the user navigates to the Salesforce login page "<Link>"
    Examples:
      | Link                                                           |
      | https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |

  Scenario Outline: User logs in to Salesforce
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  |
      | v_ankit.sharma@jsw.in | @Ankit123 |

  @smoke
  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account            |
      | RAHUL KIRANA STORE |


  Scenario Outline: Fetching Credit Program Data and Storing it for Validation
    Given the user is on the account page
    When the user goes to the Approved Credit Program tab
    When the user fetches the credit program names
    When the user fetches the usable limit amount for the credit program "<Credit Program>"
    When the user fetches the sanctioned amount for the credit program "<Credit Program>"
    When the user fetches the utilised amount for the credit program "<Credit Program>"
    When the user fetches the available amount for the credit program "<Credit Program>"
    When the user fetches the blocked amount for the credit program "<Credit Program>"
    When the user fetches the usable amount for the credit program "<Credit Program>"
    When the user fetches the credit expiry date for the credit program "<Credit Program>"
    When the user fetches the credit due days for the credit program "<Credit Program>"
    When the user fetches the penal rate for the credit program "<Credit Program>"
    When the user fetches the credit limit block for the credit program "<Credit Program>"
    When the user fetches the credit limit block reason for the credit program "<Credit Program>"
    Then the user stores the credit details in a JSON file for future validation "<Credit Program>"

    Examples:
    | Credit Program |
    | BNPL - Seller-Back |




  Scenario Outline: User creates an opportunity with a specific product and quantity
    Given the user is on the account page
    When the user creates a quick opportunity
    And the user adds a new opportunity
    And the user searches for the product "<Product>"
    And the user selects the product "<Product>"
    And the user sets the quantity to "<Quantity>"
    And the user saves the opportunity
    Examples:
      | Product                         | Quantity |
      | JSW Ordinary Portland Cement 53 | 10       |


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


