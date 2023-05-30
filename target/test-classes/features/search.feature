#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Search item and verify product details on Amazon
  This feature is used to search for Nikon Camera that contains a string (“Nikon D3X”) in the header details 
  after sorting from highest price to lowest

  @tag1
  Scenario: Search for Nikon, sort results, and verify product details
    Given User has to be on Amazon home page
    When User search for "Nikon"
    And Clicks on the search button
    When User is on the search result page
    Then User select highest to lowest on the sort dropdown menu
    And User select the second product from the list
    Then User can confirm if the details header contains the text "Nikon D3X"
    Then Browser should close
