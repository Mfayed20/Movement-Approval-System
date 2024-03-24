

public class Applicant {
    private String applicant_name, applicant_IcNo, applicant_gender,applicant_phoneNo,applicant_email,applicant_job;
    private Address applicant_address;
	public Applicant ()
	{
	}
    public Applicant (String applicant_name, String applicant_IcNo, Address applicant_address, String applicant_phoneNo, String applicant_email, String applicant_job){
        this.applicant_name = applicant_name;
        this.applicant_IcNo = applicant_IcNo;
        this.applicant_address = applicant_address;
        this.applicant_phoneNo = applicant_phoneNo;
        this.applicant_email = applicant_email;
        this.applicant_job = applicant_job;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public void setApplicant_IcNo(String applicant_IcNo) {
        this.applicant_IcNo = applicant_IcNo;
    }

    public void setApplicant_address(Address applicant_address) {
        this.applicant_address = applicant_address;
    }

    public void setApplicant_phoneNo(String applicant_phoneNo) {
        this.applicant_phoneNo = applicant_phoneNo;
    }

    public void setApplicant_email(String applicant_email) {
        this.applicant_email = applicant_email;
    }

    public void setApplicant_job(String applicant_job) {
        this.applicant_job = applicant_job;
    }

    public void setApplicant_gender(String applicant_gender){
		if (applicant_gender.toUpperCase().equals("M"))
		{
			this.applicant_gender="Male";
		}
		else if (applicant_gender.toUpperCase().equals("F"))
		{
			this.applicant_gender="Female";
		}
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public String getApplicant_IcNo() {
        return applicant_IcNo;
    }

    public String getApplicant_address() {
        return applicant_address.getAddress();
    }

    public String getApplicant_gender() {
        return applicant_gender;
    }

    public String getApplicant_phoneNo() {
        return applicant_phoneNo;
    }

    public String getApplicant_email() {
        return applicant_email;
    }

    public String getApplicant_job() {
        return applicant_job;
    }
}
