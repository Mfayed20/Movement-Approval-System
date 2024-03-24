public class Address{
    private String applicant_street;
    private String applicant_city;
    private String applicant_state;

    Address (String applicant_street, String applicant_city, String applicant_state){
        this.applicant_street = applicant_street;
        this.applicant_city = applicant_city;
        this.applicant_state = applicant_state;
    }

    public void setAddress(String applicant_street, String applicant_city, String applicant_state){
        this.applicant_street = applicant_street;
        this.applicant_city = applicant_city;
        this.applicant_state = applicant_state;
    }

    public String getAddress(){
        return applicant_street + ", " + applicant_city + ", " + applicant_state;
    }
}