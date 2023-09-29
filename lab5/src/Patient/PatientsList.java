package Patient;

import java.util.*;

public class PatientsList {
    private List<Patient> patientsList;

    public PatientsList() {
        patientsList = new ArrayList<>();
    }

    public void setPatientsList(List<Patient> patientsList){this.patientsList = patientsList;}

    public List<Patient> getPatientsList(){return patientsList;}

    public ArrayList<Patient> initArray() {
        ArrayList<Patient> patients = new ArrayList<Patient>(100);
        patients.add(new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn"));
        patients.add(new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn"));
        patients.add(new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms"));
        return patients;
    }

    public void showDiagnosis() {
        System.out.println("\nThe list of diagnosis:\n");
        for (Patient patient : patientsList) {
            if (patient != null) {
                System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: " + patient.getSurname() + "\nDiagnosis: " + patient.getDiagnosis());
            }
        }
    }

    public void showNumMedCard(int minNum, int maxNum) {
        if (minNum > maxNum) {
            System.out.println("Error of interval");
            return;
        }
        System.out.println("Interval from " + minNum + " to " + maxNum + ":\n");
        for (Patient patient : patientsList) {
            if (patient != null) {
                if (patient.getNumMedCard() >= minNum && patient.getNumMedCard() <= maxNum) {
                    System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: " + patient.getSurname() + "\nThe number of medical card: " + patient.getNumMedCard());
                }
            }
        }
    }

    public void showNonInsurance() {
        int idCount = 0;
        System.out.println("\nThe list of non-insurance:\n");
        for (Patient patient : patientsList) {
            if (patient != null) {
                if (patient.getInsurance() == Insurance.None) {
                    System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: " + patient.getSurname());
                    idCount++;
                }
            }
        }
        System.out.println("The count is " + idCount);
    }

    public void showPatientsData() {
        System.out.println("\nThe list of patients:\n");
        for (Patient patient : patientsList) {
            if (patient != null)
                System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: " + patient.getSurname() + "\nAdress: " + patient.getAddress() + "\nPhone: +380" + patient.getPhone() + "\nThe number of medical card: " + patient.getNumMedCard() + "\nThe insurance: " + patient.getInsurance() + "\nDiagnosis: " + patient.getDiagnosis());
        }
    }

    public ArrayList<Patient> addNewPatients(Scanner sss){
        ArrayList<Patient> patient = new ArrayList<Patient>(100);
        for (Patient patients : patientsList) {
            if (patients != null)
            {
                patient.add(patients);
            }
        }
        System.out.println("Do you want to add patient?(y/n)");
        char yes = sss.next().charAt(0);
        while (yes == 'y' || yes == 'Y') {
            String surname = sss.next();
            String name = sss.next();
            String middlename = sss.next();
            String adress = sss.next();
            int phone = sss.nextInt();
            int numMed = sss.nextInt();
            String insurance = sss.next();
            String diagnos = sss.next();
            if (insurance.equals("None")) {
                patient.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.None, diagnos));
            }
            if (insurance.equals("Urgent")) {
                patient.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Urgent, diagnos));
            }
            if (insurance.equals("OutpatientPolyclinic")) {
                patient.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.OutpatientPolyclinic, diagnos));
            }
            if (insurance.equals("Stationary")) {
                patient.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Stationary, diagnos));
            }
            if (insurance.equals("Dentistry")) {
                patient.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Dentistry, diagnos));
            }
            System.out.println("Continue?(y/n)");
            yes = sss.next().charAt(0);
        }
        return patient;
    }
}
