
/**
 * Obligatorisk oppgave 2
 * @author rut005, Thomas Sebastian Rognes
 *
 * LinkedList klasse
 */

import org.junit.jupiter.api.function.Executable;

import javax.sql.rowset.Predicate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.List;

public class LinkedList<E> implements IList<E> {

    private Node head = null;
    private int size;

    /**
     * En konstruktør som oppretter en ny linked list.
     */
    public LinkedList() {
        size = 0;
        head = null;
    }

    /**
     * En konstruktør som oppretter en ny linked list.
     * @param elem som blir det første elementet i listen.
     */
    public LinkedList(E elem) {
        head = new Node(elem);
        size = 1;
    }

    /**
     * En konstruktør som oppretter en ny linked list.
     * @param elem som blir det første elementet i listen.
     * @param list som blir lagt til i listen bak det første elementet.
     */
    public LinkedList(E elem, List list) {
        if (list != null) {
            Iterator listIterator = list.iterator();
            while (listIterator.hasNext()) {
                Node newNode = new Node((E) listIterator.next());
                if (isEmpty()) {
                    head = newNode;
                } else {
                    newNode.nextNode = head;
                    this.head = newNode;
                }
            }
        }
        this.put(elem);
    }

    /**
     * ,* Gir det første elementet i listen.
     * ,*
     * ,* @return Det første elementet i listen.
     * ,* @throws NoSuchElementException Hvis listen er tom.
     * ,
     */
    @Override
    public E first() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        } else {
            return head.getData();
        }
    }

    /**
     * ,* Returnerer alle elementene i listen bortsett fra det
     * ,* første.
     * ,*
     * ,* @return Resten av listen.
     * ,
     */
    @Override
    public IList<E> rest() {
        IList<E> restList = new LinkedList<>();
        Node current = head.getNext();

        if (size < 2) {
            return null;
        } else {
            while (current.getNext() != null) {
                restList.add(current.getData());
                if (current.hasNext()) {
                    current = current.getNext();
                } else {
                    break;
                }
            }
            return restList;
        }
    }

    /**
     * ,* Legger til et element på slutten av listen.
     * ,
     */
    @Override
    public boolean add(E elem) {
        Node current = head;
        Node newNode = new Node(elem);

        if (isEmpty()) {
            head = newNode;
            size++;
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        current.setNextNode(newNode);
        size++;
        return true;
    }


    /**
     * ,* Legger til et element på begynnelsen av listen.
     * ,
     */
    @Override
    public boolean put(E elem) {
        Node newNode = new Node(elem);

        if (isEmpty()) {
            this.head = newNode;
            size++;
            return true;
        } else {
            newNode.nextNode = this.head;
            this.head = newNode;
            size++;
            return true;
        }
    }

    /**
     * ,* Fjerner det første elementet i listen.
     * ,*
     * ,* @return Det første elementet i listen.
     * ,* @throws NoSuchElementException Hvis listen er tom.
     * ,
     */
    @Override
    public E remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else if (head.hasNext()) {
            Node objectToBeRemoved = head;
            head = head.getNext();
            size--;
            return objectToBeRemoved.getData();
        }
        else {
            Node objectToBeRemoved = head;
            head = null;
            size--;
            return objectToBeRemoved.getData();
        }
    }


    /**
     * ,* Fjerner det angitte objektet fra listen.
     * ,*
     * ,* @param o Objektet som skal fjernes.
     * ,* @return true hvis et element ble fjernet, false
     * ,* ellers.
     * ,
     */
    @Override
    public boolean remove(Object o) {
        if (this.contains(o)) {
            if (head.getData() == o) {
                this.head = this.head.getNext();
                size--;
                return true;
            } else {
                Node current = this.head;
                Node previous = null;

                while (current != null) {
                    if (current.getData() == o) {
                        if (current.hasNext()) {
                            previous.setNextNode(current.getNext());
                        } else {
                            previous.setNextNode(null);
                        }
                        current = null;
                        size--;
                        return true;
                    } else {
                        previous = current;
                        current = current.getNext();
                    }
                }
            }

        }
        return false;
    }

    /**
     * ,* Sjekker om et element er i listen.
     * ,*
     * ,* @param o objektet vi sjekker om er i listen.
     * ,* @return true hvis objektet er i listen, false ellers.
     * ,
     */
    @Override
    public boolean contains(Object o) {
        boolean containsInList = false;
        Node current = head;
        if (isEmpty()) {
            containsInList = false;
            return containsInList;
        } else if (current.getData() == o) {
            containsInList = true;
            return containsInList;
        } else {

            while (current.getNext() != null) {
                if (current.getNext().getData() == o) {
                    current = current.getNext();
                    containsInList = true;
                    return containsInList;
                } else {
                    containsInList = false;
                    current = current.getNext();
                }
            }
            return containsInList;
        }
    }

    /**
     * ,* Sjekker om listen er tom.
     * ,*
     * ,* @return true hvis listen er tom, false ellers.
     * ,
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else return false;
    }

    /**
     * ,* Legger til alle elementene i den angitte listen på
     * ,* slutten av listen.
     * ,*
     * ,* @param listen som blir lagt til.
     * ,
     */
    @Override
    public void append(IList<? extends E> list) {
        for (E elem : list) {
            this.add((E) list.remove());
        }
    }

    /**
     * ,* Legger til alle elementene i den angitte listen på
     * ,* begynnelsen av listen.
     * ,*
     * ,* @param list listen som blir lagt til
     * ,
     */
    @Override
    public void prepend(IList<? extends E> list) {
        for (E elem : list) {
            this.put((E) list.remove());
        }
    }

    /**
     * ,* Slår sammen flere lister
     * ,*
     * ,* @param lists listene som skal slås sammen
     * ,* @return Ny liste med alle elementene fra listene som
     * ,* skal slås sammen.
     * ,
     */
    @Override
    public IList<E> concat(IList<? extends E>... lists) {
        IList<E> returnList = new LinkedList<>();
        for (IList<? extends E> list : lists) {
            while (!list.isEmpty()) {
                returnList.add(list.remove());
            }
        }
        return returnList;
    }

    /**
     * ,* Sorterer listen ved hjelp av en
     * ,* sammenligningsfunksjon
     * ,* @param c sammenligningsfunksjon som angir rekkefølgen
     * ,* til elementene i listen
     * ,
     */
    @Override
    public void sort(Comparator<? super E> c) {

    }


    /**
     * ,* Fjerner elementer fra listen som svarer til et
     * ,* predikat.
     * ,* @param filter predikat som beskriver hvilken
     * ,* elementer som skal fjernes.
     * ,
     */
    @Override
    public void filter(java.util.function.Predicate<? super E> filter) {
        Node node = head;
        while (node != null) {
            if (filter.test(node.getData())){
                Object data = node.getData();
                this.remove(data);
            }
            node = node.getNext();
        }
    }


    /**
     * ,* Kjører en funksjon over hvert element i listen
     * ,*
     * ,* @param f en funksjon fra typen til elementene i
     * ,* listen til en annen type
     * ,* @return En liste over elementene som funksjonen
     * ,* returnerer
     * ,
     */

    @Override
    public <U> IList<U> map(Function<? super E, ? extends U> f) {
        IList<U> mappedList = new LinkedList<U>();
        Iterator it = this.iterator();

        while(it.hasNext()){
            E input = (E)it.next();
            E executed = (E)f.apply(input);
            System.out.println(executed.getClass());
            mappedList.add((U)executed);
        }
        return mappedList;
    }

    /**
     * ,* Slår sammen alle elementene i listen ved hjelp av en
     * ,* kombinasjonsfunksjon.
     * ,*
     * ,* @param t Det første elementet i sammenslåingen
     * ,* @param accum Funksjonen som holder styr på de
     * ,* sammenslåtte elementene
     * ,* @param combiner funksjonen som slår sammen to
     * ,* elementer
     * ,* @return Den akkumulerte verdien av sammenslåingene
     * ,
     */
    @Override
    public <T> T reduce(T t, BiFunction<T, ? super E, T> f) {
        T value = t;
        Iterator myIterator = this.iterator();
        while (myIterator.hasNext()){
            E input = (E) myIterator.next();
            E executed = (E) f.apply(value, input);
            value = (T) executed;
        }
        return value;
    }

    /**
     * ,* Gir størrelsen på listen
     * ,*
     * ,* @return Størrelsen på listen
     * ,
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * ,* Fjerner alle elementene i listen.
     * ,
     */
    @Override
    public void clear() {
        head = 0;
        size = 0;
    }

    /**
     * metoden som printer ut listen.
     */
    @Override
    public void printLink(){
        Iterator it = this.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
     * Iterator metoden.
     * @return newIterator
     */

    @Override
    public Iterator<E> iterator() {
        Iterator newIterator = new myIterator();
        return newIterator;
    }


    /**
     * innerclass for klassen myIterator.
     */
    public class myIterator implements Iterator<E> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E item = current.getData();
            current = current.getNext();
            return item;
        }
    }

    /**
     * innerclass av Klassen Node.
     */

    private class Node {
        private Node nextNode;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node getNext() {
            return nextNode;
        }

        private void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        private void setData(E data) {
            this.data = data;
        }

        private boolean hasNext() {
            return nextNode != null;
        }
    }
}







