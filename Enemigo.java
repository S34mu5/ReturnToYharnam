/**
 * Clase abstracta que representa a un Enemigo en el mundo de Bloodborne.
 * Los enemigos son los adversarios que el Cazador debe enfrentar.
 */
public abstract class Enemigo {
    // Atributos
    protected String nombre;
    protected int salud;
    protected int poderAtaque;
    protected int defensa;
    protected int ecosSangreOtorgados;
    protected boolean esBoss;
    protected String debilidad;
    protected String ubicacion;

    /**
     * Constructor para la clase Enemigo
     * 
     * @param nombre              Nombre del enemigo
     * @param salud               Puntos de vida del enemigo
     * @param poderAtaque         Capacidad de daño del enemigo
     * @param defensa             Resistencia a ataques
     * @param ecosSangreOtorgados Cantidad de ecos que otorga al ser derrotado
     * @param esBoss              Indica si es un jefe o un enemigo común
     */
    public Enemigo(String nombre, int salud, int poderAtaque, int defensa, int ecosSangreOtorgados, boolean esBoss) {
        this.nombre = nombre;
        this.salud = salud;
        this.poderAtaque = poderAtaque;
        this.defensa = defensa;
        this.ecosSangreOtorgados = ecosSangreOtorgados;
        this.esBoss = esBoss;
        this.debilidad = "Ninguna";
        this.ubicacion = "Desconocida";
    }

    // Métodos abstractos que las clases hijas deben implementar
    /**
     * Ataque principal del enemigo
     * 
     * @return Daño causado por el ataque
     */
    public abstract int atacar();

    /**
     * Ataque especial único de cada tipo de enemigo
     * 
     * @return Daño causado por el ataque especial
     */
    public abstract int ataqueEspecial();

    /**
     * Comportamiento específico del enemigo en fase crítica (poca salud)
     * 
     * @return Descripción del comportamiento en fase crítica
     */
    public abstract String comportamientoFaseCritica();

    // Métodos concretos que heredan todas las clases hijas
    /**
     * El enemigo recibe daño de un cazador
     * 
     * @param cantidad Cantidad de daño recibido
     * @return Salud restante después de recibir el daño
     */
    public int recibirDanio(int cantidad) {
        // El daño real depende de la defensa del enemigo
        int danioReal = cantidad - (this.defensa / 5);
        if (danioReal < 1) {
            danioReal = 1; // Siempre recibe al menos 1 de daño
        }

        this.salud = this.salud - danioReal;
        if (this.salud < 0) {
            this.salud = 0;
        }

        // Si está en fase crítica, cambia su comportamiento
        int saludCritica = this.salud / 3;
        if (this.salud > 0 && this.salud < saludCritica) {
            this.comportamientoFaseCritica();
        }

        return this.salud;
    }

    /**
     * Verifica si el enemigo está derrotado
     * 
     * @return true si el enemigo está derrotado, false en caso contrario
     */
    public boolean estaDerrotado() {
        if (this.salud <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Otorga ecos de sangre al cazador que lo derrota
     * 
     * @return Cantidad de ecos de sangre otorgados
     */
    public int otorgarEcosSangre() {
        if (this.estaDerrotado()) {
            return this.ecosSangreOtorgados;
        }
        return 0;
    }

    /**
     * El enemigo realiza un movimiento de patrulla
     * 
     * @return Descripción del movimiento de patrulla
     */
    public String patrullar() {
        return this.nombre + " está patrullando la zona.";
    }

    /**
     * El enemigo detecta a un cazador
     * 
     * @param distancia Distancia a la que se encuentra el cazador
     * @return true si detecta al cazador, false en caso contrario
     */
    public boolean detectarCazador(int distancia) {
        // La probabilidad de detección depende de la distancia
        double probabilidadDeteccion = 1.0 - (distancia * 0.1);
        if (probabilidadDeteccion < 0.1) {
            probabilidadDeteccion = 0.1; // Siempre hay al menos 10% de probabilidad
        }

        double resultado = Math.random();
        if (resultado < probabilidadDeteccion) {
            return true;
        } else {
            return false;
        }
    }

    // Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public int getSalud() {
        return this.salud;
    }

    public int getPoderAtaque() {
        return this.poderAtaque;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public int getEcosSangreOtorgados() {
        return this.ecosSangreOtorgados;
    }

    public boolean isEsBoss() {
        return this.esBoss;
    }

    public String getDebilidad() {
        return this.debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        String tipo;
        if (this.esBoss) {
            tipo = "BOSS: ";
        } else {
            tipo = "Enemigo: ";
        }

        String info = tipo + this.nombre + "\n";
        info = info + "Salud: " + this.salud + "\n";
        info = info + "Poder de ataque: " + this.poderAtaque + "\n";
        info = info + "Defensa: " + this.defensa + "\n";
        info = info + "Ecos de sangre: " + this.ecosSangreOtorgados + "\n";
        info = info + "Debilidad: " + this.debilidad + "\n";
        info = info + "Ubicación: " + this.ubicacion;

        return info;
    }
}