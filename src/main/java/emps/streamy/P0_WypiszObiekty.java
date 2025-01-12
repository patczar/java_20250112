package emps.streamy;

import java.io.FileNotFoundException;

public class P0_WypiszObiekty {

    public static void main(String[] args) throws FileNotFoundException {
        ObslugaCSV.readCSV().forEach(System.out::println);
    }
}
