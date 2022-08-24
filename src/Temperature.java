public class Temperature {
    private double a;
    private TempType type;

    public Temperature(Double a, TempType type){
        this.a = a;
        this.type = type;
    }

    public Temperature(Double a, String s) {
        this.a = a;
        this.type = null;
        if (s.equals("K")){
            this.type = TempType.Kelvin;
        }
        if (s.equals("C")){
            this.type = TempType.Celciusz;
        }
        if (s.equals("F")){
            this.type = TempType.Fahrenheit;
        }
    }

    public Double getKelvin(){
        if(type==TempType.Kelvin) return a;
        if(type==TempType.Celciusz) return (a+273.15);
        if(type==TempType.Fahrenheit) return ((a+459.67)*5/9);
        return null;
    }

    public Double getCelcius(){
        if(type==TempType.Kelvin) return (a-273.15);
        if(type==TempType.Celciusz) return a;
        if(type==TempType.Fahrenheit) return ((a-32)/1.8);
        return null;
    }

    public Double getFahrenheit(){
        if(type==TempType.Kelvin) return ((a*1.8)-459.67);
        if(type==TempType.Celciusz) return ((a*1.8)+32);
        if(type==TempType.Fahrenheit) return a;
        return null;
    }

    public String getType(){
        if(this.type == null) return "null";
        return type.toString();
    }

    public String getFullTemperature(){
        return "Twoja temperatura to: " + String.valueOf(this.a) + " " + this.getType();
    }
}

