package mx.sostech.alumno;

import java.util.Comparator;

public class materia implements Comparable<materia>, Comparator<materia> {
    private String nombre;
    private Integer unidades=0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    @Override
    public int compareTo(materia o) {
        return 0;
    }

    @Override
    public int compare(materia o1, materia o2) {
        return 0;
    }
}
