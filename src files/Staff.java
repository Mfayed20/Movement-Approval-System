import java.util.Vector;

public class Staff {
    private String staff_name, staff_ID, staff_position, staff_department;
    Vector<Application> applications;

    public Staff(String staff_name, String staff_ID, String staff_position, String staff_department) {
        this.staff_name = staff_name;
        this.staff_ID = staff_ID;
        this.staff_position = staff_position;
        this.staff_department = staff_department;
        applications = new Vector<Application>();
    }

    public String getStaff_name() {
        return staff_name;
    }

    public String getStaff_ID() {
        return staff_ID;
    }

    public String getStaff_position() {
        return staff_position;
    }

    public String getStaff_department() {
        return staff_department;
    }

    public void addApplication(Application application) {
        applications.addElement(application);
    }

    public void displayApplicationList() {
        System.out.println("Staff name: " + staff_name);
        System.out.println("Staff ID: " + staff_ID);
        System.out.println("Staff position: " + staff_position);
        System.out.println("Staff department: " + staff_department + "\n");
        if (applications.size() == 0) {
            System.out.println("There is no applications processed by you...");
        } else {
            System.out.printf("%-5s%-20s%-20s%-30s%-20s%-30s%-30s%-10s%n", "No.", "Name", "IC No", "App Type", "App ID",
                    "reason ", "App Date Time", "Status");

            String status = "";
            String application_type = "";
            for (int i = 0; i < applications.size(); i++) {
                switch ((applications.elementAt(i)).getStatus()) {
                    case -1:
                        status = "Rejected";
                        break;
                    case 0:
                        status = "Pending";
                        break;
                    case 1:
                        status = "Approved";
                        break;
                }
                if (applications.elementAt(i) instanceof Narrow_range) {
                    application_type = "Cross-district";
                } else {
                    application_type = "Wide_range";
                }
                System.out.printf("%-5d%-20s%-20s%-30s%-20s%-30s%-30s%-10s%n", (i + 1),
                        ((applications.elementAt(i)).getApplicant()).getApplicant_name(),
                        ((applications.elementAt(i)).getApplicant()).getApplicant_IcNo(),
                        application_type, (applications.elementAt(i)).getApplicationID(),
                        (applications.elementAt(i)).getreason(), (applications.elementAt(i)).getApplicationDateTime(),
                        status);
            }

        }
    }
}
