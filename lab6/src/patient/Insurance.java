package patient;

public enum Insurance
{
    None,
    Urgent,
    OutpatientPolyclinic,
    Stationary,
    Dentistry;
    public Insurance setInsurance(String value)
    {
        if (value.equals("Dentistry")) {
            return Insurance.Dentistry;
        }
        if (value.equals("Urgent")) {
            return Insurance.Urgent;
        }
        if (value.equals("OutpatientPolyclinic")) {
            return Insurance.OutpatientPolyclinic;
        }
        if (value.equals("Stationary")) {
            return Insurance.Stationary;
        }
        return Insurance.None;
    }
}
