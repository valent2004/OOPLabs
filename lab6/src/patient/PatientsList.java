package patient;

import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectOutputStream;
import java.util.*;

public class PatientsList {
    private List<Patient> patientsList;

    public PatientsList() {patientsList = new ArrayList<>();}

    public void setPatientList(List<Patient> patientsList){this.patientsList = patientsList;}

    public void setPatient(Patient patient){patientsList.add(patient);}

    public List<Patient> getPatientsList(){return patientsList;}

    public void initArray() {
        List<Patient> patients = new ArrayList<Patient>(100);
        patients.add(new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn"));
        patients.add(new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn"));
        patients.add(new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms"));
        patientsList = patients;
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

    public void addNewPatient(Scanner sss){
        String surname = sss.next();
        String name = sss.next();
        String middlename = sss.next();
        String adress = sss.next();
        int phone = sss.nextInt();
        int numMed = sss.nextInt();
        String insurance = sss.next();
        String diagnos = sss.next();
        Insurance insurances = Insurance.None;
        insurances = insurances.setInsurance(insurance);
        patientsList.add(new Patient(surname, name, middlename, adress, phone, numMed, insurances, diagnos));
    }

    public int searchPatients(Scanner sss)
    {
        int index = 0;
        int choice = Menu2(sss);
        Field field = Field.Surname;
        switch (choice)
        {
            case 1:
                String surname = sss.next();
                index = findPatientByField(field, surname);
                break;
            case 2:
                String name = sss.next();
                field = Field.Name;
                index = findPatientByField(field, name);
                break;
            case 3:
                String middleName = sss.next();
                field = Field.MiddleName;
                index = findPatientByField(field, middleName);
                break;
            case 4:
                String address = sss.next();
                field = Field.Address;
                index = findPatientByField(field, address);
                break;
            case 5:
                int NumMed = sss.nextInt();
                field = Field.NumMedCard;
                index = findPatientByField(field, NumMed);
                break;
            case 6:
                int phone = sss.nextInt();
                field = Field.Phone;
                index = findPatientByField(field, phone);
                break;
            case 7:
                String insurance = sss.next();
                field = Field.Insurance;
                Insurance insurances = Insurance.None;
                insurances = insurances.setInsurance(insurance);
                index = findPatientByField(field, insurances);
                break;
            case 8:
                String diagnos = sss.next();
                field = Field.Diagnosis;
                index = findPatientByField(field, diagnos);
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

    private int findPatientByField(Field fieldName, Object searchedValue)
    {
        int index = 0;
        for (Patient patients : patientsList) {
            if (patients != null)
            {
                switch(fieldName)
                {
                    case Surname:
                        if(searchedValue.equals(patients.getSurname()))
                        {
                            return index;
                        }
                        break;
                    case Name:
                        if(searchedValue.equals(patients.getName()))
                        {
                            return index;
                        }
                        break;
                    case MiddleName:
                        if(searchedValue.equals(patients.getMiddleName()))
                        {
                            return index;
                        }
                        break;
                    case Address:
                        if(searchedValue.equals(patients.getAddress()))
                        {
                            return index;
                        }
                        break;
                    case NumMedCard:
                        if((int)searchedValue == patients.getNumMedCard())
                        {
                            return index;
                        }
                        break;
                    case Phone:
                        if((int)searchedValue == patients.getPhone())
                        {
                            return index;
                        }
                        break;
                    case Insurance:
                        if(searchedValue == patients.getInsurance())
                        {
                            return index;
                        }
                        break;
                    case Diagnosis:
                        if(searchedValue.equals(patients.getDiagnosis()))
                        {
                            return index;
                        }
                        break;
                }
                if(searchedValue == patients.getInsurance())
                {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    public void writePatient(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (file.exists())
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            initArray();
            oos.flush();
            showPatientsData();
            showDiagnosis();
            showNumMedCard(1, 20);
            showNonInsurance();
            oos.writeObject(getPatientsList());
            return;
        }
        throw new IOException("The file is not exist");
    }

    public void readPatient(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (file.exists())
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            setPatientList(((ArrayList<Patient>) ois.readObject()));
            return;
        }
        throw new IOException("The file is not exist");
    }
}