@seg
Feature: Create Order in SF using this Script

  Scenario: Setting up enviroment for the the project
    Given Set the file and driver and configuration


  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username            | Password | Link                                                          |
      |v_ankit.sharma@jsw.in| @Ankit123|https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/ |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account  |
      | Test Account B |

  Scenario: User went to the testing
    Given run this function