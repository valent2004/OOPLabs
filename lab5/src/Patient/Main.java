package Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/student/Desktop/sss.zip/OOPLabs/lab2+/src/patient/Patients.txt"))) {
            PatientsList patientsList = new PatientsList();
            patientsList.setPatientsList(patientsList.initArray());
            oos.flush();
            patientsList.showPatientsData();
            patientsList.showDiagnosis();
            patientsList.showNumMedCard(1, 20);
            patientsList.showNonInsurance();
            oos.writeObject(patientsList.getPatientsList());
            patientsList = new PatientsList();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/student/Desktop/sss.zip/OOPLabs/lab2+/src/patient/Patients.txt"))) {
                Scanner sss = new Scanner(System.in);
                patientsList.setPatientsList(((ArrayList<Patient>) ois.readObject()));
                oos.flush();
                patientsList.setPatientsList(patientsList.addNewPatients(sss));
                oos.writeObject(patientsList.getPatientsList());
                System.out.println("New data:");
                patientsList.showPatientsData();
            } catch (IOException err) {
                System.out.println(err.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
