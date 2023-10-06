package patient;

public enum Insurance
{
    None,
    Urgent,
    OutpatientPolyclinic,
    Stationary,
    Dentistry;
    public Insurance setInsurance(String str)
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
}
