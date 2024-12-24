@create
Feature: whendo
  Scenario: create task
    Given eynar has access to whendo
    When he creates a task
      |title| JBSerenity|
      |note | this is a note|
    Then he expected the task "JBSerenity" should be displayed