public class Temperature {
    private double a;
    private TemperatureUnit temperatureUnit;

    public Temperature(Double a, TemperatureUnit type){
        this.a = a;
        this.temperatureUnit = type;
    }

    public Temperature(Double a, String s) {
        this.a = a;
        this.temperatureUnit = null;
        if (s.equals("K")){
            this.temperatureUnit = TemperatureUnit.Kelvin;
        }
        if (s.equals("C")){
            this.temperatureUnit = TemperatureUnit.Celciusz;
        }
        if (s.equals("F")){
            this.temperatureUnit = TemperatureUnit.Fahrenheit;
        }
    }

    public Double getKelvin(){
        if(this.temperatureUnit== TemperatureUnit.Kelvin) return a;
        if(this.temperatureUnit== TemperatureUnit.Celciusz) return (a+273.15);
        if(this.temperatureUnit== TemperatureUnit.Fahrenheit) return ((a+459.67)*5/9);
        return null;
    }

    public Double getCelcius(){
        if(this.temperatureUnit== TemperatureUnit.Kelvin) return (a-273.15);
        if(this.temperatureUnit== TemperatureUnit.Celciusz) return a;
        if(this.temperatureUnit== TemperatureUnit.Fahrenheit) return ((a-32)/1.8);
        return null;
    }

    public Double getFahrenheit(){
        if(this.temperatureUnit== TemperatureUnit.Kelvin) return ((a*1.8)-459.67);
        if(this.temperatureUnit== TemperatureUnit.Celciusz) return ((a*1.8)+32);
        if(this.temperatureUnit== TemperatureUnit.Fahrenheit) return a;
        return null;
    }

    public String getUnit(){
        if(this.temperatureUnit == null) return "null";
        return this.temperatureUnit.toString();
    }

    public String getFullTemperature(){
        return "Twoja temperatura to: " + String.valueOf(this.a) + " " + this.getUnit();
    }
}

