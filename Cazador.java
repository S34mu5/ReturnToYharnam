/**
 * Clase abstracta que representa a un Cazador en el mundo de Bloodborne.
 * Los cazadores son los personajes principales que el jugador puede controlar.
 */
public abstract class Cazador {
    // Atributos
    protected String nombre;
    protected int vitalidad;
    protected int fuerza;
    protected int destreza;
    protected int resistencia;
    protected int ecosSangre;
    protected String arma;
    protected String vestimenta;

    /**
     * Constructor para la clase Cazador
     * 
     * @param nombre      Nombre del cazador
     * @param vitalidad   Puntos de vida del cazador
     * @param fuerza      Determina el daño físico
     * @param destreza    Habilidad con armas y velocidad de ataque
     * @param resistencia Aguante para acciones como correr y esquivar
     */
    public Cazador(String nombre, int vitalidad, int fuerza, int destreza, int resistencia) {
        this.nombre = nombre;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.resistencia = resistencia;
        this.ecosSangre = 0;
        this.arma = "Arma inicial";
        this.vestimenta = "Vestimenta inicial";
    }

    // Métodos abstractos que las clases hijas deben implementar
    /**
     * Ataque principal del cazador
     * 
     * @return Daño causado por el ataque
     */
    public abstract int atacar();

    /**
     * Habilidad especial única de cada tipo de cazador
     * 
     * @return Descripción del efecto de la habilidad
     */
    public abstract String usarHabilidadEspecial();

    /**
     * Transformación del arma, característica típica de Bloodborne
     * 
     * @return Descripción de la transformación
     */
    public abstract String transformarArma();

    // Métodos concretos que heredan todas las clases hijas
    /**
     * El cazador esquiva un ataque
     * 
     * @return true si esquiva con éxito, false en caso contrario
     */
    public boolean esquivar() {
        // La probabilidad de esquivar depende de la destreza
        double probabilidadEsquivar = this.destreza * 0.05;
        double resultado = Math.random();

        if (resultado < probabilidadEsquivar) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * El cazador recibe daño de un enemigo
     * 
     * @param cantidad Cantidad de daño recibido
     * @return Vida restante después de recibir el daño
     */
    public int recibirDanio(int cantidad) {
        this.vitalidad = this.vitalidad - cantidad;
        if (this.vitalidad < 0) {
            this.vitalidad = 0;
        }
        return this.vitalidad;
    }

    /**
     * El cazador recoge ecos de sangre al derrotar enemigos
     * 
     * @param cantidad Cantidad de ecos recogidos
     */
    public void recogerEcosSangre(int cantidad) {
        this.ecosSangre = this.ecosSangre + cantidad;
        System.out.println(this.nombre + " ha recogido " + cantidad + " ecos de sangre. Total: " + this.ecosSangre);
    }

    /**
     * El cazador usa ecos de sangre para subir de nivel
     * 
     * @param atributo Atributo a mejorar (vitalidad, fuerza, destreza, resistencia)
     * @param coste    Coste en ecos de sangre para la mejora
     * @return true si se pudo realizar la mejora, false en caso contrario
     */
    public boolean subirNivel(String atributo, int coste) {
        if (this.ecosSangre < coste) {
            return false;
        }

        this.ecosSangre = this.ecosSangre - coste;

        String atributoLower = atributo.toLowerCase();

        if (atributoLower.equals("vitalidad")) {
            this.vitalidad = this.vitalidad + 5;
        } else if (atributoLower.equals("fuerza")) {
            this.fuerza = this.fuerza + 2;
        } else if (atributoLower.equals("destreza")) {
            this.destreza = this.destreza + 2;
        } else if (atributoLower.equals("resistencia")) {
            this.resistencia = this.resistencia + 3;
        } else {
            return false;
        }

        return true;
    }

    // Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public int getVitalidad() {
        return this.vitalidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public int getDestreza() {
        return this.destreza;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public int getEcosSangre() {
        return this.ecosSangre;
    }

    public String getArma() {
        return this.arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getVestimenta() {
        return this.vestimenta;
    }

    public void setVestimenta(String vestimenta) {
        this.vestimenta = vestimenta;
    }

    @Override
    public String toString() {
        String info = "Cazador: " + this.nombre + "\n";
        info = info + "Vitalidad: " + this.vitalidad + "\n";
        info = info + "Fuerza: " + this.fuerza + "\n";
        info = info + "Destreza: " + this.destreza + "\n";
        info = info + "Resistencia: " + this.resistencia + "\n";
        info = info + "Arma: " + this.arma + "\n";
        info = info + "Vestimenta: " + this.vestimenta + "\n";
        info = info + "Ecos de sangre: " + this.ecosSangre;

        return info;
    }
}