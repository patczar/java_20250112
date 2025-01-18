package p14_nowosci_javy;

import javax.swing.JOptionPane;

// W tej wersji użyjemy switch expression
// Gdy w danym case jest jeden wynik do zwrócenia, to piszemy go bezpośrednio za znakiem ->
// Gdy w danym case (jak tutaj dla lutego) trzeba wykonać jeszcze dodatkowe kroki,
// to wynik switcha jest wtedy zwracany za pomocą słowa yield
public class IleDniMaMiesiac7 {

	public static void main(String[] args) {
		String miesiac = JOptionPane.showInputDialog("Podaj nazwę miesiąca");
		// można: var yield = 13;
		
		int ileDni = switch(miesiac) {
			case "styczeń", "marzec", "maj", "lipiec", "sierpień", "październik", "grudzień" -> 31;	
			case "kwiecień", "czerwiec", "wrzesień", "listopad" -> 30;
			
			case "luty" -> {
				int rok = Integer.parseInt(JOptionPane.showInputDialog("Podaj rok"));
				if(rok % 4 == 0 && rok % 100 != 0 || rok % 400 == 0) {
					yield 29;
				} else {
					yield 28;
				}
			}
			default -> throw new IllegalArgumentException("Niepoprawny miesiąc " + miesiac);
		};
		
		JOptionPane.showMessageDialog(null, "Miesiąc " + miesiac + " ma " + ileDni + " dni");
		
	}

}
