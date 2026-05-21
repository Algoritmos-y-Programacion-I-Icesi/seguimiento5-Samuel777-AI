package model;

/**
 * Clase abstracta que representa una atraccion del parque MagicWorld.
 */
public abstract class Atraccion {

    protected String nombre;
    protected String zonaUbicacion;
    protected int capacidadMaxima;
    protected int edadMinimaAnios;
    protected int visitantesPorDia;
    protected double precioEntrada;

    /**
     * Constructor de la clase Atraccion.
     * @param nombre nombre de la atraccion
     * @param zonaUbicacion zona donde se ubica la atraccion en el parque
     * @param capacidadMaxima cantidad maxima de personas permitidas
     * @param edadMinimaAnios edad minima requerida para ingresar
     * @param visitantesPorDia cantidad de visitantes registrados en el dia
     * @param precioEntrada precio de una entrada a la atraccion
     */
    public Atraccion(String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada) {
        this.nombre = nombre;
        this.zonaUbicacion = zonaUbicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinimaAnios = edadMinimaAnios;
        this.visitantesPorDia = visitantesPorDia;
        this.precioEntrada = precioEntrada;
    }

    /**
     * Calcula el ingreso diario generado por la atraccion.
     * Cada tipo de atraccion define su propia formula de calculo.
     * @return el ingreso diario en pesos
     */
    public abstract double calcularIngresoDiario();

    /**
     * Determina si la atraccion requiere mantenimiento especial.
     * Cada tipo de atraccion define sus propias condiciones.
     * @return true si requiere mantenimiento, false en caso contrario
     */
    public abstract boolean requiereMantenimiento();

    /**
     * Verifica si la atraccion supero su capacidad maxima.
     * @return true si los visitantes del dia superan la capacidad maxima
     */
    public boolean tieneAlertaCapacidad() {
        return visitantesPorDia > capacidadMaxima;
    }

    /**
     * Genera un mensaje de alerta indicando cuantos visitantes
     * excedieron el limite y el porcentaje de sobreocupacion.
     * Pre: la atraccion debe tener alerta de capacidad (tieneAlertaCapacidad() == true)
     * @return el mensaje de alerta con los datos de sobreocupacion
     */
    public String generarAlertaCapacidad() {
        int exceso = visitantesPorDia - capacidadMaxima;
        double porcentaje = (exceso * 100.0) / capacidadMaxima;
        return "ALERTA en " + nombre + ": " + exceso + " visitantes de mas ("
                + String.format("%.1f", porcentaje) + "% de sobreocupacion)";
    }

    /**
     * Retorna una representacion en texto de la informacion de la atraccion.
     * @return cadena con los datos generales de la atraccion
     */
    @Override
    public String toString() {
        return "--------------------------------------------" +
                "\nNombre        : " + nombre +
                "\nZona          : " + zonaUbicacion +
                "\nCapacidad max : " + capacidadMaxima + " personas" +
                "\nEdad minima   : " + edadMinimaAnios + " anios" +
                "\nVisitantes hoy: " + visitantesPorDia +
                "\nPrecio entrada: $" + String.format("%,.2f", precioEntrada) +
                "\nIngreso diario: $" + String.format("%,.2f", calcularIngresoDiario()) +
                "\nMantenimiento : " + (requiereMantenimiento() ? "Si" : "No");
    }

    // Getters y Setter
    public void setVisitantesPorDia(int visitantes) { visitantesPorDia = visitantes; }
    public String getNombre() { return nombre; }
    public String getZonaUbicacion() { return zonaUbicacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getEdadMinimaAnios() { return edadMinimaAnios; }
    public int getVisitantesPorDia() { return visitantesPorDia; }
    public double getPrecioEntrada() { return precioEntrada; }
}
