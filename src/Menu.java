import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu{
    private Double a;
    private String s;
    private Temperature temp = null;
    private Boolean b = false; //test jednostki temp

    public Menu(){
        mainMenu();
    }

    public void mainMenu(){
        clrscr();
        System.out.println("__-- KALKULATOR TEMPERATUR --__");
        System.out.println("Podaj wartość temperatury:");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        a = scanner.nextDouble();

        while (!b) {
            System.out.println("Podaj jednostkę (K = Kelvin C=Celsjusz F=Fahrenheit):");
            s = scanner.next();
            temp = new Temperature(a, s);
            if (temp.getUnit().equals("null")) System.out.println("Błędna jednostka!");
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
