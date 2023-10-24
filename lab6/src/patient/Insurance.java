package patient;

public enum Insurance
{
    None,
    Urgent,
    OutpatientPolyclinic,
    Stationary,
    Dentistry;
    public Insurance setInsurance(String searchedValue)
    {
        if (searchedValue.equals("Dentistry")) {
            return Insurance.Dentistry;
        }
        if (searchedValue.equals("Urgent")) {
            return Insurance.Urgent;
        }
        if (searchedValue.equals("OutpatientPolyclinic")) {
            return Insurance.OutpatientPolyclinic;
        }
        if (searchedValue.equals("Stationary")) {
            return Insurance.Stationary;
        }
        return Insurance.None;
    }
}