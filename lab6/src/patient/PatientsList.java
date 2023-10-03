package patient;

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
            patient.add(new Patient(surname, name, middlename, adress, phone, numMed, settingInsurance(insurance), diagnos));
            System.out.println("Continue?(y/n)");
            yes = sss.next().charAt(0);
        }
        return patient;
    }

    public int searchPatients(Scanner sss)
    {
        int index = 0;
        int choice = Menu2(sss);
        switch (choice)
        {
            case 1:
                String surname = sss.next();
                index = settingPatient(surname, choice, index);
                break;
            case 2:
                String name = sss.next();
                index = settingPatient(name, choice, index);
                break;
            case 3:
                String middleName = sss.next();
                index = settingPatient(middleName, choice, index);
                break;
            case 4:
                String address = sss.next();
                index = settingPatient(address, choice, index);
                break;
            case 5:
                String NumMed = sss.next();
                index = settingPatient(NumMed, choice, index);
                break;
            case 6:
                String phone = sss.next();
                index = settingPatient(phone, choice, index);
                break;
            case 7:
                String insurance = sss.next();
                index = settingPatient(settingInsurance(insurance), choice, index);
                break;
            case 8:
                String diagnos = sss.next();
                index = settingPatient(diagnos, choice, index);
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
        if(index != -1)
        {
            System.out.println("We found the patient");
            return index;
        }
        System.out.println("We don't find the patient yet!");
        return index;
    }

    public int Menu(Scanner sss)
    {
        System.out.println("\nEnter your choice:");
        System.out.println("1-Add patient");
        System.out.println("2-Delete patient");
        System.out.println("3-Look patients");
        System.out.println("4-Search patients");
        System.out.println("5-Exit");
        return sss.nextInt();
    }

    public int Menu2(Scanner sss)
    {
        System.out.println("\nEnter your searching type:");
        System.out.println("1-Surname");
        System.out.println("2-Name");
        System.out.println("3-MiddleName");
        System.out.println("4-Address");
        System.out.println("5-NumMed");
        System.out.println("6-Phone");
        System.out.println("7-Insurance");
        System.out.println("8-Diagnos");
        return sss.nextInt();
    }

    private Insurance settingInsurance(String str)
    {
        if (str.equals("Dentistry")) {
            return Insurance.Dentistry;
        }
        if (str.equals("Urgent")) {
            return Insurance.Urgent;
        }
        if (str.equals("OutpatientPolyclinic")) {
            return Insurance.OutpatientPolyclinic;
        }
        if (str.equals("Stationary")) {
            return Insurance.Stationary;
        }
        return Insurance.None;
    }

    private int settingPatient(String str, int i, int index)
    {
        for (Patient patients : patientsList) {
            if (patients != null)
            {
                switch(i)
                {
                    case 1:
                        if(str.equals(patients.getSurname()))
                        {
                            return index;
                        }
                        break;
                    case 2:
                        if(str.equals(patients.getName()))
                        {
                            return index;
                        }
                        break;
                    case 3:
                        if(str.equals(patients.getMiddleName()))
                        {
                            return index;
                        }
                        break;
                    case 4:
                        if(str.equals(patients.getAddress()))
                        {
                            return index;
                        }
                        break;
                    case 8:
                        if(str.equals(patients.getDiagnosis()))
                        {
                            return index;
                        }
                        break;
                    default:
                        break;
                }
            }
            index++;
        }
        return -1;
    }

    private int settingPatient(int str, int i, int index)
    {
        for (Patient patients : patientsList) {
            if (patients != null)
            {
                switch(i)
                {
                    case 5:
                        if(str == patients.getNumMedCard())
                        {
                            return index;
                        }
                        break;
                    case 6:
                        if(str == patients.getPhone())
                        {
                            return index;
                        }
                        break;
                    default:
                        break;
                }
            }
            index++;
        }
        return -1;
    }

    private int settingPatient(Insurance str, int i, int index)
    {
        for (Patient patients : patientsList) {
            if (patients != null)
            {
                switch(i)
                {
                    case 7:
                        if(str == patients.getInsurance())
                        {
                            return index;
                        }
                        break;
                    default:
                        break;
                }
            }
            index++;
        }
        return -1;
    }
}
