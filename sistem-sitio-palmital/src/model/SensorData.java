package model;

import java.sql.Timestamp;

public class SensorData {
    private int id;
    private double moistureLevel;
    private Timestamp timestamp;
    public SensorData(int id, double moistureLevel, Timestamp timestamp) {
        this.id = id;
        this.moistureLevel = moistureLevel;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getMoistureLevel() { return moistureLevel; }
    public void setMoistureLevel(double moistureLevel) { this.moistureLevel =
            moistureLevel; }
    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", moistureLevel=" + moistureLevel +
                ", timestamp=" + timestamp +
                '}';
    }
}

