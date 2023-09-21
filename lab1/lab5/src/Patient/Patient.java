package Patient;
import java.io.*;
import java.util.ArrayList;

enum Insurance
{
    None,
    Urgent,
    OutpatientPolyclinic,
    Stationary,
    Dentistry
}

public class Patient  implements Serializable
{
    private static int size = 0;
    private static Boolean err = false;
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
        try
        {
            if(size < 100)
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
            else{throw new Exception("Too much");}
        }
        catch(Exception err)
        {
            System.out.println(err);
            setErr(true);
        }
    }
    public void showDiagnosis(ArrayList<Patient> patients)
    {
        System.out.println("\nThe list of diagnosis:\n");
        for(Patient p: patients)
        {
            System.out.println(p.id + ".\nName: " + p.name + "\nMiddlename: " + p.middlename + "\nSurname: "  + p.surname + "\nDiagnosis: " + p.diagnosis);
        }
    }
    public void showNumMedCard(ArrayList<Patient> patients, int minNum, int maxNum)
    {
        if(minNum < maxNum)
        {
            System.out.println("Interval from " + minNum + " to " + maxNum + ":\n");
            for(Patient p: patients)
            {
                if(p.numMedCard >= minNum && p.numMedCard <= maxNum)
                {
                    System.out.println(p.id + ".\nName: " + p.name + "\nMiddlename: " + p.middlename + "\nSurname: "  + p.surname + "\nThe number of medical card: " + p.numMedCard);
                }
            }
            return;
        }
        System.out.println("Error of interval");
    }
    public void showNonInsurance(ArrayList<Patient> patients)
    {
        int idCount = 0;
        System.out.println("\nThe list of non-insurance:\n");
        for(Patient p: patients)
        {
            if(p.insurance == Insurance.None)
            {
                System.out.println(p.id + ".\nName: " + p.name + "\nMiddlename: " + p.middlename + "\nSurname: "  + p.surname);
                idCount++;
            }
        }
        System.out.println("The count is " + idCount);
    }
    public void showPatientsData(ArrayList<Patient> patients)
    {
        System.out.println("\nThe list of patients:\n");
        for(Patient p: patients)
        {
            System.out.println(p.id + ".\nName: " + p.name + "\nMiddlename: " + p.middlename + "\nSurname: "  + p.surname + "\nAdress: " + p.adress + "\nPhone: +380" + p.phone + "\nThe number of medical card: " + p.numMedCard + "\nThe insurance: " + p.insurance + "\nDiagnosis: " + p.diagnosis);
        }
    }
    private void setErr(Boolean err){this.err = err;}
    public Boolean getErr(){return err;}
    public int getSize(){return size;}
}
