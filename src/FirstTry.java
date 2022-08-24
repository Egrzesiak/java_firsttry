import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class FirstTry {
    public static void main(String[] args) {
        Double a;
        String s;
        Temperature temp = null;
        Boolean b = false; //test jednostki temp

        System.out.println("__-- KALKULATOR TEMPERATUR --__");
        System.out.println("Podaj wartość temperatury:");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        a = scanner.nextDouble();

        while (!b) {
            System.out.println("Podaj jednostkę (K = Kelvin C=Celsjusz F=Fahrenheit):");
            s = scanner.next();
            temp = new Temperature(a, s);
            if (temp.getType().equals("null")) System.out.println("Błędna jednostka!");
            else b = true;
        }
        clrscr();
        if (temp != null) System.out.println(temp.getFullTemperature());
    }

    public static void clrscr() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }

    }
}


