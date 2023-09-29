package patient;

public class Patient {
    private static int size = 0;
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private int phone;
    private int numMedCard;
    private Insurance insurance;
    private String diagnosis;

    public Patient(String surname, String name, String middlename, String adress, int phone, int numMedCard, Insurance insurance, String diagnosis) {
        id = ++size;
        this.surname = surname;
        this.name = name;
        this.middleName = middlename;
        this.address = adress;
        this.phone = phone;
        this.numMedCard = numMedCard;
        this.insurance = insurance;
        this.diagnosis = diagnosis;
    }

    int getSize() {
        return size;
    }

    int getID() {
        return id;
    }

    String getSurname() {
        return surname;
    }

    String getName() {
        return name;
    }

    String getMiddleName() {
        return middleName;
    }

    String getAddress() {
        return address;
    }

    int getPhone() {
        return phone;
    }

    int getNumMedCard() {
        return numMedCard;
    }

    Insurance getInsurance() {
        return insurance;
    }

    String getDiagnosis() {
        return diagnosis;
    }
}
