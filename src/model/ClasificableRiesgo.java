package model;

/**
 * Interfaz que define el comportamiento de clasificacion de riesgo.
 * Solo la implementan las atracciones que tienen nivel de riesgo asignado.
 */
public interface ClasificableRiesgo {

    /**
     * Calcula el nivel de riesgo de la atraccion segun sus condiciones.
     * @return una cadena con el nivel: "ALTO", "MEDIO" o "BAJO"
     */
    String calcularNivelRiesgo();
}
