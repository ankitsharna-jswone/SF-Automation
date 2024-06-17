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

  Scenario: User navigates to Segment and Subsegment for testing
    Given User scrolls down to the Edit segment button
    And User clicks on Edit segment button
    When User validated the fields newly added to the category
     | Category |
     |   Buildings - Residential |
     | Buildings - Commercial    |
     | Buildings - Industrial    |
     | Buildings - Components & extensions |
     | Pipes & Tubes                       |
     | Buildings - HVAC                    |
     |  Retail                             |
     | Infra - Public                      |
     | Infra - Transport                   |
     |Infra - Energy                       |
     | Infra - Water                       |
     |Automotive                           |
     |  Industrial and Machinery           |
     |Consumer Goods and Appliances        |
     |Packaging                            |
     |Healthcare and Medical Equipment     |
     |Defense and Military                 |
     |Agriculture                          |
     |Telecommunications                   |
     |Pressure Vessels and Tanks           |
     |Processors       |
