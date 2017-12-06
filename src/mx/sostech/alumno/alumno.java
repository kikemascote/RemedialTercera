package mx.sostech.alumno;

import java.util.Comparator;

public class alumno implements Comparable<alumno>, Comparator<alumno> {

    private String Nombre = null;
    private double Promedio = 0.0d;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double promedio) {
        Promedio = promedio;
    }


    @Override
    public int compare(alumno o1, alumno o2) {
        return o1.compareTo(o2);
    }

    @Override
    public int compareTo(alumno o) {
        if (this.Promedio == o.Promedio) return 0;
        else if (this.Promedio > o.Promedio) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Alumno [Nombre: " + Nombre + ", Promedio: " + Promedio + "]";
    }

}