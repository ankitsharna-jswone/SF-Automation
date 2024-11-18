@multiSeg @regression
Feature: Create Order in SF using this Script

  Scenario: Setting up enviroment for the the project
    Given Set the file and driver and configuration


  Scenario Outline: User logs in to Salesforce
    Given the user navigates to the Salesforce login page "<Link>"
    When the user enters the username "<Username>"
    And the user enters the password "<Password>"
    And the user clicks on the login button
    Examples:
      | Username              | Password  | Link                                                                                |
      | v_ankit.sharma@jsw.in | @Ankit123 | https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/page/home |


  Scenario Outline: User navigates to a specific account from the homepage
    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    And they moved to the site tab
    Then they should be on the "<Site>" site page
    Examples:
      | Account             | Site        |
      | CHAKRESH INDUSTRIES | Global city |

#  construct
  Scenario: User navigates to Segment and Subsegment for testing
    Given User scrolls down to the Edit segment button
    And User clicks on Edit segment button
    When User validated the fields newly added to the category
      | Category                            |
      | --None--                            |
      | Buildings - Residential             |
      | Buildings - Commercial              |
      | Buildings - Industrial              |
      | Buildings - Components & extensions |
      | Buildings - HVAC                    |
      | Infra - Public                      |
      | Infra - Transport                   |
      | Infra - Energy                      |
      | Infra - Water                       |
      | Processors                          |

    When User sets the value for the subCategory for each Category
      | Buildings - Residential | Buildings - Commercial | Buildings - Industrial           | Buildings - Components & extensions | Buildings - HVAC | Infra - Public             | Infra - Transport                                 | Infra - Energy           | Infra - Water               | Processors        |
      | Luxury                  | Offices                | Warehouse (PEB)                  | Racks, storage, parking, lifts      | Ventilation      | Education                  | Bridges & support frames                          | Oil and Gas              | Water Supply                | RMC               |
      | Affordable              | Retail Centres         | Warehouse (Civil)                | Clean room panels, doors            | Ducts            | Healthcare                 | Tunnels & support frames                          | Power Plants             | Sewage and Waste Management | Blocks and bricks |
      | Economy                 | Hospitality            | Power Plant Development          | Others                              | Radiators        | Social welfare             | Roads and Highways - Guard rails & crash barriers | Renewable Energy - Solar | Treatment plant             | Hume pipes        |
      |                         | Financial              | Manufacturing Facilities (PEB)   |                                     | Cooling          | Sports Facilities          | Road furniture                                    | Renewable Energy -Others | Storm water                 | Poles             |
      |                         | Entertainment          | Manufacturing Facilities (Civil) |                                     | Others           | Tourism                    | Roads and Highways - civil work                   |                          | Irrigation                  | Pavers            |
      |                         | Restaurants            | Storage facilities               |                                     |                  | Telecommunications - Tower | Railway Infrastructure                            |                          |                             | Boards and sheets |
      |                         | Data Centers           | Industrial Parks                 |                                     |                  | Telecommunciation - Infra  | Railway rolling stock                             |                          |                             |                   |
      | --None--                | --None--               | --None--                         | --None--                            | --None--         | --None--                   | --None--                                          | --None--                 | --None--                    | --None--          |
      |                         |                        |                                  |                                     |                  |                            | Airports                                          |                          |                             |                   |
      |                         |                        |                                  |                                     |                  |                            | Shipbuilding                                      |                          |                             |                   |
      |                         |                        |                                  |                                     |                  |                            | Metro                                             |                          |                             |                   |
      |                         |                        |                                  |                                     |                  |                            | Ports                                             |                          |                             |                   |
      |                         |                        |                                  |                                     |                  |                            | EV infra                                          |                          |                             |                   |
      |                         |                        |                                  |                                     |                  |                            | Bus terminal                                      |                          |                             |                   |
    Then User fetchs the date from the segment and assert with the respective array
    Then User saves the edit page

#
  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account                                  |
      | KERALA TRANSPORT COMPANY |
