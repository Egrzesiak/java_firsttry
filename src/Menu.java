import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu{
    private Double a;
    private String s;
    private Temperature temp = null;
    private Boolean b = false; //test jednostki temp

    public Menu(){
        temp = new Temperature();
        clrscr();
        mainMenu();
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int a = 0;

        System.out.println("__-- KALKULATOR TEMPERATUR --__");
        if (temp.isSet()){
            System.out.println(temp.getTemperatureString());
            System.out.println("");
            System.out.println("+++ Dostepne opcje: 1 - Podaj nowa temperature, 2 - Wyswietl temperature w Kelvinach +++");
            System.out.println("+++ Dostepne opcje: 3 - Wyswietl temperature w Celsjuszach, 4 - Wyswietl temperature w Fahrenheitach +++");
            System.out.println("+++ 9 - Wyjdz z programu");
            System.out.println("");
            a = scanner.nextInt();
        }
        else{
            System.out.println("");
            System.out.println("Temperatura nie zostala podana!");
            System.out.println("+++ Dostepne opcje: 1 - Podaj temperature, 9 - Wyjdz z programu +++");
            System.out.println("");
            a = scanner.nextInt();
        }

        switch (a){
            case 1 -> {
                getTemperature();
            }
            case 2 -> {
                showTemperature(TemperatureUnit.Kelvin);
            }
            case 3 -> {
                showTemperature(TemperatureUnit.Celciusz);
            }
            case 4 -> {
                showTemperature(TemperatureUnit.Fahrenheit);
            }
            case 9 -> {
                closeProgram();
            }
            default -> {
                System.out.println("!!! Bledna wartosc !!!");
                mainMenu();
            }
        }
    }

    private void showTemperature(TemperatureUnit temperatureUnit){
        System.out.println(temp.getTemperatureString(temperatureUnit));
        System.out.println("Nacisnij klawisz aby powrocic do menu");
        new java.util.Scanner(System.in).nextLine();
        clrscr();
        mainMenu();
    }

    private void getTemperature(){
        System.out.println("Podaj wartosc temperatury:");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        a = scanner.nextDouble();

        System.out.println("Podaj jednostke temperatury (K = Kelvin C=Celsjusz F=Fahrenheit):");

        s = scanner.next();
        temp.setTemperature(a,s);

        if (!TemperatureUnit.contains(s)){
            System.out.println("Bledna jednostka!");
            getTemperature();
        }
        else if (!temp.isSet()) {
            System.out.println("Blad wprowadzania danych!!!");
            getTemperature();
        }
        mainMenu();
    }

    private void closeProgram(){
        System.exit(0);
    }

    private static void clrscr() {
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
