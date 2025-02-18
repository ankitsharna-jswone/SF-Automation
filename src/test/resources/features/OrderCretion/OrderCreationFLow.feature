@generic
Feature: Generic Order Creation Automation Script

  Scenario Outline: Complete Order Creation Process
    Given the browser and driver are set for automation "<Browser>"
    And the user logs in to Salesforce with "<Username>" and "<Password>" at "<Link>"
    And the user selects the "<App>" app
    And the user navigates to the "<Account>" account
    And the user creates an opportunity with product "<Product>", quantity "<Quantity>", thickness "<Thickness>", and width "<Width>"
    And the user processes the opportunity with delivery type "<Delivery Type>", address "<Address>", delivery time "<Days>", special message "<Special Message>", advance "<Advance>", seller "<Seller>", source seller type "<SourceSeller>", and cost "<Cost>"
    And the user sends the opportunity for pricing to category "<Category>"
    And the user updates the customer-accepted price to "<CustomerPrice>" with category price "<CPrice>" and override reason "<OverrideReason>"
    And the user requests PI to the category team "<Category>"
    And the user requests PI to the seller
    And the user updates the seller PI and sets the stage to "<Stage>"

    Examples:
      | Browser | Link                                                                         | Username                | Password  | App | Account               | Product                    | Quantity | Thickness | Width | Delivery Type | Days | Special Message        | Advance | Seller                                | SourceSeller | Address  | Cost | Category     | OverrideReason      | CPrice | CustomerPrice | Stage            |
      | chrome  | https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/page/home | ankit.sharma@jsw.in.uat | @Bhuvi176 | MFG | VEDANTA LIMITED - TPP | MS HR Coil 2062:2011 E250A | 5        | 10        | 1500  | Self pickup   | 2    | Urgent delivery needed | 5       | L&G Steel & Commodities(P) Ltd (JODL) | JODL         | A-104661 | 100  | Mfg Category | Negotiated to a better price | 100    | 100.1   | Awaiting Payment |