package mx.sostech.queue;

import mx.sostech.alumno.materia;
import mx.sostech.exceptions.QueueEmptyException;
import mx.sostech.exceptions.QueueFullException;
import mx.sostech.node.calificacion;

import java.util.Iterator;

public class tqueue<T extends materia> implements iQueue<T>, Iterable<T> {

    calificacion<T> back;
    calificacion<T> front;
    int count = 0;
    int size = 10;
    private calificacion<T> start = null, end = null;


    public tqueue() {
        start = new calificacion<T>();
        start.setIndex(-1);
        end = new calificacion<T>();
        end.setIndex(-1);
        calificacion<T> n = new calificacion<T>();
        start.setNext(n);
        n.setBack(start);
        calificacion<T> tmp = start.getNext();
        for (int i = 1; i < size; i++) {
            calificacion<T> nuevo = new calificacion<T>();
            tmp.setNext(nuevo);
            nuevo.setBack(tmp);
            tmp = tmp.getNext();
        }
        end.setBack(tmp);
        index();
        front = start.getNext();
        back = start.getNext();
    }


    public tqueue(int size) {
        this.size = size;
        start = new calificacion<T>();
        start.setIndex(-1);
        end = new calificacion<T>();
        end.setIndex(-1);
        calificacion<T> n = new calificacion<T>();
        start.setNext(n);
        n.setBack(start);
        calificacion<T> tmp = start.getNext();
        for (int i = 1; i < size; i++) {
            calificacion<T> nuevo = new calificacion<T>();
            tmp.setNext(nuevo);
            nuevo.setBack(tmp);
            tmp = tmp.getNext();
        }
        end.setBack(tmp);
        index();
        front = start.getNext();
        back = start.getNext();
    }

    public void index() {
        calificacion<T> tmp = start;
        int i = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            tmp.setIndex(i);
            i++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            calificacion<T> tmp = back.getBack();
            int i = 0;

            @Override
            public boolean hasNext() {
                if (tmp.getNext() == null)
                    tmp = start.getNext();
                else
                    tmp = tmp.getNext();
                return i++ != count;
            }

            @Override
            public T next() {
                return tmp.getValue();
            }
        };
    }


    @Override
    public void enQueue(T value) throws QueueFullException {
        if (isFull()) throw new QueueFullException("La cola est� llena");
        front.setValue(value);
        count++;
        if (front.getNext() == null)
            front = start.getNext();
        else
            front = front.getNext();

    }


    @Override
    public T deQueue() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("La cola est� vac�a");
        T tmp = back.getValue();
        back.setValue(null);
        count--;
        if (back.getNext() == null)
            back = start.getNext();
        else
            back = back.getNext();
        return tmp;
    }


    @Override
    public boolean isEmpty() {
        return (count == 0);
    }


    @Override
    public boolean isFull() {
        return (count == size);
    }


    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("La cola est� vac�a");
        return back.getValue();
    }


    @Override
    public calificacion<T> search(T value) throws QueueEmptyException {
        if (isEmpty()) throw new QueueEmptyException("Cola vac�a");
        calificacion<T> tmp = back;
        int i = 0;
        while (i <= count) {
            i++;
            if (tmp.getValue().equals(value))
                return tmp;
            if (tmp.getNext() == null)
                tmp = start.getNext();
            else
                tmp = tmp.getNext();
        }
        return null;
    }


    @Override
    public void clear() {
        while (!isEmpty())
            try {
                deQueue();
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
    }


    @Override
    public int size() {
        return count;
    }
}
