package p35_daty;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Locale.Category;

public class WypiszDostepneLocale {

	public static void main(String[] args) {
		System.out.println("DEFAULT: "+Locale.getDefault());
		System.out.println("DISPLAY: "+Locale.getDefault(Category.DISPLAY));
		System.out.println("FORMAT: "+Locale.getDefault(Category.FORMAT));
		
        for (Locale loc : DateFormat.getAvailableLocales()) {
            System.out.println(loc.toString() + " " + loc.getDisplayLanguage() + "/" + loc.getDisplayCountry() );
        }
	}
}
