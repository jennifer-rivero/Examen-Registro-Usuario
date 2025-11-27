Feature: Realizar registro exitoso

  Scenario Outline: Registrar usuario
    Given que estoy en la página principal de My Store
    When hago clic en el botón Iniciar sesión
    And doy clic en el link ¿No tiene una cuenta? Cree una aquí
    And selecciono el tratamiento "<tratamiento>"
    And completo el formulario de registro con "<nombre>", "<apellido>", "<email>", "<password>", "<fecha>"
    And acepto los términos y la política de privacidad
    And acepto la privacidad de los datos del cliente
    And hago clic en el botón Guardar
    Then debería ver mi cuenta creada con éxito
    Examples:
      | tratamiento | nombre   | apellido | email                       | password          | fecha       |
      | Sra.        | Jennifer | RM       | jennifer_rm_18@gmail.com    | Jennifer_rm_01#$  | 27/07/1997  |


