package Patient;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/Admin/OOPLabs/lab1/lab5/src/Patient/Patients.txt")))
        {
            try
            {
                ArrayList<Patient> patients = new ArrayList<Patient>();
                oos.flush();
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
                    Scanner sss = new Scanner(System.in);
                    newPeople =((ArrayList<Patient>)ois.readObject());
                    System.out.println("Do you want to add patient?(y/n)");
                    char yes = sss.next().charAt(0);
                    while (yes == 'y' || yes == 'Y')
                    {
                        oos.flush();
                        String surname = sss.next();
                        String name = sss.next();
                        String middlename = sss.next();
                        String adress = sss.next();
                        int phone = sss.nextInt();
                        int numMed = sss.nextInt();
                        String insurance = sss.next();
                        String diagnos = sss.next();
                        if(insurance.equals("None")){newPeople.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.None, diagnos));}
                        if(insurance.equals("Urgent")){newPeople.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Urgent, diagnos));}
                        if(insurance.equals("OutpatientPolyclinic")){newPeople.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.OutpatientPolyclinic, diagnos));}
                        if(insurance.equals("Stationary")){newPeople.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Stationary, diagnos));}
                        if(insurance.equals("Dentistry")){newPeople.add(new Patient(surname, name, middlename, adress, phone, numMed, Insurance.Dentistry, diagnos));}
                        oos.writeObject(newPeople);
                        System.out.println("Continue?(y/n)");
                        yes = sss.next().charAt(0);
                    }
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