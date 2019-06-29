#Autor: gamzeozr52@gmail.com
Feature: Add Employee

  Background: 
    And I see OrangeHrm logo
    And I log in into OrangeHrm site
    When I click on PIM link
    And I click on Add Employee link

  Scenario Outline: Add Employee
    And I provide Employee details "<name>" and "<lastName>" and "<location>"
    And I click on add Employee save button
    Then I see employee is added successfully "<firstName>" and "<lastName>"

    Examples: 
      | firstName | lastName | location  |
      | mehmet2   | sahin    | OfficeTwo |

  #   | semih2  | sahin    | OfficeThree |
  #   | gizem3  | sahin    | OfficeFive  |
  #   | fevzi4  | sahin  | Red Office  |
  
  
  Scenario Outline: Add Employee and Create Login Details
    When I provide "<firstName>","<middleName>","<lastName>" and "<location>"
    And I click on create login details
    And I provide "<userName>", "<password>","<confirmPassword>", "<essRole>" and "<supervisorRole>" fields
    And I click on add Employee save button
    Then I see employee is added successfully "<firstName>" and "<lastName>"
    Examples: 
      | firstName | middleName | lastName | location  | userName | password       | confirmPassword | essRole | supervisorRole |
      | mehmet7   | kardes     | sahin    | OfficeTwo | mehmet7  | Mehmetsahin7_- | Mehmetsahin7_- | default | default        |


 
  Scenario: Add Employee labels Verification
    Then I see following labels
      | First Namess |
      | Middle Name |
      | Last Name   |
      | Employee Id |
      | Location    |
   
   
   @test
  Scenario: Add Employee with Excel File
    And I provide all details "EmployeeDetails" from excel file
  # And I click on add Employee save button
	#	Then I see employee is added successfully 
		
		