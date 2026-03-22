package Session10.Btth.persistence;

import Session10.Btth.entity.Appointment;
import Session10.Btth.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DatabaseConnection.openConnection()){
            String sql = "select * from appointments";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Appointment appointment = new Appointment(
                                rs.getInt("id"),
                                rs.getString("patient_name"),
                                rs.getDate("appointment_date"),
                                rs.getString("doctor_name"),
                                rs.getString("status")
                );
                appointments.add(appointment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        String sql = "select * from appointments where id=?";
        try (Connection conn = DatabaseConnection.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Appointment(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getDate("appointment_date"),
                        rs.getString("doctor_name"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void addAppointment(Appointment appointment) {
        String sql = "insert into appointments(patient_name, appointment_date, doctor_name, status) values(?,?,?,?)";
        try (Connection conn = DatabaseConnection.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, appointment.getPatientName());
            ps.setDate(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAppointment(Appointment appointment) {
        String sql = "update appointments set patient_name=?, appointment_date=?, doctor_name=?, status=? where id=?";
        try (Connection conn = DatabaseConnection.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, appointment.getPatientName());
            ps.setDate(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAppointmentById(int id) {
        String sql = "delete from appointments where id=?";
        try (Connection conn = DatabaseConnection.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
