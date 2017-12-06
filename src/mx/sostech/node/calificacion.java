package mx.sostech.node;


import mx.sostech.alumno.materia ;

import java.util.Comparator;

public class calificacion<materia> extends mx.sostech.alumno.materia {
    private materia value;
    private double ap = 0.0;
    private double rep = 0.0;
    private calificacion<materia> Left = null;
    private calificacion<materia> Right = null, next = null, back = null;
    private long index = 0;

    public calificacion() {
        this.value = null;

    }

    public calificacion(materia value) {
        this.value = value;
    }

    public calificacion(double ap,double rep) {
        //this.value = value;
        this.ap = ap;
        this.rep = rep;
    }
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public materia getValue() {
        return value;
    }

    public void setValue(materia value) {
        this.value = value;
    }

    public calificacion<materia> getLeft() {
        return Left;
    }

    public void setLeft(calificacion<materia> left) {
        Left = left;
    }

    public calificacion<materia> getRight() {
        return Right;
    }

    public void setRight(calificacion<materia> right) {
        Right = right;
    }

    public calificacion<materia> getNext() {
        return next;
    }

    public void setNext(calificacion<materia> next) {
        this.next = next;
    }

    public calificacion<materia> getBack() {
        return back;
    }

    public void setBack(calificacion<materia> back) {
        this.back = back;
    }

    /*root.setRep(7.99);
        root.setAp(8.0d);*/

    public int compareTo(double o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    //@Overload
    public int compare(Double o1, Double o2) {
        if (o1 > o2)
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        return super.equals(arg0);
    }

    /*@Override
    public int compareTo(materia o) {
        return 0;
    }*/
}
