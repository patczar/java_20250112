package p03_watki;

class WatekAA extends Thread {
    @Override
    public void run() {
        System.out.println("AA");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println("AA");
        throw new RuntimeException("masakra");
        //throw new Error("masakra"); // tak samo
        // gdy wyjątek nie ostanie wyłapany, to wątek kończy się błędem (komunikat na syserr), ale cały proces (i inne wątki) działą dalej
    }
}

class WatekBB extends Thread {
    @Override
    public void run() {
        for(int i =1; i <= 15; i++) {
            System.out.println("BB");
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class WyjatekWWatku {
    public static void main(String[] args) {
        WatekAA watekB = new WatekAA();
        WatekBB watekC = new WatekBB();
        watekB.start();
        watekC.start();
        System.out.println("main: uruchomilem watki");
        for(int i =1; i <= 10; i++) {
            System.out.println("MM");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }		
    }
}
