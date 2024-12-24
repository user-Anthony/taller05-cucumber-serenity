@delete
Feature: Eliminar
  Background:
    Given el qa agrega una tarea e ingresa un titulo de tarea "Tarea 1"
    And el qa ingresa una descripcion de tarea "Decripcion tarea 1"
    And el qa guarda la tarea
    And el qa verfica que la tarea se creo correctamente como "Tarea 1"
    When el qa ingresa a la tarea "Tarea 1"


  Scenario: Eliminar tarea correctamente
    And el qa da click en eliminar
    And el qa confirma la eliminacion
    Then el qa tiene que visualizar el texto "No tasks added"
