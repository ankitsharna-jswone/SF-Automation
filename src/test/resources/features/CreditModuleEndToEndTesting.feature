@newCreditTest @regression
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
    | BNPL - Ankit-Credit |




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
      | Self pickup   | 2    | Urgent delivery needed | BNPL - Ankit-Credit | 30      | NEAR BAJAJ AGENCY | 5           |



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
    And the user verifies the customer-accepted price
    And the user saves the opportunity
    Examples:
      | CPrice | Price | Seller | SourceSeller| Category |
      | 120    | 100    | Vee |    Marketplace        | Category Test user |

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
      | Category Test user |



  Scenario: User request PI to Seller team
    Then the user requests PI to the seller
    And user saved the opportunity
    Then The stage of opportunity will be printed


  Scenario: Validate Credit Information for the Selected Program
    When the user should fetch the Credit Amount from the Opportunity page
    And the user should fetch the Approved Credit Days from the Opportunity page
    And the user should fetch the Credit Available from the Opportunity page
    And the user should fetch the Credit Days from the Opportunity page
    And the user should fetch the Credit Program Name from the Opportunity page
    And the user should fetch the Credit Required from the Opportunity page
    And the user should fetch the Credit Utilised from the Opportunity page
    And the user should fetch the Blocked Limit from the Opportunity page
    And the user should fetch the Program Credit from the Opportunity page
    And the user should fetch the Credit Expiry Date from the Opportunity page
    And the user should fetch the Credit Program Type from the Opportunity page
    And the user should fetch the Penal Interest from the Opportunity page
    And the user should fetch the API response for the selected Credit Program
    Then the Credit Amount from the Opportunity page should match the Credit Amount in the API response
    And the Approved Credit Days from the Opportunity page should match the Approved Credit Days in the API response
    And the Credit Available from the Opportunity page should match the Credit Available in the API response
    And the Credit Days from the Opportunity page should match the Credit Days in the API response
    And the Credit Program Name from the Opportunity page should match the Credit Program Name in the API response
    And the Credit Required from the Opportunity page should match the Credit Required in the API response
    And the Credit Utilised from the Opportunity page should match the Credit Utilised in the API response
    And the Blocked Limit from the Opportunity page should match the Blocked Limit in the API response
    And the Program Credit from the Opportunity page should match the Program Credit in the API response
    And the Credit Expiry Date from the Opportunity page should match the Credit Expiry Date in the API response
    And the Credit Program Type from the Opportunity page should match the Credit Program Type in the API response
    And the Penal Interest from the Opportunity page should match the Penal Interest in the API response


