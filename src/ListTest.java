/**
 * Obligatorisk oppgave 1
 * @author rut005, Thomas Sebastian Rognes
 *
 * Test klassen
 */

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    /**
     * tester for deloppgave 1.1.
     * tester for hva som skjer med metodene hvis listen er tom.
     *
     */
    @Test
    void oppg1_emptyFirst() { //First metoden
        IList<Integer> list = new LinkedList<>();
        Throwable exeption = assertThrows(NoSuchElementException.class, list :: first);
    }

    @Test
    void oppg1_emptyRest() { //Rest metoden
        IList<Integer> list = new LinkedList<>();
        Throwable exeption = assertThrows(NoSuchElementException.class, list :: first);
    }

    @Test
    void oppg1_emptyAdd() { //Add metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.add(10));
    }

    @Test
    void oppg1_emptyPut() { //put metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.put(20));
    }

    @Test
    void oppg1_emptyRemove() { //remove metoden
        IList<Integer> list = new LinkedList<>();
        Throwable exeption = assertThrows(NoSuchElementException.class, list ::remove);
    }

    /**
     * tester for deloppgave 1.2.
     * tester for hva som skjer med metodene hvis listen inneholder kun 1 element.
     *
     */
    @Test
    void oppg1_oneFirst() { //First metoden
        IList<String> list = new LinkedList<>();
        list.add("Hello");
        assertEquals("Hello", list.first());
    }

    @Test
    void oppg1_oneRest() { //Rest metoden
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        assertEquals(null, list.rest());
    }

    @Test
    void oppg1_oneAdd() { //Add metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(1);
        assertTrue(list.add(2));
    }

    @Test
    void oppg1_onePut() { //Put metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(1);
        assertTrue(list.put(2));
    }

    @Test
    void oppg1_oneRemove() { //Remove metoden
        IList<String> list = new LinkedList<>();
        list.add("hei");
        assertEquals("hei", list.remove());
    }

    /**
     * tester for deloppgave 1.1.
     * tester for hva som skjer med metodene hvis listen inneholder flere enn 1 element.
     */
    @Test
    void oppg1_first() { //First metoden
        IList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("Thomas");
        list.add("Magnus");

        assertEquals("Hello", list.first());
    }

    @Test
    void oppg1_rest() { //rest metoden
        IList<String> list = new LinkedList<>();
        String a = "element2";
        String b = "element2";
        String c = "element3";
        String d = "element4";
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        IList<String> restList = list.rest();

        assertTrue(restList.contains(a));
        assertTrue(restList.contains(b));
        assertTrue(restList.contains(c));
}

    @Test
    void oppg1_add() { //Add metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.add(4));
    }

    @Test
    void oppg1_put() { //put metoden
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.put(1);
        list.put(2);
        list.put(3);
        assertTrue(list.put(4));
    }

    @Test
    void oppg1_remove() { //Remove metoden
        IList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("1", list.remove());
    }

    /**
     * Deloppgave 2.1
     * Tester for remove(object) i ulike scenarioer.
     */

    @Test
    void removeObjectTest1() { //En tom liste.
        IList<Integer> list = new LinkedList<>();
        assertFalse( list.remove(1));
    }

    @Test
    void removeObjectTest2() { //liste med kun 1 element, der elementet ikke finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        assertFalse(list.remove(2));
    }

    @Test
    void removeObjectTest3() { //liste med kun 1 element, der elementet finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        assertTrue(list.remove(1));
    }

    @Test
    void removeObjectTest4() { //liste med 2 eller flere element, der elementet ikke finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        assertFalse(list.remove(4));
    }

    @Test
    void removeObjectTest5() { //liste med 2 eller flere element, der elementet finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        assertTrue(list.remove(2));
    }


    /**
     * Deloppgave 3.1 Tester for metodene contains(Object), isEmpty og size.
     */

    @Test
    void testContains1(){ //Contains(Object) når listen er tom.
        IList<Integer> list = new LinkedList<>();
        assertFalse(list.contains(1));
    }

    @Test
    void testContains2(){ //Contains(Object) når listen inneholder flere elementer, men elementet ikke finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertFalse(list.contains(4));
    }

    @Test
    void testContains3(){ //Contains(Object) når listen inneholder flere elementer og elementet finnes i listen.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertTrue(list.contains(2));
    }

    @Test
    void testIsEmpty1(){ // IsEmpty når listen er tom.
        IList<Integer> list = new LinkedList<>();
        assertEquals(true, list.isEmpty());
    }

    @Test
    void testIsEmpty2(){ //IsEmpty når listen inneholder elementer.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals(false, list.isEmpty());
    }

    @Test
    void testSize1(){ // Size når listen er tom.
        IList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    void testSize2(){ //Size når listen inneholder elementer.
        IList<Integer> list = new LinkedList<>();
        list.add(1);
        list.put(2);
        assertEquals(2, list.size());
    }


    /**
     * Deloppgave 4.1 Tester for metodene append og prepend.
     */

    @Test
    void testAppend1(){ //Tester append når listene ikke inneholder elementer.
        IList<Integer> list = new LinkedList<>();
        IList<Integer> newList = new LinkedList<>();

        list.append(newList);
        assertThrows(NoSuchElementException.class, list :: first);
    }

    @Test
    void testAppend2(){ //Tester append når listene inneholder elementer.
        IList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        IList<String> newList = new LinkedList<>();
        newList.add("5");
        newList.add("6");
        newList.add("7");
        newList.add("8");

        list.append(newList);
        assertEquals("1", list.first());



    }

    @Test
    void testPrepend1(){ //Tester prepend når listene ikke inneholder elementer.
        IList<Integer> list = new LinkedList<>();
        IList<Integer> newList = new LinkedList<>();

        list.append(newList);
        assertThrows(NoSuchElementException.class, list::first);
    }

    @Test
    void testPrepend2(){ //Tester prepend når listene inneholder elementer.
        IList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        IList<String> newList = new LinkedList<>();
        newList.add("5");
        newList.add("6");
        newList.add("7");
        newList.add("8");

        assertEquals("1", list.first());
    }

    /**
     * Deloppgave 5.1 Tester for concat metoden i ulike scenarioer.
     */

    @Test
    void testConcat1(){ // test hvis listene inneholder elementer.
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();

        conc1.add("1");
        conc1.add("2");

        conc2.add("3");
        conc2.add("4");

        conc3.add("5");
        conc3.add("6");

        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);
        assertEquals(6, conc4.size());
        assertEquals("1", conc4.first());
    }

    @Test
    void testConcat2(){ // hvis den ene listen ikke inneholder noen element.
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();

        conc2.add("3");
        conc2.add("4");

        conc3.add("5");
        conc3.add("6");

        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);

        assertEquals(4, conc4.size());
        assertEquals("3", conc4.first());

    }

    @Test
    void testConcat3(){ // hvis ingen av listene inneholder noen element.
        IList<String> conc1 = new LinkedList<String>();
        IList<String> conc2 = new LinkedList<String>();
        IList<String> conc3 = new LinkedList<String>();

        IList<String> conc4 = new LinkedList<String>();
        conc4 = conc4.concat(conc1,conc2,conc3);

        assertEquals(0, conc4.size());
        assertThrows(NoSuchElementException.class, conc4 :: first);
    }


    /**
     * Deloppgave 7.1 Tester for iterator i ulike scenarioer.
     */

    @Test
    void testIterator1(){ //Test for iteratoren dersom listen inneholder elementer.
        IList<String> myList = new LinkedList<String>();
        myList.add("1");
        myList.add("2");
        myList.add("3");

        Iterator myIterator = myList.iterator();

        assertTrue(myIterator.hasNext());

    }

    @Test
    void testIterator2(){ //Test for iterator dersom listen ikke inneholder elementer.
        IList<String> myList = new LinkedList<String>();

        Iterator myIterator = myList.iterator();

        assertFalse(myIterator.hasNext());
    }

    /**
     * Deloppgave 8.1 tester for Sort i ulike scenarioer.
     */

    @Test
    void oppg8_sortIntegers() {
        // Se oppgave 8
        LinkedList <Integer> list = new LinkedList<>();
        List<Integer> values = Arrays.asList(3, 8, 4, 7, 10, 6, 1, 2, 9, 5);

        for (Integer value : values) {
            list.add(value);
        }
        list.sort(Comparator.comparingInt(x -> x));


        int n = list.remove();
        while (list.size() > 0) {
            int m = list.remove();
            if (n > m) {
                fail("Integer list is not sorted.");
            }
            n = m;
        }

    }

    @Test
    void oppg8_sortStrings() {
        // Se oppgave 8
        IList<String> list = new LinkedList<>();
        List<String> values = Arrays.asList(
                "g", "f", "a", "c", "b", "d", "e", "i", "j", "h"
        );
        for (String value : values) {
            list.add(value);
        }

        list.sort(Comparator.naturalOrder());

        String n = list.remove();
        while (list.size() > 0) {
            String m = list.remove();
            if (n.compareTo(m) > 0) {
                fail("String list is not sorted.");
            }

        }
    }

    /**
     * Deloppgave 9.1 tester for filter i ulike scenarioer.
     *
     * oppg9_filer() filtrerer ut oddetall og returnerer partall.
     * filterTest1() filtrerer ut elementer som har bokstaven "n" i seg og returnerer de resterende elementene.
     * filteTest2() filtrerer ut elementer som er større enn 50 og returnerer elementer som er under 50.
     *
     */

    @Test
    void oppg9_filter() {
        // Se oppgave 9
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IList<Integer> list = new LinkedList<>();
        for (Integer value : values) {
            list.add(value);
        }

        list.filter(n -> n % 2 == 1);

        list.printLink();

        int n = list.remove();
        while(list.size() > 0) {
            if (n % 2 == 1) {
                fail("List contains filtered out elements.");
            }
            n = list.remove();

        }
    }

    @Test
    void filterTest1() { //test for filter der vi fjerner elementer der bokstaven "n" forekommer i listen.
        List<String > values = Arrays.asList("Hei", "Thomas", "Kevin", "Bergen", "Trondheim", "Oslo");

        IList<String> list = new LinkedList<>();

        for (String value : values){
            list.add(value);
        }

        list.filter(n -> n.contains("n"));

        String n = list.remove();
        while (list.size() > 0){
            if (n.contains("n")){
                fail("List contaions filtered out elements");
            }
            n = list.remove();
        }
    }

    @Test
    void filerTest2(){ //filtrerer ut elementer som er større enn 50 og returnerer elementer som er under 50.
        List<Integer> values = Arrays.asList(1,28,29,47,83,99,72,91,33,45);

        IList<Integer> list = new LinkedList<>();
        for (Integer value : values) {
            list.add(value);
        }

        list.filter(n -> n > 50);

        list.printLink();

        int n = list.remove();
        while(list.size() > 0) {
            if (n > 50) {
                fail("List contains filtered out elements.");
            }
            n = list.remove();

        }
    }



    /**
     * Deloppgave 10.1 tester for map i ulike scenarioer.
     *
     *
     */

    @Test
    void oppg10_map() {
        // Se oppgave 10
        List<String> values = Arrays.asList("1", "2", "3", "4", "5");

        IList<String> list = new LinkedList<>();
        for (String value : values) {
            list.add(value);
        }

        IList<Integer> result = list.map(Integer::parseInt);

        List<Integer> target = Arrays.asList(1, 2, 3, 4, 5);

        int n = result.remove();
        for (Integer t : target) {
            System.out.println(n);
            if (n != t) {
                fail("Result of map gives the wrong value.");
            }
            n = result.remove();
        }
    }

    @Test
    void testMap1(){ //Gjør om Ordene til et tall som representerer lengden på ordet.
        List<String > values = Arrays.asList("Hei", "Thomas", "Kevin", "Bergen", "Trondheim", "Oslo");

        IList<String> list = new LinkedList<>();
        for (String value : values){
            list.add(value);
        }

        IList<Integer> result = list.map(String::length);

        List<Integer> target = Arrays.asList(3,6,5,6,9,4);

        int m = result.remove();
        for (Integer t : target) {
            System.out.println(m);
            if (m != t) {
                fail("Results are wrong");
            }
            m = result.remove();
        }

    }


    /**
     * Deloppgave 11.1 tester for reduce i ulike scenarioer.
     *
     */

    @Test
    void oppg11_reduceInts() {
        // Se oppgave 11
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        IList<Integer> list = new LinkedList<>();
        for (Integer value : values) {
            list.add(value);
        }

        int result = list.reduce(0, Integer::sum);

        assertEquals(result, 5*((1 + 5)/2));
    }

    @Test
    void oppg11_reduceStrings() {
        List<String> values = Arrays.asList("e", "s", "t");
        IList<String> list = new LinkedList<>();
        for (String s : values) {
            list.add(s);
        }

        String result = list.reduce("t", (acc, s) -> acc + s);

        assertEquals(result, "test");
    }
}






