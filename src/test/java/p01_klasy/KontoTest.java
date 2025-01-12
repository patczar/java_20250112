package p01_klasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    private Konto konto;

    @BeforeEach
    void setUp() {
        konto = new Konto(1, 1000, new Osoba("Ala", "Kowalska", LocalDate.of(1990, 1, 2)));;
    }

    @Test
    void getSaldo() {
        assertEquals(1000, konto.getSaldo());
    }

    @Test
    void testWplata() {
        konto.wplata(400);
        assertEquals(1400, konto.getSaldo());
    }

    @Test
    void testWyplata() {
        konto.wyplata(300);
        assertEquals(700, konto.getSaldo());
    }

    @Test
    void testWplataUjemna() {
        // sprawdzamy, czy będzie wyjątek
        assertThrows(IllegalArgumentException.class, () -> konto.wplata(-1100));
        assertEquals(1000, konto.getSaldo());
    }

    @Test
    void testWplataUjemnaPrecyzyjnie() {
        // sprawdzamy, czy będzie wyjątek
        // w tej wersji sprawdzamy też szczegóły samego wyjątku
        IllegalArgumentException exn = assertThrows(IllegalArgumentException.class, () -> konto.wplata(-1100));
        assertEquals("Niedodatnia kwota wpłaty", exn.getMessage());
        assertEquals(1000, konto.getSaldo());
    }
}

