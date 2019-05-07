public class Customer {

    private String firstname;
    private String lastname;
    private String nationalId;

    public Customer(String firstname, String lastname, String nationalId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalId = nationalId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
