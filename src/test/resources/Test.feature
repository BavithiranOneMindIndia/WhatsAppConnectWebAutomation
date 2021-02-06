Feature: Testing pricemesh
  Verifing Scenarios for PriceMesh Website

  @WhatsappGetChatNames
  Scenario Outline: Lanuch Whatsapp web and collect chat details
    Given Launch chrome browser for Whatsapp web
    Given Wait for "3" seconds
    Then  Get Chat Names
    Then Quit from the Website


    Examples:
      | Project  |
      | Whatsapp |


  @WhatsappConnect
  Scenario Outline: Lanuch Whatsapp web and send content
    Given Open mobile number panel
    Given Launch chrome browser for Whatsapp web
    Given Wait for "3" seconds
    Then  Whatsappconnect Process
    Then Quit from the Website
    


    Examples:
      | Project  |
      | Whatsapp |



  @TagSmoke
  Scenario Outline: Scenario Outline name: Verify Selected items are refreshed when we change the indicator single to other main item.
    Given Launch chrome Browser for pricemesh Website
    Then Assert tile of the website
    Then Change language to "English" toggle
    Then Changing Context to second position
    Then verify whether all the selected items are deselected
    Then verify whether all the selectedSingle items are deselected
    Then Quit from the Website

    Examples:
      | Website   |
      | PriceMesh |

  @TagSmoke
  Scenario Outline: Scenario Outline name: Verify Whether the same selected items are displaying in GraphView [English] [indicated Single Label]
    Given Launch chrome Browser for pricemesh Website
    Then Assert tile of the website
    Given Wait for "1" seconds
    Then Change language to "English" toggle
    Then Check whether only the selected main lable items are displayed in graph view
    Then Quit from the Website

    Examples:
      | Website   |
      | PriceMesh |

  @TagSmoke
  Scenario Outline: Scenario Outline name: Verify whether Only one main lable has multiple selecting permission
    Given Launch chrome Browser for pricemesh Website
    Then Assert tile of the website
    Given Wait for "1" seconds
    Then Change language to "English" toggle
    Then Check for Main Labels where only one should have multiple selector permission
    Then Quit from the Website


    Examples:
      | Website   |
      | PriceMesh |


  @TagSmoke
  Scenario Outline: Asserting Website's title
    Given Launch chrome Browser for pricemesh Website
    Then Assert tile of the website
    Then Quit from the Website

    Examples:
      | Website   |
      | PriceMesh |


  @TagSmoke
  Scenario Outline: Verify by adding items and click submit and assert the graph.
    Given Launch chrome Browser for pricemesh Website
    Then Assert tile of the website
    Then Change language to "English" toggle
    # Values for below line choose between Commodity or City or Company
    Given Click search of "Commodity" button
    Then Enter "Mango" value in search field
    Then Choose searched value
    Given Wait for "5" seconds
    Then Click searchField Clear button
    Given Click search of "City" button
    Then Enter "Coimbatore" value in search field
    Then Choose searched value
    Given Wait for "1" seconds
    Then Click searchField Clear button
    Given Click search of "Company" button
    Then Enter "BigBasket" value in search field
    Then Choose searched value
    Given Wait for "1" seconds
    Then Click searchField Clear button
    Then Click Submit button
    Given Wait for "5" seconds
    Then Check whether only the selected main lable items are displayed in graph view
    Then Scroll to alert Element
    Then Quit from the Website

    Examples:
      | Website   | Language |
      | PriceMesh | English  |






