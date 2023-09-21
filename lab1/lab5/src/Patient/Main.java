package Patient;
import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/Admin/OOPLabs/lab1/lab5/src/Patient/Patients.txt")))
        {
            try
            {
                ArrayList<Patient> patients = new ArrayList<Patient>();


                patients.add(new Patient("Pankiv", "Valentyn", "Victor", "Kozazhka, 6", 689246864, 19, Insurance.Stationary, "First degree burn"));
                for(Patient p: patients) {if(p.getErr()){throw new Exception("Too much");}}
                patients.add(new Patient("Slobodian", "Ruslan", "Olesh", "Sumonenka, 7", 976604825, 28, Insurance.Urgent, "First degree burn"));
                for(Patient p: patients) {if(p.getErr()){throw new Exception("Too much");}}
                patients.add(new Patient("Mahinskyy", "Ura", "Andriy", "Zluky, 3", 689491192, 10, Insurance.None, "Fracture of two arms"));
                for(Patient p: patients) {if(p.getErr()){throw new Exception("Too much");}}
                for(Patient p: patients)
                {
                    p.showPatientsData(patients);
                    p.showDiagnosis(patients);
                    p.showNumMedCard(patients, 1, 20);
                    p.showNonInsurance(patients);
                    break;
                }

                oos.writeObject(patients);
                ArrayList<Patient> newPeople= new ArrayList<Patient>();

                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/Admin/OOPLabs/lab1/lab5/src/Patient/Patients.txt")))
                {
                    newPeople =((ArrayList<Patient>)ois.readObject());
                    System.out.println("New data:");
                    for(Patient p: newPeople)
                    {
                        p.showPatientsData(newPeople);
                        break;
                    }
                }
                catch(IOException err)
                {
                    System.out.println(err.getMessage());
                }
            }
            catch(Exception err)
            {
                System.out.println(err);
            }
        }
        catch(IOException err)
        {
            System.out.println(err.getMessage());
        }
    }
}