public abstract class Application {
	protected Applicant applicant;
	protected Staff handler;
	protected String applicationID;
	protected String application_date;
	protected String application_time;
	protected String reason;
	protected String transportation_type;
	protected String transportartion_no;
	protected String departure_date;
	protected String departure_time;
	protected int status;

	Application(String applicationID, String application_date, String application_time, String reason) {
		this.applicationID = applicationID;
		this.application_date = application_date;
		this.application_time = application_time;
		this.reason = reason;
		status = 0;
	}

	public void setApplicant(Applicant a) {
		applicant = a;
	}

	public void assignedToHandler(Staff handler) {
		this.handler = handler;
	}

	public void setTransportation(String transportation_type, String transportartion_no) {
		this.transportation_type = transportation_type;
		this.transportartion_no = transportartion_no;
	}

	public void setDepartureDateTime(String departure_date, String departure_time) {
		this.departure_date = departure_date;
		this.departure_time = departure_time;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public String getApplicationDateTime() {
		return application_date + ", " + application_time;
	}

	public String getreason() {
		return reason;
	}

	public String getTransportationType() {
		return transportation_type;
	}

	public String getTransportationNo() {
		return transportartion_no;
	}

	public String getDepartureDateTime() {
		return departure_date + ", " + departure_time;
	}

	public abstract void displayApplicationInfo();
}