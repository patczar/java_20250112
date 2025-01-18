package p14_nowosci_javy;

import javax.swing.JOptionPane;

// W tej wersji użyjemy rozwiązań ze starszych wersji Javy: pogrupujemy case'y
public class IleDniMaMiesiac2 {

	public static void main(String[] args) {
		String miesiac = JOptionPane.showInputDialog("Podaj nazwę miesiąca");
	
		switch(miesiac) {
		case "styczeń":
		case "marzec":
		case "maj":
		case "lipiec":
		case "sierpień":
		case "październik":
		case "grudzień":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
			break;
		case "kwiecień":
		case "czerwiec":
		case "wrzesień":
		case "listopad":
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
			break;
		case "luty":
			int odp = JOptionPane.showConfirmDialog(null, "Czy rok jest przestępny?", "Pytanko", JOptionPane.YES_NO_OPTION);
			if(odp == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Ten miesiąc ma 29 dni");
			} else {
				JOptionPane.showMessageDialog(null, "Ten miesiąc ma 28 dni");
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Niepoprawny miesiąc " + miesiac, "Błąd", JOptionPane.ERROR_MESSAGE);
		}
	}

}
