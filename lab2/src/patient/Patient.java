package patient;


public class Patient {
    private static int size = 0;
    private int id;
    private String surname;
    private String name;
    private String middlename;
    private String adress;
    private int phone;
    private int numMedCard;
    private Insurance insurance;
    private String diagnosis;

    public Patient(String surname, String name, String middlename, String adress, int phone, int numMedCard, Insurance insurance, String diagnosis) {
        id = ++size;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.adress = adress;
        this.phone = phone;
        this.numMedCard = numMedCard;
        this.insurance = insurance;
        this.diagnosis = diagnosis;
    }

    public void showDiagnosis(Patient[] patients) {
        System.out.println("\nThe list of diagnosis:\n");
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: " + patients[i].surname + "\nDiagnosis: " + patients[i].diagnosis);
        }
    }

    public void showNumMedCard(Patient[] patients, int minNum, int maxNum) {
        if (minNum < maxNum) {
            System.out.println("Interval from " + minNum + " to " + maxNum + ":\n");
            for (int i = 0; i < size; i++) {
                if (patients[i].numMedCard >= minNum && patients[i].numMedCard <= maxNum) {
                    System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: " + patients[i].surname + "\nThe number of medical card: " + patients[i].numMedCard);
                }
            }
            return;
        }
        System.out.println("Error of interval");
    }

    public void showNonInsurance(Patient[] patients) {
        int idCount = 0;
        System.out.println("\nThe list of non-insurance:\n");
        for (int i = 0; i < size; i++) {
            if (patients[i].insurance == Insurance.None) {
                System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: " + patients[i].surname);
                idCount++;
            }
        }
        System.out.println("The count is " + idCount);
    }

    public void showPatientsData(Patient[] patients) {
        System.out.println("\nThe list of patients:\n");
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: " + patients[i].surname + "\nAdress: " + patients[i].adress + "\nPhone: +380" + patients[i].phone + "\nThe number of medical card: " + patients[i].numMedCard + "\nThe insurance: " + patients[i].insurance + "\nDiagnosis: " + patients[i].diagnosis);
        }
    }
}
