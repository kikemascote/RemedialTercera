package mx.sostech.node;


public class calificacion<T> implements Comparable<T> {
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

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        return super.equals(arg0);
    }

}
