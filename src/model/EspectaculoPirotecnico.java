package model;

public class EspectaculoPirotecnico extends Atraccion implements ClasificableRiesgo {

    private int duracionMinutos;
    private boolean usaMaterialPeligroso;

    public EspectaculoPirotecnico(String nombre, String zonaUbicacion, int capacidadMaxima, int edadMinimaAnios, int visitantesPorDia, double precioEntrada, int duracionMinutos, boolean usaMaterialPeligroso) {
        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);
        this.duracionMinutos = duracionMinutos;
        this.usaMaterialPeligroso = usaMaterialPeligroso;
    }

    public double calcularIngresoDiario() {
        double ingreso = visitantesPorDia * precioEntrada;
        if (usaMaterialPeligroso) {
            ingreso = ingreso + (ingreso * 0.20);
        }
        return ingreso;
    }

    public boolean requiereMantenimiento() {
        return usaMaterialPeligroso || duracionMinutos > 60;
    }

    public String calcularNivelRiesgo() {
        if (usaMaterialPeligroso) {
            return "ALTO";
        } else if (duracionMinutos > 60) {
            return "MEDIO";
        } else {
            return "BAJO";
        }
    }

    public String toString() {
        return super.toString() +
                "\nTipo          : Espectaculo Pirotecnico" +
                "\nDuracion      : " + duracionMinutos + " minutos" +
                "\nMat. peligroso: " + (usaMaterialPeligroso ? "Si" : "No") +
                "\nNivel riesgo  : " + calcularNivelRiesgo();
    }

    public int getDuracionMinutos() { return duracionMinutos; }
    public boolean getUsaMaterialPeligroso() { return usaMaterialPeligroso; }
}