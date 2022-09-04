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
        temp = new Temperature();
        TemperatureUnit tuu = TemperatureUnit.fromString("K");
        System.out.println(tuu.toString());
        do {
            clrscr();
            System.out.println("__-- KALKULATOR TEMPERATUR --__");
            System.out.println("Podaj wartosc temperatury:");

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            a = scanner.nextDouble();

            System.out.println("Podaj jednostke temperatury (K = Kelvin C=Celsjusz F=Fahrenheit):");

            s = scanner.next();
            temp.setTemperature(a,s);

            if (!TemperatureUnit.contains(s)) System.out.println("Bledna jednostka!");
            else if (!temp.isSet()) System.out.println("Blad wprowadzania danych!!!");
            System.out.println(a.toString()+"--"+s+"--"+temp.isSet()+"=="+TemperatureUnit.contains(s));//+"--"+temp.getTemperatureString());
        }while (!temp.isSet());

        clrscr();

        if (temp.isSet()) System.out.println(temp.getTemperatureString());
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
