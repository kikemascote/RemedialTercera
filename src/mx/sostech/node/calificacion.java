package mx.sostech.node;


import mx.sostech.alumno.materia;

import java.util.Comparator;

public class calificacion<T extends materia> implements Comparable<T>, Comparator<Double> {
    private T value;
    private calificacion<T> Left = null;
    private calificacion<T> Right = null, next = null, back = null;
    private long index = 0;

    public calificacion() {
        this.value = null;

    }

    public calificacion(T value) {
        this.value = value;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public calificacion<T> getLeft() {
        return Left;
    }

    public void setLeft(calificacion<T> left) {
        Left = left;
    }

    public calificacion<T> getRight() {
        return Right;
    }

    public void setRight(calificacion<T> right) {
        Right = right;
    }

    public calificacion<T> getNext() {
        return next;
    }

    public void setNext(calificacion<T> next) {
        this.next = next;
    }

    public calificacion<T> getBack() {
        return back;
    }

    public void setBack(calificacion<T> back) {
        this.back = back;
    }

    public int compareTo(double o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
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

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
