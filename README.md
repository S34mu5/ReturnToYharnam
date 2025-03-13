# Ejercicio de Herencia y Clases Abstractas - Bloodborne

## Instrucciones del ejercicio

Los estudiantes deberán completar las siguientes tareas:

1. **Estudiar las clases abstractas proporcionadas** para entender su estructura y funcionamiento.

2. **Crear tres clases concretas de Cazadores** que hereden de la clase abstracta `Cazador`.

   - Cada clase debe implementar todos los métodos abstractos.
   - Asignar características y comportamientos únicos a cada tipo de cazador.
   - Ejemplos: `CazadorFuerza`, `CazadorDestreza`, `CazadorArcano`.

3. **Crear tres clases concretas de Enemigos** que hereden de la clase abstracta `Enemigo`.

   - Implementar adecuadamente todos los métodos abstractos.
   - Dotar a cada enemigo de habilidades específicas que lo diferencien.
   - Ejemplos: `BestiaDeLaPlaga`, `BestiaClerigo`, `CazadorCorrompido`.

4. **Implementar todos los métodos abstractos requeridos** en cada una de las clases concretas.

   - Para los Cazadores: `atacar()`, `usarHabilidadEspecial()`, `transformarArma()`
   - Para los Enemigos: `atacar()`, `ataqueEspecial()`, `comportamientoFaseCritica()`

5. **Añadir características únicas a cada clase** más allá de la implementación básica.

   - Atributos adicionales específicos.
   - Métodos propios que enriquezcan la funcionalidad.
   - Comportamientos que reflejen la temática de Bloodborne.

6. **Demostrar la funcionalidad en el método main** de la clase `EjercicioBloodborne`.
   - Crear instancias de las clases implementadas.
   - Mostrar el comportamiento de los diferentes métodos.
   - Simular interacciones entre cazadores y enemigos.

## Recursos disponibles

- `Cazador.java`: Clase abstracta base para los personajes principales.
- `Enemigo.java`: Clase abstracta base para los adversarios.
- `BestiaLicantropaEjemplo.java`: Ejemplo de implementación de un enemigo.
- `EjercicioBloodborne.java`: Contiene la clase `CazadorDestreza` como ejemplo.

## Enemigos oficiales de Bloodborne sugeridos

- **Bestia de la Plaga (Scourge Beast)**: Los hombres lobo que atacan en las calles de Yharnam.
- **Bestia Clérigo (Cleric Beast)**: Una enorme bestia con un brazo más desarrollado que el otro y gran poder.
- **Cazador Corrompido (Huntsman)**: Habitantes de Yharnam que han sucumbido a la locura y cazan a otros.
- **Bestia Sedienta de Sangre (Blood-starved Beast)**: Criatura veloz y venenosa con piel colgante.
- **Caballero de la Iglesia (Church Servant)**: Sirvientes de la Iglesia de la Sanación armados con armas largas.
- **Succionador de Cerebros (Brainsucker)**: Criaturas arcanas con tentáculos que atacan con magia.


