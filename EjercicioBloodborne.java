/**
 * Ejercicio práctico sobre herencia y clases abstractas en Java
 * Basado en el videojuego Bloodborne
 * 
 * INSTRUCCIONES:
 * 
 * 1. Estudia las clases abstractas Cazador.java y Enemigo.java
 * 2. Crea tres clases concretas que hereden de Cazador:
 * - Debe implementar todos los métodos abstractos
 * - Cada clase debe tener características únicas
 * - Ejemplos: CazadorFuerza.java, CazadorDestreza.java, CazadorArcano.java
 * 3. Crea tres clases concretas que hereden de Enemigo:
 * - Debe implementar todos los métodos abstractos
 * - Cada clase debe tener características únicas
 * - Ejemplos: BestiaLicántropa.java, GranBestia.java, CazadorCorrupto.java
 * 4. En el método main de esta clase, crea instancias de tus clases y demuestra
 * su funcionamiento
 * 
 * CRITERIOS DE EVALUACIÓN:
 * - Implementación correcta de todos los métodos abstractos
 * - Uso adecuado de la herencia
 * - Originalidad en las características específicas de cada clase
 * - Funcionalidad correcta en la demostración
 */
public class EjercicioBloodborne {

    public static void main(String[] args) {
        System.out.println("Ejercicio de Herencia y Clases Abstractas - Bloodborne");
        System.out.println("--------------------------------------------------------");

        // Aquí deberás crear instancias de tus clases y demostrar su funcionamiento
        // Ejemplo:

        // CazadorFuerza cazador1 = new CazadorFuerza("Gehrman", 100, 20, 10, 15);
        // BestiaLicántropa enemigo1 = new BestiaLicántropa("Hombre Lobo de la
        // Catedral", 200, 15, 5, 500, false);

        // System.out.println(cazador1);
        // System.out.println(enemigo1);

        // System.out.println("El cazador ataca: " + cazador1.atacar() + " de daño");
        // enemigo1.recibirDanio(cazador1.atacar());
        // System.out.println("El enemigo contraataca: " + enemigo1.atacar() + " de
        // daño");
        // cazador1.recibirDanio(enemigo1.atacar());

        // System.out.println("El cazador usa su habilidad especial: " +
        // cazador1.usarHabilidadEspecial());
        // System.out.println("El enemigo usa su ataque especial: " +
        // enemigo1.ataqueEspecial() + " de daño");

        // Ejemplo de una clase implementada para referencia:
        CazadorDestreza cazadorEjemplo = new CazadorDestreza("Eileen", 85, 12, 22, 18);
        System.out.println("\nEjemplo de implementación:");
        System.out.println(cazadorEjemplo);

        System.out.println("\nAtaque básico: " + cazadorEjemplo.atacar() + " de daño");
        System.out.println("Habilidad especial: " + cazadorEjemplo.usarHabilidadEspecial());
        System.out.println("Transformación de arma: " + cazadorEjemplo.transformarArma());
    }
}

/**
 * Ejemplo de implementación de una clase concreta que hereda de Cazador
 * Esta clase sirve como referencia para que los alumnos puedan ver cómo
 * implementar sus propias clases
 */
class CazadorDestreza extends Cazador {
    private int bonusVelocidad;
    private int bonusAtaqueCritico;

    public CazadorDestreza(String nombre, int vitalidad, int fuerza, int destreza, int resistencia) {
        super(nombre, vitalidad, fuerza, destreza, resistencia);
        this.arma = "Espada de Caza";
        this.vestimenta = "Atuendo de Cuervo";
        this.bonusVelocidad = 5;
        this.bonusAtaqueCritico = destreza / 5;
    }

    @Override
    public int atacar() {
        // El daño base depende de la destreza más que de la fuerza
        double calculoDanio = this.destreza * 1.5 + this.fuerza * 0.5;
        int danioBase = (int) calculoDanio;

        // 20% de probabilidad de golpe crítico
        double probabilidadCritico = 0.2;
        double resultadoProbabilidad = Math.random();

        if (resultadoProbabilidad < probabilidadCritico) {
            System.out.println("¡Golpe crítico!");
            int bonusCritico = this.bonusAtaqueCritico * 3;
            return danioBase + bonusCritico;
        }

        return danioBase;
    }

    @Override
    public String usarHabilidadEspecial() {
        // Habilidad única de este tipo de cazador
        return "Danza de cuchillas: Realiza una serie de ataques rápidos que causan sangrado";
    }

    @Override
    public String transformarArma() {
        return "La Espada de Caza se transforma en Espada Hendida, aumentando el alcance pero reduciendo la velocidad";
    }

    @Override
    public boolean esquivar() {
        // Mejor habilidad para esquivar que otros cazadores
        double probabilidadEsquivar = (this.destreza + this.bonusVelocidad) * 0.05;
        double resultado = Math.random();

        if (resultado < probabilidadEsquivar) {
            return true;
        } else {
            return false;
        }
    }

    // Método específico de esta clase
    public void ejecutarCombo() {
        System.out.println(this.nombre + " ejecuta un combo de ataques rápidos aprovechando su alta destreza.");
    }
}