/**
 * Obligatorisk oppgave 2
 * @author rut005, Thomas Sebastian Rognes
 *
 * main metode
 */
public class main {
    public static void main(String[] args) {
        IList <Integer> myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.put(20);
        myList.put(30);
        myList.put(40);


        myList.printLink();

        IList<Integer> newList = new LinkedList<>();
        newList.add(6);
        newList.add(7);
        newList.add(8);

        myList.prepend(newList);



        myList.put(20);


        System.out.println("__________________________");

        myList.remove();
        myList.remove();
        myList.remove();
        myList.printLink();
        System.out.println("______________Test av concat__________________");
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

        conc4.printLink();

        System.out.println("__________________________");

        String Str1 = new String("Welcome to Tutorialspoint.com");
        String Str2 = new String("Welcome to Thomas");

        System.out.println(Str2.hashCode());
    }
}










