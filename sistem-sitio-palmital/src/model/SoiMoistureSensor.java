package model;

public class SoiMoistureSensor implements Sensor {
    private double moistureLevel;

    @Override
    public void readData() {
        // Simulação da leitura de dados do sensor
        this.moistureLevel = Math.random() * 100;
    }

    @Override
    public double getData() {
        return this.moistureLevel;
    }

    @Override
    public String toString() {
        return "Soil Moisture Level: " + this.moistureLevel + "%";
    }

}