#  manufactring

  Scenario: User navigates to Segment and Subsegment for testing
    Given User refreshed the page
    Given User scrolls down to the Edit segment button
    And User clicks on Edit segment button
    When User validated the fields newly added to the category
      | Category                            |
      | --None--                            |
      | Buildings - Residential                      |
      | Buildings - Commercial                       |
      | Buildings - Industrial                       |
      | Buildings - Components & extensions          |
      | Pipes & Tubes                                |
      | Buildings - HVAC                             |
      | Retail                                       |
      | Infra - Public                               |
      | Infra - Transport                            |
      | Infra - Energy                               |
      | Infra - Water                                |
      | Automotive                                   |
      | Aerospace                                    |
      | Industrial and Machinery                     |
      | Consumer Goods and Appliances                |
      | Packaging                                    |
      | Healthcare and Medical Equipment             |
      | Defense and Military                         |
      | Agriculture                                  |
      | Telecommunications                           |
      | Pressure Vessels and Tanks                   |
      | Processors                                   |
      | Retailers                                    |

    When User sets the value for the subCategory for each Category
      | Buildings - Residential | Buildings - Commercial | Buildings - Industrial           | Buildings - Components & extensions | Pipes & Tubes    | Buildings - HVAC | Retail                           | Infra - Public             | Infra - Transport                                 | Infra - Energy           | Infra - Water               | Automotive                                                             | Industrial and Machinery                          | Consumer Goods and Appliances          | Packaging                                                    | Healthcare and Medical Equipment | Defense and Military | Agriculture    | Telecommunications | Pressure Vessels and Tanks     | Processors        |
      | Luxury                  | Offices                | Warehouse (PEB)                  | Racks, storage, parking, lifts      | PVC              | Ventilation      | Buildings                        | Education                  | Bridges & support frames                          | Oil and Gas              | Water Supply                | Auto components - body panels                                          | Heavy Machinery                                   | Appliances - AC                        | Food and Beverage - Cans & containers                        | Medical Devices                  | Vehicles             | Equipment      | Towers             | LPG - Tanks & cylinders        | RMC               |
      | Affordable              | Retail Centres         | Warehouse (Civil)                | Clean room panels, doors            | Precision Tubes  | Ducts            | Building components & extensions | Healthcare                 | Tunnels & support frames                          | Power Plants             | Sewage and Waste Management | Auto components - chassis, frames, press parts & structural components | Manufacturing Equipment - Welding wire converters | Appliances - Washing machines          | Food and Beverage and others - Caps & others                 | --None--                         | Infrastructure       | Infrastructure | Infrastructure     | LPG - distribution             | Blocks and bricks |
      | Economy                 | Hospitality            | Power Plant Development          | Others                              | Structural Tubes | Radiators        | Retailers                        | Social welfare             | Roads and Highways - Guard rails & crash barriers | Renewable Energy - Solar | Treatment plant             | Auto components - engine components                                    | Manufacturer - TMT / Re - Rollers / Bright Bars   | Appliances - Refrigeration             | Industrial Packaging - Drums & barrels                       |                                  | Weapons              | Retail         |                    | LPG - Valve & safety devices   | Hume pipes        |
      | --None--                | Financial              | Manufacturing Facilities (PEB)   |                                     | Conveyance Tubes | Cooling          | --None--                         | Sports Facilities          | Road furniture                                    | Renewable Energy -Others | Storm water                 | Auto components - transmission                                         | Manufacturing Equipment - Others                  | Appliances - Dish Antenna              | Industrial Packaging - Oil, industrial chemicals, food pulps |                                  | --None--             | --None--       | --None--           | Boiler and pressure equipments | Poles             |
      |                         | Entertainment          | Manufacturing Facilities (Civil) |                                     | --None--         | Others           |                                  | Tourism                    | Roads and Highways - civil work                   | --None--                 | Irrigation                  | Auto components - Others                                               | Mining Equipment & Yellow Goods                   | Appliances - Fans, axial fans, geysers | Industrial Packaging - Others                                |                                  |                      |                |                    | --None--                       | Boards and sheets |
      |                         | Restaurants            | Storage facilities               |                                     |                  | --None--         |                                  | Telecommunications - Tower | Railway Infrastructure                            |                          | --None--                    | --None--                                                               | Hardware Accessories - Fasteners                  | Appliances - Switches & panels         | --None--                                                     |                                  |                      |                |                    |                                | --None--          |
      |                         | --None--               |                                  |                                     |                  |                  |                                  | --None--                   | --None--                                          |                          |                             |                                                                        | --None--                                          | Casing and frames for electronic goods |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        | --None--                         |                                     |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   | Furniture                              |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  | --None--                            |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   | --None--                               |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            |                                                   |                          |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |

    Then User fetchs the date from the segment and assert with the respective array

