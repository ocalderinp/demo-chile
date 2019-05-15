Feature: Realizar reservas
  Con el objetivo de probar la funcionalidad de reserva
  Como usuario comun
  Quiero realizar la reserva de un vuelo

  @Reservas
  Scenario Outline: Reserva Satisfactoria
    Given navego a la pagina de inicio
    Then verifico que estoy en la pagina de inicio
    And completo los datos de mi reserva "<desde>", "<a>", "<salida>", "<regreso>", "<clase>" y "<pasajeros>"
    And presiono boton buscar
    Then verifico que estoy en la pagina de vuelos
    And verifico los datos de mi busqueda "<pasajeros>", "<clase>", "<salida>" y "<regreso>"
    And verifico que hay resultados para mi busqueda
    Then selecciono el primer resultado
    And verifico que estoy en la pagina de pago
    Then introduzco los datos de mi tarjeta "<tipo>", "<numero>", "<cvc>", "<mesCaducidad>", "<yearCaducidad>", "<nombre>", "<apellido>" y "<pais>"
    And presiono boton comprar
    Then verifico que estoy en la pagina de confirmacion de reserva
    And verico que mi reserva fue confirmada
    And verifico datos de pago "<nombre>", "<apellido>", tipo de tarjeta "<tipo>" y "<pais>"
    Examples:
      | desde            | a            | salida     | regreso    | clase   | pasajeros | tipo | numero           | cvc | mesCaducidad | yearCaducidad | nombre | apellido      | pais    |
      | Montevideo (MVD) | La Paz (LPB) | 09/25/2019 | 10/11/2019 | Turista | 2         | Visa | 1111111111111111 | 123 | 5            | 2022          | test   | automatizados | Uruguay |
