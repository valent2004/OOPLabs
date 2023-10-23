package patient;

public class Main
{
    public static void main(String[] args) {
        Main main = new Main();
        Patient[] patients = main.initArray();
        main.showPatientsData(patients);
        main.showDiagnosis(patients);
        main.showNumMedCard(patients, 1, 20);
        main.showNonInsurance(patients);
    }

    private Patient[] initArray() {
        Patient[] patients = new Patient[100];
        patients[0] = new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn");
        patients[1] = new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn");
        patients[2] = new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms");
        return patients;
    }

    public void showDiagnosis(Patient[] patients)
    {
        System.out.println("\nThe list of diagnosis:\n");
        for(Patient patient : patients)
        {
            if(patient != null)System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: "  + patient.getSurname() + "\nDiagnosis: " + patient.getDiagnosis());
        }
    }

    public void showNumMedCard(Patient[] patients, int minNum, int maxNum)
    {
        if(minNum < maxNum)
        {
            System.out.println("Interval from " + minNum + " to " + maxNum + ":\n");
            for(Patient patient : patients)
            {
                if(patient != null)
                {
                    if(patient.getNumMedCard() >= minNum && patient.getNumMedCard() <= maxNum)
                {
                    System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: "  + patient.getSurname() + "\nThe number of medical card: " + patient.getNumMedCard());
                }
                }

            }
            return;
        }
        System.out.println("Error of interval");
    }

    public void showNonInsurance(Patient[] patients)
    {
        int idCount = 0;
        System.out.println("\nThe list of non-insurance:\n");
        for(Patient patient : patients)
        {
            if(patient != null)
            {
                if(patient.getInsurance() == Insurance.None)
                {
                    System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: "  + patient.getSurname());
                    idCount++;
                }
            }
        }
        System.out.println("The count is " + idCount);
    }

    public void showPatientsData(Patient[] patients)
    {
        System.out.println("\nThe list of patients:\n");
        for(Patient patient : patients)
        {
            if(patient != null) System.out.println(patient.getID() + ".\nName: " + patient.getName() + "\nMiddlename: " + patient.getMiddleName() + "\nSurname: "  + patient.getSurname() + "\nAdress: " + patient.getAddress() + "\nPhone: +380" + patient.getPhone() + "\nThe number of medical card: " + patient.getNumMedCard() + "\nThe insurance: " + patient.getInsurance() + "\nDiagnosis: " + patient.getDiagnosis());
        }
    }
}
