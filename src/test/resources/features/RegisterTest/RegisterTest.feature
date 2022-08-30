#language:es

  Característica: Validar el adicionar un nuevo registro y
    la eliminacion de cualquier registro que este en la tabla de la seccion web tables

  Esquema del escenario: Validar la adicion de registro en la tabla
    Dado El usuario navega en la aplicacion web
    Entonces El decide registrarse con su nombre, <nombre> apellido, <apellido> correo, <correo> edad, <edad> salario, <salario> departamento, <departamento>

    Ejemplos:
      | nombre    | apellido  | correo               | edad | salario  | departamento |
      | Andres    | Neira     | edwineira9@gmail.com | 22   | 5600     | Zipaquira    |
      | Laura     | Niño      | lauranino@gmail.com  | 22   | 1200     | Bogota       |
      | Esperanza | Neira     | eaperanza5@gmail.com | 42   | 8000     | Soacha       |

  Esquema del escenario: Validar la eliminacion de registro en la tabla
    Dado El usuario navega en la aplicacion web
    Y El decide eliminar sus datos que estan con su nombre, <nombre> apellido, <apellido> correo, <correo> edad, <edad> salario, <salario> departamento, <departamento>

    Ejemplos:
      | nombre   | apellido  | correo               | edad  | salario  | departamento |
      | Cierra   | Vega      | cierra@example.com   | 39    | 10000    | Insurance    |
      | Alden    | Cantrell  | alden@example.com    | 45    | 12000    | Compliance   |
      | Kierra   | Gentry    | kierra@example.com   | 29    | 2000     | Legal        |
      | Test     | Test      | test@example.com     | 29    | 2000     | Test         |