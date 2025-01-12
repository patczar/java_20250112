package p01_klasy;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    private Konto konto;
    private Osoba osoba;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("KontoTest setUp");
        // Jeśli jakiś obiekt jest potrzebny we wszystkich testach (albo zdecydowanej większości)
        // to deklarujemy go na poziomie klasy, a inicjalizujemy w metodzie setUp
        osoba = new Osoba("Ala", "Kowalska", LocalDate.of(2000, 2, 3));
        konto = new Konto(1234, 1000, osoba);
    }

    @AfterEach
    void tearDown() {
        System.out.println("KontoTest tearDown");
    }

    @Test
    void getSaldo() {
        assertEquals(1000, konto.getSaldo());
    }

    @Test @Disabled
    void testToString() {
        assertEquals("Konto nr 1234, wł: Ala Kowalska ur.2000-02-03, saldo: 1000", konto.toString());
    }

    @Test
    void testWplata() {
        konto.wplata(200);
        assertEquals(1200, konto.getSaldo());
    }

    @Test
    void testWplataUjemna() {
        assertThrows(IllegalArgumentException.class, () -> konto.wplata(-200));
        // sprawdzamy, czy wywołanie wplata doprowadziło do wyjątku,
        // ale także czy po zakończeniu stan konta nie uległ zmianie
        assertEquals(1000, konto.getSaldo());
    }

    @Test
    void wyplata() throws BrakSrodkow {
        konto.wyplata(300);
        assertEquals(700, konto.getSaldo());
    }

    @Test
    void wyplataUjemna() {
        assertThrows(IllegalArgumentException.class, () -> konto.wyplata(-200));
        assertEquals(1000, konto.getSaldo());
    }

    @Test
    void wyplataBrakSrodkow() {
        BrakSrodkow wyjatek = assertThrows(BrakSrodkow.class, () -> konto.wyplata(1500));
        assertEquals("Brak środków na koncie nr 1234", wyjatek.getMessage());
        assertEquals(1000, konto.getSaldo());
    }

    @Test
    void przelew() throws BrakSrodkow {
        // Jeśli jakiegoś obiektu potrzebujemy tylko w jednym teście (lub w małej części testów, które są w klasie)
        // to taki obiekt tworzymy już bezpośrednio w metodzie.
        Konto inneKonto = new Konto(2222, 2000, osoba);
        konto.przelew(inneKonto, 400);
        assertEquals(600, konto.getSaldo());
        assertEquals(2400, inneKonto.getSaldo());
    }
}
