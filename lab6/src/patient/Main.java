package patient;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/OOPLabs/lab6/src/patient/Patients.txt"))) {
            PatientsList patientsList = new PatientsList();
            patientsList.initArray();
            oos.flush();
            patientsList.showPatientsData();
            patientsList.showDiagnosis();
            patientsList.showNumMedCard(1, 20);
            patientsList.showNonInsurance();
            oos.writeObject(patientsList.getPatientsList());
            patientsList = new PatientsList();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/OOPLabs/lab6/src/patient/Patients.txt"))) {
                Scanner sss = new Scanner(System.in);
                patientsList.setPatientList(((ArrayList<Patient>) ois.readObject()));
                int menushka = patientsList.Menu(sss);
                while(menushka != 5)
                {
                    switch(menushka)
                    {
                        case 1:
                            oos.flush();
                            patientsList.setPatient(patientsList.addNewPatients(sss));
                            oos.writeObject(patientsList.getPatientsList());
                            break;
                        case 2:
                            oos.flush();
                            int patient = patientsList.searchPatients(sss);
                            if(patient != -1){patientsList.getPatientsList().remove(patient);}
                            oos.writeObject(patientsList.getPatientsList());
                            break;
                        case 3:
                            patientsList.showPatientsData();
                            break;
                        case 4:
                            int patient2 = patientsList.searchPatients(sss);
                            if(patient2 != -1){System.out.println(patientsList.getPatientsList().get(patient2).getID() + ".\nName: " + patientsList.getPatientsList().get(patient2).getName() + "\nMiddlename: " + patientsList.getPatientsList().get(patient2).getMiddleName() + "\nSurname: " + patientsList.getPatientsList().get(patient2).getSurname() + "\nAdress: " + patientsList.getPatientsList().get(patient2).getAddress() + "\nPhone: +380" + patientsList.getPatientsList().get(patient2).getPhone() + "\nThe number of medical card: " + patientsList.getPatientsList().get(patient2).getNumMedCard() + "\nThe insurance: " + patientsList.getPatientsList().get(patient2).getInsurance() + "\nDiagnosis: " + patientsList.getPatientsList().get(patient2).getDiagnosis());}
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
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}