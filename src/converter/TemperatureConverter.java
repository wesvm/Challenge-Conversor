package converter;

public class TemperatureConverter {

    private double CelsiusToFahrenheit(double value){ return value * 9/5 + 32;}

    private double CelsiusToKelvin(double value){
        return value + 273.15;
    }

    private double KelvinToCelsius(double value){
        return value - 273.15;
    }

    private double KelvinToFahrenheit(double value){ return (value - 273.15) * 9/5 + 32;}

    private double FahrenheitToCelsius(double value){
        return (value - 32) * 5/9;
    }

    private double FahrenheitToKelvin(double value){
        return (value - 32) * 5/9 + 273.15;
    }

    public String getTemperatureConverter(String op, double value){
        return switch (op) {
            case "CelsiusToFahrenheit" -> Double.toString(CelsiusToFahrenheit(value));
            case "CelsiusToKelvin" -> Double.toString(CelsiusToKelvin(value));
            case "KelvinToCelsius" -> Double.toString(KelvinToCelsius(value));
            case "KelvinToFahrenheit" -> Double.toString(KelvinToFahrenheit(value));
            case "FahrenheitToCelsius" -> Double.toString(FahrenheitToCelsius(value));
            case "FahrenheitToKelvin" -> Double.toString(FahrenheitToKelvin(value));
            default -> Double.toString(value);
        };
    }

}
