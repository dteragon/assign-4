
public class CourseDBElement implements Comparable {

	private String courseID;
	private int crn;
	private int credits;
	private String room;
	private String instructor;
	
	public CourseDBElement(String id, int c, int cre, String r, String i) {
		courseID = id;
		crn = c;
		credits = cre;
		room = r;
		instructor = i;
	}
	
	public CourseDBElement() {
		this("", 0, 0, "", "");
	}
	
	public int getCRN() {
		return crn;
	}
	
	public void setCRN(int num) {
		crn = num;
	}
	
	public int hashCode() {
		return (crn + "").hashCode();
	}
	
	public String toString() {
		return "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + credits 
				+ " Instructor:" + instructor + " Room:" + room;
	}
	
	public int compareTo(Object o) {
		CourseDBElement other = (CourseDBElement)o;
		return this.crn - other.crn;
	}

}
