/**
 * Ejemplo de implementación de una clase concreta que hereda de Enemigo
 * Esta clase sirve como referencia para que los alumnos puedan ver cómo
 * implementar sus propias clases
 */
public class BestiaLicantropaEjemplo extends Enemigo {
    private boolean transformado;
    private int bonusFuria;
    private int contadorAtaques;

    /**
     * Constructor para la BestiaLicántropa
     * 
     * @param nombre              Nombre del enemigo
     * @param salud               Puntos de vida del enemigo
     * @param poderAtaque         Capacidad de daño del enemigo
     * @param defensa             Resistencia a ataques
     * @param ecosSangreOtorgados Cantidad de ecos que otorga al ser derrotado
     * @param esBoss              Indica si es un jefe o un enemigo común
     */
    public BestiaLicantropaEjemplo(String nombre, int salud, int poderAtaque, int defensa, int ecosSangreOtorgados,
            boolean esBoss) {
        super(nombre, salud, poderAtaque, defensa, ecosSangreOtorgados, esBoss);
        this.transformado = false;
        this.bonusFuria = 0;
        this.contadorAtaques = 0;
        this.debilidad = "Fuego";
        this.ubicacion = "Bosque Prohibido";
    }

    @Override
    public int atacar() {
        this.contadorAtaques = this.contadorAtaques + 1;

        // El ataque básico es un zarpazo o mordisco
        int danioBase = this.poderAtaque;
        if (this.transformado) {
            danioBase = danioBase + 5;
        }

        // Cada tres ataques, la bestia incrementa su furia
        if (this.contadorAtaques % 3 == 0) {
            this.bonusFuria = this.bonusFuria + 2;
            System.out.println(this.nombre + " se vuelve más agresivo. ¡Su furia aumenta!");
        }

        int danioTotal = danioBase + this.bonusFuria;
        return danioTotal;
    }

    @Override
    public int ataqueEspecial() {
        // Ataque especial: Salto feroz que hace más daño pero tiene un coste
        double multiplicadorDanio = this.poderAtaque * 1.75;
        int danioEspecial = (int) multiplicadorDanio;
        if (this.transformado) {
            danioEspecial = danioEspecial + 10;
        }

        // El ataque especial cuesta salud al enemigo
        this.salud = this.salud - 5;
        if (this.salud < 0) {
            this.salud = 0;
        }

        System.out.println(this.nombre + " ejecuta un salto feroz, gastando parte de su energía vital.");
        return danioEspecial;
    }

    @Override
    public String comportamientoFaseCritica() {
        // Cuando la bestia está gravemente herida, se transforma y se vuelve más
        // peligrosa
        if (!this.transformado) {
            this.transformado = true;
            this.poderAtaque = this.poderAtaque + 8;
            this.defensa = this.defensa - 2; // Es más agresiva pero menos defensiva

            return this.nombre
                    + " aúlla de dolor y furia. ¡Su forma bestial se intensifica, volviéndose más grande y peligrosa!";
        }

        return this.nombre + " lucha con mayor ferocidad al sentirse acorralada.";
    }

    /**
     * Método específico de esta clase: aullido que aumenta sus estadísticas
     * temporalmente
     * 
     * @return Descripción del efecto del aullido
     */
    public String aullarALaLuna() {
        this.bonusFuria = this.bonusFuria + 5;
        return this.nombre + " aúlla a la luna, aumentando su furia y poder de ataque temporalmente.";
    }

    /**
     * Método específico para este tipo de enemigo: rastrear el olor del cazador
     * 
     * @param distancia Distancia a la que se encuentra el cazador
     * @return true si logra rastrear al cazador, false en caso contrario
     */
    public boolean rastrearOlor(int distancia) {
        // Las bestias licántropas tienen mejor capacidad de rastreo que otros enemigos
        double probabilidadRastreo = 1.0 - (distancia * 0.05);
        if (probabilidadRastreo < 0.2) {
            probabilidadRastreo = 0.2; // Mínimo 20% de probabilidad de rastreo
        }

        double resultado = Math.random();
        boolean rastreoExitoso;

        if (resultado < probabilidadRastreo) {
            rastreoExitoso = true;
        } else {
            rastreoExitoso = false;
        }

        if (rastreoExitoso) {
            System.out.println(this.nombre + " ha captado el olor del cazador y lo rastrea frenéticamente.");
        } else {
            System.out.println(this.nombre + " olfatea el aire pero pierde el rastro del cazador.");
        }

        return rastreoExitoso;
    }

    /**
     * Getter para saber si la bestia está transformada
     * 
     * @return true si la bestia está en estado transformado, false en caso
     *         contrario
     */
    public boolean isTransformado() {
        return this.transformado;
    }

    @Override
    public String toString() {
        String infoBase = super.toString();
        String estadoTransformacion;

        if (this.transformado) {
            estadoTransformacion = "Transformado";
        } else {
            estadoTransformacion = "Normal";
        }

        String infoCompleta = infoBase + "\n";
        infoCompleta = infoCompleta + "Estado: " + estadoTransformacion + "\n";
        infoCompleta = infoCompleta + "Bonus de furia: " + this.bonusFuria;

        return infoCompleta;
    }
}