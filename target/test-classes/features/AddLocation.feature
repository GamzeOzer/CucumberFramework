#Autor: gamzeozr52@gmail.com
Feature: Add Location

  Scenario Outline: Add Location
  
    And I see OrangeHrm logo
    And I log in into OrangeHrm site
    When I click on Admin link
    And I click on Organization link
    And I click on Location link
    And I click on add button
    And I provide location details "<name>" and "<country>" and "<city>" and "<zip>"
    And I click on save button
    Then I see location "<name>" is successfully added
    

    Examples: 
      | name        | country | city         | zip   |
      | OfficeFourteen   | Italy   | cityTen      | 56789 |
    #  | OfficeEleven | Spain   | cityEleven   | 56432 |
    # | OfficeEight | Italy   | cityTwelve   | 67890 |
    # | OfficeNine  | Norway  | cityThirteen | 23455 |
    # | OfficeSix   | Iran    | cityFourteen | 92345 |
