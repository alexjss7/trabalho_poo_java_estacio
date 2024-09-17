package main;
import dao.SensorDataDAO;
import model.Sensor;
import model.SensorData;

import java.sql.Timestamp;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Sensor soilMoistureSensor = new SoilMoistureSensor();
        SensorDataDAO sensorDataDAO = new SensorDataDAO();
        // Simulate data reading
        soilMoistureSensor.readData();
        double moistureLevel = soilMoistureSensor.getData();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // Create SensorData object and save it to the database
        SensorData sensorData = new SensorData(0, moistureLevel, timestamp);
        sensorDataDAO.save(sensorData);
        // Retrieve and display all data from the database
        List<SensorData> dataList = sensorDataDAO.getAllData();
        for (SensorData data : dataList) {
            System.out.println(data);
        }

    }
}