package mx.sostech.queue;


import mx.sostech.exceptions.QueueEmptyException;
import mx.sostech.exceptions.QueueFullException;
import mx.sostech.node.calificacion;

public interface iQueue<T> {
    void enQueue(T value) throws QueueFullException;

    T deQueue() throws QueueEmptyException;

    boolean isEmpty();

    boolean isFull();

    T front() throws QueueEmptyException;

    calificacion<T> search(T value) throws QueueEmptyException;

    void clear();

    int size();

}

