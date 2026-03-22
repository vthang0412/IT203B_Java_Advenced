package Session11.Btth;

import Session11.Btth.entity.Appointment;
import Session11.Btth.persistence.AppointmentRepository;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AppointmentRepository repo = new AppointmentRepository();

        Appointment a = new Appointment(0, "Nguyen Van A", Date.valueOf("2026-03-25"), "Dr. B", "Pending");
        repo.addAppointment(a);

        List<Appointment> list = repo.getAllAppointments();
        for (Appointment x : list) {
            System.out.println(x.getId() + " | " + x.getPatientName() + " | " + x.getAppointmentDate() + " | " + x.getDoctorName() + " | " + x.getStatus());
        }

        if (!list.isEmpty()) {
            Appointment first = list.get(0);
            first.setStatus("Completed");
            repo.updateAppointment(first);
        }

        Appointment found = repo.getAppointmentById(1);
        if (found != null) {
            System.out.println("Tim thay: " + found.getPatientName());
        }

        repo.deleteAppointmentById(1);
    }
}
