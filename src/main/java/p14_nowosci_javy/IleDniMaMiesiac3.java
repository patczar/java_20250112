package p14_nowosci_javy;

import javax.swing.JOptionPane;

// W tej wersji użyjemy rozwiązań z Java 14: wiele wartości po przecinku i -> (czyli że wykona się tylko jeden case)
public class IleDniMaMiesiac3 {

	public static void main(String[] args) {
		String miesiac = JOptionPane.showInputDialog("Podaj nazwę miesiąca");
	
		switch(miesiac) {
		case "styczeń", "marzec", "maj", "lipiec", "sierpień", "październik", "grudzień" ->
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 31 dni");
		case "kwiecień", "czerwiec", "wrzesień", "listopad" ->
			JOptionPane.showMessageDialog(null, "Ten miesiąc ma 30 dni");
		case "luty" -> {
			int rok = Integer.parseInt(JOptionPane.showInputDialog("Podaj rok"));
			if(rok % 4 == 0 && rok % 100 != 0 || rok % 400 == 0) {
				JOptionPane.showMessageDialog(null, "Ten miesiąc ma 29 dni");
			} else {
				JOptionPane.showMessageDialog(null, "Ten miesiąc ma 28 dni");
			}
		}
		default ->
			JOptionPane.showMessageDialog(null, "Niepoprawny miesiąc " + miesiac, "Błąd", JOptionPane.ERROR_MESSAGE);
		}
	}

}
