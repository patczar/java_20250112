package p14_nowosci_javy;

import javax.swing.JOptionPane;

public class IleDniMaMiesiac1 {

	public static void main(String[] args) {
		String miesiac = JOptionPane.showInputDialog("Podaj nazwę miesiąca");
		// Wypisz info ile dni ma ten miesiąc
		
		switch(miesiac) {
		case "styczeń":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "luty":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 28 lub 29 dni");
			break;
		case "marzec":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "kwiecień":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
			break;
		case "maj":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "czerwiec":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
			break;
		case "lipiec":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "sierpień":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "wrzesień":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
			break;
		case "październik":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "listopad":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
			break;
		case "grudzień":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Niepoprawny miesiąc " + miesiac, "Błąd", JOptionPane.ERROR_MESSAGE);
		}
	}

}
