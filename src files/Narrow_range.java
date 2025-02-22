public class Narrow_range extends Application {
	private String state;
	private String origin_district;
	private String destination_district;

	public Narrow_range(String application_ID, String application_Date, String application_Time, String p, String state,
			String origin_district,
			String destination_district) {
		super(application_ID, application_Date, application_Time, p);
		this.state = state;
		this.origin_district = origin_district;
		this.destination_district = destination_district;
	}

	public String getState() {
		return state;
	}

	public String getOriginDistrict() {
		return origin_district;
	}

	public String getDestinationDistrict() {
		return destination_district;
	}

	public void displayApplicationInfo() {
		System.out.println("\n<<<<<<Cross District Application>>>>>>");
		System.out.println("Name: " + applicant.getApplicant_name());
		System.out.println("ICNo: " + applicant.getApplicant_IcNo());
		System.out.println("Address: " + applicant.getApplicant_address());
		System.out.println(
				"Gender: " + applicant.getApplicant_gender() + "\t\t\tPhone No: " + applicant.getApplicant_phoneNo());
		System.out.println("Email: " + applicant.getApplicant_email() + "\t\t\tJob: " + applicant.getApplicant_job());
		System.out.println("Application ID: " + applicationID);
		System.out.println("Application Date & Time: " + getApplicationDateTime());
		System.out.println(
				"Transportation Type: " + getTransportationType() + "\t\t\tVehicle No: " + getTransportationNo());
		System.out.println("Origin State: " + getState() + "\t\t\tOrigin District: " + getOriginDistrict());
		System.out.println("Destination District: " + getDestinationDistrict());
		System.out.println("Departure Date & Time: " + getDepartureDateTime());
		System.out.println("reason : " + getreason());
		String app_status = "";
		switch (getStatus()) {
			case -1:
				app_status = "Rejected";
				break;
			case 0:
				app_status = "Pending";
				break;
			case 1:
				app_status = "Approved";
				break;
		}
		System.out.println("\nStatus: " + app_status);
		if (!app_status.equals("Pending")) {

			System.out.println("\nProcessed by: " + handler.getStaff_name());
			System.out.println("\nPosition:  " + handler.getStaff_position());
			System.out.println("\nDepartment: " + handler.getStaff_department());
		}

	}
}