import java.util.*;

class WeatherReading {
    private LocalDateTime timestamp;
    private double temperature;
    private double humidity;
    private double pressure;
    
    public WeatherReading(LocalDateTime timestamp, double temperature, 
                         double humidity, double pressure) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getPressure() { return pressure; }
}

public class WeatherAnalyzer {
    public static void main(String[] args) {
        var readings = new ArrayList<WeatherReading>();
        
        // Simulate some weather readings
        var now = LocalDateTime.now();
        readings.add(new WeatherReading(now.minusHours(4), 22.5, 65.0, 1013.25));
        readings.add(new WeatherReading(now.minusHours(3), 23.1, 63.0, 1012.80));
        readings.add(new WeatherReading(now.minusHours(2), 24.3, 60.0, 1012.10));
        readings.add(new WeatherReading(now.minusHours(1), 25.0, 58.0, 1011.50));
        readings.add(new WeatherReading(now, 24.8, 59.0, 1011.80));
        
        var tempStats = readings.stream()
            .collect(Collectors.summarizingDouble(WeatherReading::getTemperature));
        
        var humidityStats = readings.stream()
            .collect(Collectors.summarizingDouble(WeatherReading::getHumidity));
        
        var pressureStats = readings.stream()
            .collect(Collectors.summarizingDouble(WeatherReading::getPressure));
        
        System.out.println("Weather Analysis Report");
        System.out.println("=======================");
        System.out.printf("Time Period: %s to %s%n", 
            readings.get(0).getTimestamp(), readings.get(readings.size()-1).getTimestamp());
        System.out.println();
        
        System.out.println("Temperature Statistics:");
        System.out.printf("  Average: %.1f°C%n", tempStats.getAverage());
        System.out.printf("  Minimum: %.1f°C%n", tempStats.getMin());
        System.out.printf("  Maximum: %.1f°C%n", tempStats.getMax());
        System.out.println();
        
        System.out.println("Humidity Statistics:");
        System.out.printf("  Average: %.1f%%%n", humidityStats.getAverage());
        System.out.printf("  Minimum: %.1f%%%n", humidityStats.getMin());
        System.out.printf("  Maximum: %.1f%%%n", humidityStats.getMax());
        System.out.println();
        
        System.out.println("Pressure Statistics:");
        System.out.printf("  Average: %.2f hPa%n", pressureStats.getAverage());
        System.out.printf("  Minimum: %.2f hPa%n", pressureStats.getMin());
        System.out.printf("  Maximum: %.2f hPa%n", pressureStats.getMax());
        
        // Find readings with extreme conditions
        var highTempReadings = readings.stream()
            .filter(r -> r.getTemperature() > 24.0)
            .toList();
        
        System.out.println("\nHigh Temperature Readings (>24°C):");
        highTempReadings.forEach(r -> 
            System.out.printf("  %s: %.1f°C%n", r.getTimestamp(), r.getTemperature()));
    }
}
