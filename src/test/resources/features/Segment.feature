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
      | Username              | Password  | Link                                                           |
      |v_ankit.sharma@jsw.in| @Ankit123| https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/page/home |


  Scenario Outline: User navigates to a specific account from the homepage

    Given the user opens the search tab
    When the user searches for the item "<Account>"
    And the user clicks on the search result for "<Account>" accounts
    And the user opens the account "<Account>"
    Examples:
      | Account        |
      | MITTAL STEEL MANUFACTURING COMPANY (STEEL DIVISION) |

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
      | Pipes & Tubes                       |
      | Buildings - HVAC                    |
      | Retail                              |
      | Infra - Public                      |
      | Infra - Transport                   |
      | Infra - Energy                      |
      | Infra - Water                       |
      | Automotive                          |
      | Industrial and Machinery            |
      | Consumer Goods and Appliances       |
      | Packaging                           |
      | Healthcare and Medical Equipment    |
      | Defense and Military                |
      | Agriculture                         |
      | Telecommunications                  |
      | Pressure Vessels and Tanks          |
      | Processors                          |
    When User sets the value for the subCategory for each Category
      | Buildings - Residential | Buildings - Commercial | Buildings - Industrial           | Buildings - Components & extensions | Pipes & Tubes    | Buildings - HVAC | Retail                           | Infra - Public             | Infra - Transport                                 | Infra - Energy            | Infra - Water               | Automotive                                                             | Industrial and Machinery                          | Consumer Goods and Appliances          | Packaging                                                    | Healthcare and Medical Equipment | Defense and Military | Agriculture    | Telecommunications | Pressure Vessels and Tanks     | Processors        |
      | Luxury                  | Offices                | Warehouse (PEB)                  | Racks, storage, parking, lifts      | PVC              | Ventilation      | Buildings                        | Education                  | Bridges & support frames                          | Oil and Gas               | Water supply                | Auto components - body panels                                          | Heavy Machinery                                   | Appliances - AC                        | Food and Beverage - Cans & containers                        | Medical Devices                  | Vehicles             | Infrastructure | Towers             | LPG - Tanks & cylinders        | RMC               |
      | Affordable              | Retail Centres         | Warehouse (Civil)                | Clean room panels, doors            | Precision Tubes  | Ducts            | Building components & extensions | Healthcare                 | Tunnels & support frames                          | Power Plants              | Sewage and Waste Management | Auto components - chassis, frames, press parts & structural components | Manufacturing Equipment - Welding wire converters | Appliances - Washing machines          | Food and Beverage and others - Caps & others                 | --None--                         | Weapons              | Equipment      | Infrastructure     | LPG - distribution             | Blocks and bricks |
      | Economy                 | Hospitality            | Power Plant Development          | Others                              | Structural Tubes | Radiators        | Automotive                       | Social welfare             | Roads and Highways - Guard rails & crash barriers | Renewable Energy - Solar  | Treatment plants            | Auto components - engine components                                    | Manufacturer - TMT / Re - Rollers / Bright Bars   | Appliances - Refrigeration             | Industrial Packaging - Drums & barrels                       |                                  | Infrastructure       | --None--       | --None--           | LPG - Valve & safety devices   | Hume pipes        |
      | --None--                | Financial              | Manufacturing Facilities (PEB)   | --None--                            | Conveyance Tubes | Cooling          | Infra energy                     | Sports Facilities          | Road furniture                                    | Renewable Energy - Others | Storm water                 | Auto components - transmission                                         | Manufacturing Equipment - Others                  | Appliances - Dish Antenna              | Industrial Packaging - Oil, industrial chemicals, food pulps |                                  | --None--             |                |                    | Boiler and pressure equipments | Poles             |
      |                         | Entertainment          | Manufacturing Facilities (Civil) |                                     | --None--         | Others           | Industrial and Machinery         | Tourism                    | Roads and Highways - civil work                   |                           | Irrigation                  | Auto components - Others                                               | Mining Equipment & Yellow Goods                   | Appliances - Fans, axial fans, geysers | Industrial Packaging - Others                                |                                  |                      |                |                    | --None--                       | Pavers            |
      |                         | Restaurants            | Storage facilities               |                                     |                  | --None--         | Consumer Goods and Appliances    | Telecommunications - Tower | Railway Infrastructure                            | --None--                  | --None--                    | Aerospace                                                              | Hardware Accessories - Fasteners                  | Appliances - Switches & panels         | --None--                                                     |                                  |                      |                |                    |                                | Boards and sheets |
      |                         | Data Centers           | Industrial Parks                 |                                     |                  |                  | Packaging                        | Telecommunications - Infra | Railway rolling stock                             |                           |                             | --None--                                                               | Hardware Accessories - Others                     | Appliances - others                    |                                                              |                                  |                      |                |                    |                                | --None--          |
      |                         | --None--               | --None--                         |                                     |                  |                  | Telecommunications               | --None--                   | Shipbuilding                                      |                           |                             |                                                                        | --None--                                          | Casing and frames for electronic goods |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  | Pressure Vessels and Tanks       |                            | Airports                                          |                           |                             |                                                                        |                                                   | Furniture                              |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  | Retailers                        |                            | Metro                                             |                           |                             |                                                                        |                                                   | --None--                               |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  | --None--                         |                            | Bus terminal                                      |                           |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  | Agriculture                      |                            | EV infra                                          |                           |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            | Ports                                             |                           |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
      |                         |                        |                                  |                                     |                  |                  |                                  |                            | --None--                                          |                           |                             |                                                                        |                                                   |                                        |                                                              |                                  |                      |                |                    |                                |                   |
    Then User fetchs the date from the segment and assert with the respective array

