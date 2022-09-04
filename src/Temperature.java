public class Temperature {
    private double c,k,f;
    private TemperatureUnit temperatureUnit;
    private boolean isSet;
    private String ex = "";

    public Temperature(){
        isSet = false;
    }

    public boolean setTemperature(Double a, TemperatureUnit type){
        try {
            this.temperatureUnit = type;
            switch (type) {
                case Kelvin -> {
                    this.k = a;
                    this.c = a + 273.15;
                    this.f = (a + 459.67) * 5 / 9;
                    isSet = true;
                }
                case Celciusz -> {
                    this.k = a - 273.15;
                    this.c = a;
                    this.f = ((a - 32) / 1.8);
                    isSet = true;
                }
                case Fahrenheit -> {
                    this.k = (a * 1.8) - 459.67;
                    this.c = (a * 1.8) + 32;
                    this.f = a;
                    isSet = true;
                }
                default -> {
                    isSet = false;
                }
            }
        }
        catch (Exception ex){
            this.ex = String.valueOf(ex);
            isSet = false;
        }

        return isSet;
    }

    public boolean setTemperature(Double a, String s){
        if(TemperatureUnit.contains(s)) {
            return setTemperature(a,TemperatureUnit.fromString(s));
        }
        else{
            isSet = false;
        }
        return isSet;
    }

    public Double getKelvin(){
        return this.k;
    }

    public Double getCelcius(){
        return this.c;
    }

    public Double getFahrenheit(){
        return this.f;
    }

    public String getUnit(){
        return this.temperatureUnit.toString();
    }

    public boolean isSet() {
        return this.isSet;
    }

    public String getErrorMessage() {
        return this.ex;
    }

    public String getType(){
        return this.temperatureUnit.toString();
    }
    public String getTemperatureString(){
        return getTemperatureString(this.temperatureUnit);
    }
    public String getTemperatureString(TemperatureUnit tu) {
        Double a;
        String s;
        switch (tu) {
            case Fahrenheit -> {
                a = this.f;
                s = "Skala Fahrenheita [oF]:";
            }
            case Kelvin -> {
                a = this.k;
                s = "Skala Kelvina [C]: ";
            }
            case Celciusz -> {
                a = this.c;
                s = "Skala Celsjusza [C]: ";
            }
            default -> {
                a = 666.66;
                s = "Nieznany błąd!";
            }
        }
        return s.concat(String.valueOf(a));
    }
}

