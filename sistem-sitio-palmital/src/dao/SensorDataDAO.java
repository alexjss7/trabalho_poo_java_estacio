package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SensorDataDAO {
    public void save(SensorData data) {
        String sql = "INSERT INTO sensor_data (moisture_level, timestamp)
        VALUES( ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, data.getMoistureLevel());
            stmt.setTimestamp(2, data.getTimestamp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to save sensor data: " +
                    e.getMessage());
        }
    }

    public List<SensorData> getAllData() {
        String sql = "SELECT * FROM sensor_data";
        List<SensorData> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                double moistureLevel = rs.getDouble("moisture_level");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                dataList.add(new SensorData(id, moistureLevel, timestamp));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve sensor data: " +
                    e.getMessage());
        }
        return dataList;
    }
}
