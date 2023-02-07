package sab;

public class CourseCertification {

	interface Certification {
		  double REGULAR_COURSE_FEE = 2000;
		  double CRASH_COURSE_FEE = 5000;

		  double calculateFee();
		}

		class RRTechnicalCertification implements Certification {
		  String studentName;
		  String courseName;
		  int registrationId;
		  int admissionTestMarks;
		  int counter;

		  RRTechnicalCertification(String studentName, String courseName, int admissionTestMarks) {
		    this.studentName = studentName;
		    this.courseName = courseName;
		    this.admissionTestMarks = admissionTestMarks;
		    this.counter = 1001;
		    generateRegistrationId();
		  }

		  void generateRegistrationId() {
		    registrationId = counter;
		    counter += 2;
		  }

		  public double calculateFee() {
		    return 0;
		  }
		}

		class RegularCourseCertification extends RRTechnicalCertification {
		  int courseDuration;

		  RegularCourseCertification(String studentName, String courseName, int admissionTestMarks, int courseDuration) {
		    super(studentName, courseName, admissionTestMarks);
		    this.courseDuration = courseDuration;
		  }

		public  double calculateFee() {
		    double fee = courseDuration * REGULAR_COURSE_FEE;
		    if (admissionTestMarks >= 90) {
		      fee = (int) (fee * 0.9);
		    } else if (admissionTestMarks >= 75) {
		      fee = (int) (fee * 0.95);
		    }
		    return fee;
		  }
		}

		class CrashCourseCertification extends RRTechnicalCertification {
		  CrashCourseCertification(String studentName, String courseName, int admissionTestMarks) {
		    super(studentName, courseName, admissionTestMarks);
		  }

		  void generateRegistrationId() {
		    registrationId = counter + 1;
		    counter += 2;
		  }

		 public double calculateFee() {
			  double serviceTax = 12.36;

		    double fee = CRASH_COURSE_FEE;
		    if (admissionTestMarks >= 90) {
		      fee = (int) (fee * 0.9);
		    } else if (admissionTestMarks >= 75) {
		      fee = (int) (fee * 0.95);
		    }
		    fee = (int) (fee * (1 + serviceTax / 100));
		    return fee;
		  }
		}

		class CompletionProb {
		  public static void main(String[] args) {
		    RegularCourseCertification regularCourse = new RegularCourseCertification("Rakesh", "J2EE", 85, 5);
		    System.out.println("Student Name: " + regularCourse.studentName);
		    System.out.println("Course Name: " + regularCourse.courseName);
		    System.out.println("Registration Id: " + regularCourse.registrationId);
		    System.out.println("Admission Test Marks: " + regularCourse.admissionTestMarks);
		    System.out.println("Course Duration: " + regularCourse.courseDuration + " months");
		    System.out.println("Total Fee: " + regularCourse.calculateFee());
		  }
		}
}

		



