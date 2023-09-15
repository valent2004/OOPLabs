// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Patient[] patients = new Patient[100];
        patients[0] = new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn");
        patients[1] = new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn");
        patients[2] = new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms");
        patients[0].showPatientsData(patients);
        patients[0].showDiagnosis(patients);
        patients[0].showNumMedCard(patients);
        patients[0].showNonInsurance(patients);
    }
}

enum Insurance
{
    None,
    Urgent,
    OutpatientPolyclinic,
    Stationary,
    Dentistry
}

class Patient
{
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
    public Patient(String surname, String name, String middlename, String adress, int phone, int numMedCard, Insurance insurance, String diagnosis)
    {
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
    public void showDiagnosis(Patient[] patients)
    {
        System.out.println("\nThe list of diagnosis:\n");
        for(int i = 0; i < size; i++)
        {
            System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: "  + patients[i].surname + "\nDiagnosis: " + patients[i].diagnosis);
        }
    }
    public void showNumMedCard(Patient[] patients)
    {
        Patient[] med = new Patient[size];
        for(int i = 0; i < size; i++)
        {
            med[i] = patients[i];
        }
        for(int i = 0; i < size; i++)
        {
            if(i != size - 1)
            {
                for(int j = i + 1; j < size; j++)
                {
                    if(med[i].numMedCard > med[j].numMedCard)
                    {
                        Patient temp = med[i];
                        med[i] = med[j];
                        med[j] = temp;
                    }
                }
            }
        }
        System.out.println("\nThe list of number of medical cards:\n");
        for(int i = 0; i < size; i++)
        {
            System.out.println(med[i].id + ".\nName: " + med[i].name + "\nMiddlename: " + med[i].middlename + "\nSurname: "  + med[i].surname + "\nThe number of medical card: " + med[i].numMedCard);
        }
    }
    public void showNonInsurance(Patient[] patients)
    {
        int idCount = 0;
        System.out.println("\nThe list of non-insurance:\n");
        for(int i = 0; i < size; i++)
        {
            if(patients[i].insurance == Insurance.None)
            {
                System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: "  + patients[i].surname);
                idCount++;
            }
        }
        System.out.println("The count is " + idCount);
    }
    public void showPatientsData(Patient[] patients)
    {
        System.out.println("\nThe list of patients:\n");
        for(int i = 0; i < size; i++)
        {
            System.out.println(patients[i].id + ".\nName: " + patients[i].name + "\nMiddlename: " + patients[i].middlename + "\nSurname: "  + patients[i].surname + "\nAdress: " + patients[i].adress + "\nPhone: +380" + patients[i].phone + "\nThe number of medical card: " + patients[i].numMedCard + "\nThe insurance: " + patients[i].insurance + "\nDiagnosis: " + patients[i].diagnosis);
        }
    }
}