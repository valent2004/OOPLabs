package patient;

public class Main {
    public static void main(String[] args) {
        Patient[] patients = new Patient[100];
        patients[0] = new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn");
        patients[1] = new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn");
        patients[2] = new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms");
        patients[0].showPatientsData(patients);
        patients[0].showDiagnosis(patients);
        patients[0].showNumMedCard(patients, 1, 20);
        patients[0].showNonInsurance(patients);
    }
}