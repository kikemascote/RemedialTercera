package mx.sostech.alumno;

import java.util.Comparator;

public class cuatri implements Comparable<cuatri>, Comparator<cuatri> {
    private String nombre;
    private Integer grado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    @Override
    public int compareTo(cuatri o) {
        return 0;
    }

    @Override
    public int compare(cuatri o1, cuatri o2) {
        return 0;
    }
}
