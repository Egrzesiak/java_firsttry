public enum TemperatureUnit {
    Celciusz("C"), Fahrenheit("F"), Kelvin("K");
    private final String text;
    TemperatureUnit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static boolean contains(String s) {
        for (TemperatureUnit c : TemperatureUnit.values()) {
            if (c.text.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static TemperatureUnit fromString(String text) {
        for (TemperatureUnit b : TemperatureUnit.values()) {
            if (b.text.equals(text)) {
                return b;
            }
        }
        return null;
    }
}
