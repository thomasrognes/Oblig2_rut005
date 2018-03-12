/**
 * Obligatorisk oppgave 2
 * @author rut005, Thomas Sebastian Rognes
 *
 * NoSuchElementException klasse
 */

public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException(){
        super();
    }

    public NoSuchElementException(String message){
        super(message);
    }

    public NoSuchElementException(String message, Throwable cause){
        super(message, cause);
    }

    public NoSuchElementException(Throwable cause){
        super(cause);
    }
}


