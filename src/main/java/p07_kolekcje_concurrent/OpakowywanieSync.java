package p07_kolekcje_concurrent;

import java.util.*;

public class OpakowywanieSync {

    public static void main(String[] args) {
        // Vector, Hashtable, StringBuffer - stare klasy Javy, które są "thread-safe"
        StringBuffer s;
        Vector v;
        Hashtable h;
        // Współczesne ich wersje bez synchronizacji: StringBuilder, ArrayList, HashMap
        
        List<String> zwykla = new ArrayList<>();
        zwykla.add("Ala");
        zwykla.add("Ola");
        zwykla.add("Ela");
        
        List<String> synchronizowana = Collections.synchronizedList(zwykla);
        System.out.println(synchronizowana.getClass());
        System.out.println("Zawartość zwykłej: " + zwykla);
        System.out.println("Zawartość synchr: " + synchronizowana);
        System.out.println();
        
        zwykla.add("Ula");
        synchronizowana.add("Ewa");
        System.out.println("Zawartość zwykłej: " + zwykla);
        System.out.println("Zawartość synchr: " + synchronizowana);
        
        // Natomiast złą praktyką byłoby bezpośrednie korzystanie ze zmiennej zwykla.
        // Dlatego najlepiej od razu tworzyć zmienną listową w taki sposób:
        List<String> synchronizowana2 = Collections.synchronizedList(new ArrayList<>());
        
        // Jeśli wątek wykonuje kilka operacji pod rząd, to są one synchronizowane KAŻDA OSOBNO
        // Przykład błędu:
        // Jeśli wiele wątków będzie wykonywać taki kod, to dwa wątki mogą usuwać element z jednoelementowej listy -> błąd
        if(synchronizowana.size() > 0) {
            // tutaj może coś zrobić inny wątek
            synchronizowana.remove(0);
        }
        
        // Zalecanym podejściem jest wtedy wzięcie całej serii operacji w blok synchronizowany na obiekcie listy:
        synchronized(synchronizowana) {
            // skomplikowane operacje na liście...
            
            if(synchronizowana.size() > 0) {
                // teraz te dwie operacje będą wykonane atomowo
                synchronizowana.remove(0);
            }
            
            for (String element : synchronizowana) {
                // ...
                // mamy pewność, że w czasie przeglądania inne wątki nie będą ruszać tej listy
            }
        }
    }
}
