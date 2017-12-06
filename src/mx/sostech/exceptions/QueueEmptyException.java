package mx.sostech.exceptions;

public class QueueEmptyException extends Exception {
    public QueueEmptyException(){}
    public QueueEmptyException(String Causa){
        super(Causa);
    }
    public QueueEmptyException(Throwable Causa){
        super(Causa);
    }
}
