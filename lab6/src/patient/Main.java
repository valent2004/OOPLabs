package patient;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Main main = new Main();
            ObjectOutputStream oos = main.ExistingFileRead("D:/OOPLabs/lab6/src/patient/Patients.txt");
            PatientsList patientsList = new PatientsList();
            patientsList.writePatient("D:/OOPLabs/lab6/src/patient/Patients.txt");
            patientsList = new PatientsList();
            Scanner sss = new Scanner(System.in);
            patientsList.readPatient("D:/OOPLabs/lab6/src/patient/Patients.txt");
            int menushka = patientsList.Menu(sss);
            while(menushka != 5)
            {
                switch(menushka)
                {
                    case 1:
                        oos.flush();
                        patientsList.addNewPatient(sss);
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
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObjectOutputStream ExistingFileRead(String fileName) throws IOException
    {
        File file = new File(fileName);
        if (file.exists()) {return new ObjectOutputStream(new FileOutputStream(file));}
        throw new IOException("The file is not exist");
    }
}

