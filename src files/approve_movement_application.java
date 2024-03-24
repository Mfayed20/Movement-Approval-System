import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class approve_movement_application {
	public static void displayApplicantMenu() {
		System.out.println("\n<<<< good morning >>>>>");
		System.out.println("Please choose the following choice 1,2,3");
		System.out.println("1) Make a movement approval application ");
		System.out.println("2) View application status");
		System.out.println("3) back");
		System.out.print("\nYour operation: ");
	}

	public static void displayStaffMenu() {
		System.out.println("\n<<<< Staff Interface >>>>>");
		System.out.println("Please choose the following choice 1,2,3");
		System.out.println("1) Process pending movement approval application");
		System.out.println("2) View applications made by you");
		System.out.println("3) Back ");
		System.out.print("\nYour operation: ");
	}

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("<<< movement approval Application System>>>");
		System.out.println("\nBefore the program gets started, you must adjust staff first");
		System.out.println("Please fill in the application");

		ArrayList<Staff> Staff_list = new ArrayList<Staff>();

		String Staff_name, Staff_ID, Staff_Position, Staff_Department;
		String choice;
		do {
			System.out.print("\nStaff name: ");
			Staff_name = input.nextLine();
			System.out.print("Staff ID: ");
			Staff_ID = input.nextLine();
			System.out.print("Staff Position: ");
			Staff_Position = input.nextLine();
			System.out.print("Staff Department: ");
			Staff_Department = input.nextLine();
			Staff sTemp = new Staff(Staff_name, Staff_ID, Staff_Position, Staff_Department);
			Staff_list.add(sTemp);
			do {
				System.out.println("\nstill want to add new staff?\nPress Y if Yes\nPress N if No");
				System.out.print("Choice: ");
				choice = input.nextLine().toUpperCase();
				if (!choice.equals("Y") && !choice.equals("N")) {
					System.out.println("Invalid input...Please enter again");
				}
			} while (!choice.equals("Y") && !choice.equals("N"));
		} while (!choice.equals("N"));
		System.out.println("\n\n");
		//

		ArrayList<Application> application_list = new ArrayList<Application>();
		int option_category = 0, numCD = 0, numCS = 0;
		do {

			System.out.println("\nPlease select the following user category");
			System.out.println("1) Applicant");
			System.out.println("2) Staff");
			System.out.println("\nOr\n3) Terminate the program");

			boolean level1 = true;
			do {
				try {
					System.out.print("\nYour category: ");
					option_category = Integer.parseInt(input.nextLine());
					level1 = false;

					System.out.println("\n\n");
				} catch (Exception e) {
					System.out.println("Your input is not an Integer.Please try again");

				}
			} while (level1);

			if (option_category == 1) {
				int option_Applicant = 0;
				do {
					boolean level2;// level handling 2
					displayApplicantMenu();
					do {
						level2 = true;
						try {
							option_Applicant = Integer.parseInt(input.nextLine());
							level2 = false;
							if (option_Applicant != 1 && option_Applicant != 2 && option_Applicant != 3) {
								System.out.println("Invalid input...Please try again");
								System.out.print("\nYour operation: ");
							}
						} catch (Exception e) {
							System.out.println("Your input is not an Integer.Please try again");
							System.out.print("\nYour operation: ");

						}
					} while (level2 || (option_Applicant != 1 && option_Applicant != 2 && option_Applicant != 3));

					if (option_Applicant == 1) {
						int option = 0;
						System.out.println("\n\n<<< Make a movement approval application >>>");
						System.out.println(
								"Please select the type of application u want \n1) Wide range application\n2) Narrow range application");
						do {

							boolean level3 = true;
							do {
								// level handling 3
								try {
									System.out.print("\nApplication type : ");
									option = Integer.parseInt(input.nextLine());

									System.out.println("\n");
									level3 = false;
									if (option != 1 && option != 2) {
										System.out.println("Invalid input...Please try again");
									}
								} catch (Exception e) {
									System.out.println("Your input is not an Integer.Please try again");
								}
							} while (level3 || (option != 1 && option != 2));
							String name, ic, gender, street, city, state, phone, email, occupation, app_date, app_time,
									type_no, dep_date, dep_time, reason;
							int movent_type;
							System.out.println("\nPlease fill in the following information ");
							System.out.print("\nName: ");
							name = input.nextLine();
							System.out.print("\nIC number: ");
							ic = input.nextLine();
							System.out.print("\nGender (M for Male/F for Female): ");
							gender = input.nextLine().toUpperCase();
							System.out.println("\n");
							System.out.println("\n<<< Address >>>");
							System.out.print("\t\tStreet: ");
							street = input.nextLine();
							System.out.print("\t\tCity: ");
							city = input.nextLine();
							System.out.print("\t\tState: ");
							state = input.nextLine();
							System.out.print("\nPhone number: ");
							phone = input.nextLine();
							System.out.print("\nEmail address: ");
							email = input.nextLine();
							System.out.print("\nOccupation: ");
							occupation = input.nextLine();

							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							DateFormat timeFormat = new SimpleDateFormat("hh.mm aa");
							app_date = dateFormat.format(new Date()).toString();
							app_time = timeFormat.format(new Date()).toString();

							System.out.println("\n\n<<< Information of Application >>>");
							System.out.println("\nApplication date: " + app_date);

							System.out.println("Application Time: " + app_time);

							System.out.print("\nReason for making this application: ");
							reason = input.nextLine();

							System.out.println("\n<<< movement type >>>");
							System.out.println("\t\t1) Personal Car");
							System.out.println("\t\t2) Public transport such as Bus and subway ");
							System.out.println("\t\t3) Flight");

							do {
								System.out.print("\nTransportation type (1,2 or 3): ");
								movent_type = Integer.parseInt(input.nextLine());
								if (!(movent_type == 1 || movent_type == 2 || movent_type == 3)) {
									System.out.println("Invalid input...Please enter again");
								}
							} while (!(movent_type == 1 || movent_type == 2 || movent_type == 3));

							System.out.println("\nPlease enter the transportation number\nFor instance\n");

							System.out.println("1) Transportation number for personal vehicle=Vehicle's plate Number");
							System.out
									.println(
											"2) Transportation number for public transport=Bus Number or subway Number");
							System.out.println("3) Transportation number for flight=Flight Number");
							System.out.print("\nTransportation number: ");
							type_no = input.nextLine();
							System.out.println("\nPlease enter your departure date and time");
							System.out.print("\nDeparture date (DD/MM/YYYY): ");
							dep_date = input.nextLine();
							String AMPM;
							System.out.println("Departure time: ");
							do {
								System.out.print("\tam or pm: ");
								AMPM = input.nextLine().toLowerCase();
							} while (!AMPM.equals("am") && !AMPM.equals("pm"));
							System.out.print("\tTime in Hour.Minute format: ");
							dep_time = input.nextLine();
							dep_time = dep_time + " " + AMPM;
							System.out.println("\n\n");
							Address alamat = new Address(street, city, state);
							Applicant person = new Applicant(name, ic, alamat, phone, email, occupation);
							person.setApplicant_gender(gender);

							if (option == 1) {
								String app_id;
								String app_state, ori_district, dest_district;
								System.out.println("<<< Wide Range (within state) >>>");
								System.out.print("State: ");
								app_state = input.nextLine();
								System.out.print("Origin district: ");
								ori_district = input.nextLine();
								System.out.print("Destination district: ");
								dest_district = input.nextLine();
								numCD++;
								app_id = "CD0" + Integer.toString(numCD);
								System.out.println("\n\nYour application is submitted successfully");

								System.out.println("\nYour application ID is " + app_id + "\n");
								Application Narrow_range = new Narrow_range(app_id, app_date, app_time, reason,
										app_state, ori_district, dest_district);
								Narrow_range.setApplicant(person);
								switch (movent_type) {
									case 1:
										Narrow_range.setTransportation("Personal vehicle", type_no);
										break;
									case 2:
										Narrow_range.setTransportation("Public transport", type_no);
										break;
									case 3:
										Narrow_range.setTransportation("Flight", type_no);
										break;
								}

								Narrow_range.setDepartureDateTime(dep_date, dep_time);

								application_list.add(Narrow_range);

							} else if (option == 2) {
								String app_id;
								String ori_state, ori_district, dest_state, dest_district;
								System.out.println("<<< Wide Range >>>");
								System.out.print("Origin State: ");
								ori_state = input.nextLine();
								System.out.print("Origin district: ");
								ori_district = input.nextLine();
								System.out.print("Destination State: ");
								dest_state = input.nextLine();
								System.out.print("Destination district: ");
								dest_district = input.nextLine();
								numCS++;
								app_id = "CS0" + Integer.toString(numCS);
								System.out.println("\n\nYour application is submitted successfully");
								System.out.println("\nYour application ID is " + app_id + "\n");
								Application Wide_range = new Wide_range(app_id, app_date, app_time, reason,
										ori_state, ori_district, dest_state, dest_district);
								Wide_range.setApplicant(person);
								switch (movent_type) {
									case 1:
										Wide_range.setTransportation("Personal vehicle", type_no);
										break;
									case 2:
										Wide_range.setTransportation("Public transport", type_no);
										break;
									case 3:
										Wide_range.setTransportation("Flight", type_no);
										break;
								}

								Wide_range.setDepartureDateTime(dep_date, dep_time);

								application_list.add(Wide_range);

							} else {
								System.out.println("Invalid input...Please try again");

							}

						} while (!(option == 1 || option == 2));
					}

					else if (option_Applicant == 2) {
						int optForView = 0;

						do {
							System.out.println("\n<<< View Your Application >>>");
							System.out.println("1) Search by Application ID");
							System.out.println("2) Search by Ic Number");
							System.out.println("3) Return to the previous page");
							boolean level4 = true;
							while (level4) {
								// Exception handling 4
								try {
									System.out.print("\nChoice (1, 2, or 3): ");
									optForView = Integer.parseInt(input.nextLine());
									level4 = false;

								} catch (Exception e) {
									System.out.println("Your input is not an Integer.Please try again");
								}
							}

							if (optForView == 1) {
								int foundApp = 0;
								String searchID;
								System.out.print("Application ID: ");
								searchID = input.nextLine();
								for (int m = 0; m < application_list.size(); m++) {
									if ((application_list.get(m)).getApplicationID().equals(searchID)) {
										(application_list.get(m)).displayApplicationInfo();
										foundApp++;
									}
								}
								if (foundApp == 0) {
									System.out.println("No application is found");
								}

							} else if (optForView == 2) {
								int foundApp = 0;
								String icNo;
								System.out.print("Ic Number: ");
								icNo = input.nextLine();
								for (int m = 0; m < application_list.size(); m++) {
									if (((application_list.get(m)).getApplicant()).getApplicant_IcNo().equals(icNo)) {
										(application_list.get(m)).displayApplicationInfo();
										foundApp++;
									}
								}
								if (foundApp == 0) {
									System.out.println("No application is found");
								}

							} else if (optForView == 3) {
								System.out.println("Returning to the previous menu");
							} else {
								System.out.println("Invalid input...Please try again");
							}

						} while (optForView != 3);// do while for view applicant's applications
					} else if (option_Applicant == 3) {
						System.out.println("Back");
					} else {
						System.out.println("Invalid input...Please try again");
					}

				} while (option_Applicant != 3);// do while for applicant menu

			} else if (option_category == 2) {
				int select_s = -1;

				do {
					System.out.println("Please select a staff to proceed with the proceeding operations");
					for (int h = 0; h < Staff_list.size(); h++) {
						System.out.println((h + 1) + ") " + (Staff_list.get(h)).getStaff_name());
					}
					boolean level5 = true;
					while (level5) {
						// Exception handling 5
						try {
							System.out.print("\nStaff number: ");
							select_s = Integer.parseInt(input.nextLine());
							level5 = false;
 
						} catch (Exception e) {
							System.out.println("Your input is not an Integer.Please try again");
						}
					}

					if (select_s < 1 || select_s > (Staff_list.size())) {
						System.out.println("Invalid input... Please try again");
					}
				} while (select_s < 1 || select_s > (Staff_list.size()));

				System.out.println("\n\n");
				int optStaff = 0;
				do {
					boolean level6;// Exception handling 6
					displayStaffMenu();
					do {
						level6 = true;
						try {
							optStaff = Integer.parseInt(input.nextLine());
							level6 = false;
							if (optStaff != 1 && optStaff != 2 && optStaff != 3) {
								System.out.println("Invalid input... Please try again");
								System.out.print("\nYour operation: ");
							}
						} catch (Exception e) {
							System.out.println("Your input is not an Integer.Please try again");
							System.out.print("\nYour operation: ");
						}
					} while (level6 || (optStaff != 1 && optStaff != 2 && optStaff != 3));
					switch (optStaff) {
						case 1:
							int numPending;
							ArrayList<Integer> index = new ArrayList<Integer>();
							int numtemp = 0;
							String decision, optContinue = "";
							do {
								System.out.printf("%n%-5s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%n", "No", "App Type",
										"App ID", "App DateTime", "Name", "IC No", "Occupation", "reason ");
								numPending = 0;
								for (int k = 0; k < application_list.size(); k++) {
									if ((application_list.get(k)).getStatus() == 0) {
										numPending++;

										String application_type;
										if (application_list.get(k) instanceof Narrow_range) {
											application_type = "Cross-district";
										} else {
											application_type = "Wide_range";
										}
										System.out.printf("%n%-5d%-20s%-20s%-30s%-20s%-20s%-20s%-20s%n", numPending,
												application_type,
												(application_list.get(k)).getApplicationID(),
												(application_list.get(k)).getApplicationDateTime(),
												(application_list.get(k)).getApplicant().getApplicant_name(),
												(application_list.get(k)).getApplicant().getApplicant_IcNo(),
												(application_list.get(k)).getApplicant().getApplicant_job(),
												(application_list.get(k)).getreason());

										index.add(k);
									}
								}
								if (numPending == 0) {
									System.out.println("\nThere are no pending applications to be processed");

								} else {
									boolean level7;
									do {
										level7 = true;
										// Exception handling 7
										try {
											System.out.printf("\nEnter the No of the application to be processed: ");
											numtemp = Integer.parseInt(input.nextLine());
											level7 = false;
											if (numtemp < 1 || numtemp > numPending) {
												System.out.println(
														"The No of application is out of range....Please try again");
											}
										} catch (Exception e) {
											System.out.println("Your input is not an Integer.Please try again");
										}
									} while (numtemp < 1 || numtemp > numPending || level7);

									(application_list.get(index.get(numtemp - 1))).displayApplicationInfo();
									do {
										System.out.println("\nDo you want to approve or reject this application");
										System.out.println(
												"1) A for Approve\n2) R for Reject\nOr\n3) C for Cancel this operation");
										System.out.print("\nYour decision: ");
										decision = input.nextLine().toUpperCase();

										if (decision.equals("A")) {
											(application_list.get(index.get(numtemp - 1))).setStatus(1);
											(application_list.get(index.get(numtemp - 1)))
													.assignedToHandler(Staff_list.get(select_s - 1));
											Staff_list.get(select_s - 1)
													.addApplication(application_list.get(index.get(numtemp - 1)));
										} else if (decision.equals("R")) {
											(application_list.get(index.get(numtemp - 1))).setStatus(-1);
											(application_list.get(index.get(numtemp - 1)))
													.assignedToHandler(Staff_list.get(select_s - 1));
											Staff_list.get(select_s - 1)
													.addApplication(application_list.get(index.get(numtemp - 1)));

										} else if (decision.equals("C")) {
											System.out.println("Canceling this operation");
										} else {
											System.out.println("Invalid input...Please try again");
										}

									} while (!(decision.equals("A") || decision.equals("R") || decision.equals("C")));// do
																														// while
																														// for
																														// verifying
																														// decision
									System.out.println(
											"\nDo you still want to process another application\nPress Y if Yes\nPress N if No");
									do {
										System.out.print("\nYour choice: ");
										optContinue = input.nextLine().toUpperCase();
										if (!(optContinue.equals("Y") || optContinue.equals("N"))) {
											System.out.println("Invalid input...Please try again");
										}
									} while (!(optContinue.equals("Y") || optContinue.equals("N")));
									index.clear();
								}
							} while (!(optContinue.equals("N")) && numPending > 0);// do while for processing
																					// applications

							break;
						case 2:
							(Staff_list.get(select_s - 1)).displayApplicationList();
							System.out.println("\n\nPress Enter to continue...");
							System.in.read();
							input.nextLine();
							break;
						case 3:
							System.out.println("back");
							break;
						default:
							System.out.println("Invalid input...Please try again");
							break;
					}
				} while (optStaff != 3);
			} else if (option_category == 3) {
				System.out.println("Thank you :)");
			} else {
				System.out.println("Invalid input!!...Please try again");
			}

		} while (option_category != 3);// do while for user category

		input.close();

	}
}