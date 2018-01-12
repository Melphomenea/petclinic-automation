Feature: Landing Page

#REQ-01: check whether it is possible to find the unique owner by the last name. (You can use an empty search request in order to see all owners available in the database)
  Scenario: Find the unique owner by the last name
    Given I am on the Landing page
    And I click the Find Owners link
    And I click Find Owners button
    And I check the last names of the owners
    Then I should be able to filter unique owners in the command line

    #TODO Write names in a txt file
    #TODO What happens when first or last name has more than one word? Marrie Anne Van Gogh


#REQ-02: check whether it is possible to find several owners with the same last name.
  Scenario: Find the owners with same last name
    Given I am on the Landing page
    And I click the Find Owners link
    And I click Find Owners button
    And I check the last name for same ones
    Then I should be able to see owners with the same name


#REQ-03: check the system behaviour when the owner can't be found in the database
  Scenario: System behavior for owners not in the db
    Given I am on the Landing page
    And I click the Find Owners link
    And I enter my name in the search field
    Then Text stating that the owner has not been found is displayed