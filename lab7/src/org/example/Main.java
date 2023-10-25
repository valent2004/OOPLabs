package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Main main = new Main();
            ObjectOutputStream oos = main.ExistingFileRead("C:/Users/student/OOPLabs/lab7/src/patient2/Patients.txt");
            PatientsList patientsList = new PatientsList();
            patientsList.writePatient("C:/Users/student/OOPLabs/lab7/src/patient2/Patients.txt");
            patientsList = new PatientsList();
            Scanner sss = new Scanner(System.in);
            patientsList.readPatient("C:/Users/student/OOPLabs/lab7/src/patient2/Patients.txt");
            int menushka = patientsList.Menu(sss);
            while (menushka != 11) {
                switch (menushka) {
                    case 1:
                        oos.flush();
                        patientsList.addNewPatient(sss);
                        oos.writeObject(patientsList.getPatientsList());
                        break;
                    case 2:
                        oos.flush();
                        int patient = patientsList.searchPatients(sss);
                        if (patient != -1) {
                            patientsList.getPatientsList().remove(patientsList.getPatientsList().keySet().toArray()[patient], patientsList.getPatientsList().get(patientsList.getPatientsList().keySet().toArray()[patient]));
                        }
                        oos.writeObject(patientsList.getPatientsList());
                        break;
                    case 3:
                        patientsList.showPatientsData();
                        break;
                    case 4:
                        int patient2 = patientsList.searchPatients(sss);
                        if (patient2 != -1) {
                            Patient curPatient = patientsList.getPatientsList().get(patientsList.getPatientsList().keySet().toArray()[patient2]);
                            System.out.println(patientsList.getPatientsList().keySet().toArray()[patient2] + ".\nName: " + curPatient.getName() + "\nMiddlename: " + curPatient.getMiddleName() + "\nSurname: " + curPatient.getSurname() + "\nAdress: " + curPatient.getAddress() + "\nPhone: +380" + curPatient.getPhone() + "\nThe number of medical card: " + curPatient.getNumMedCard() + "\nThe insurance: " + curPatient.getInsurance() + "\nDiagnosis: " + curPatient.getDiagnosis());
                        }
                        break;
                    case 5:
                        break;
                    case 6:
                        int a = sss.nextInt(), b = sss.nextInt();
                        patientsList.showNumMedCard(a, b);
                        break;
                    case 7:
                        patientsList.showNonInsurance();
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        patientsList.searchDiagnosis(sss);
                        break;
                    default:
                        System.out.println("The choice is not correct");
                        break;
                }
                menushka = patientsList.Menu(sss);
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObjectOutputStream ExistingFileRead(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            return new ObjectOutputStream(new FileOutputStream(file));
        }
        throw new IOException("The file is not exist");
    }
}