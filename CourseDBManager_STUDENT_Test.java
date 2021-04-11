import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204", 13921, 4, "HL312", "John Doe");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testShowAll() {
		
		dataMgr.add("MATH192", 31512, 3, "NL123", "June Person");
		dataMgr.add("MATH192", 90412, 3, "AJ851", "Bob Smith");
		dataMgr.add("MATH192", 54729, 3, "KA616", "Mitch Jones");
		
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:MATH192 CRN:90412 Credits:3 Instructor:Bob Smith Room:AJ851");
		assertEquals(list.get(1),"\nCourse:MATH192 CRN:54729 Credits:3 Instructor:Mitch Jones Room:KA616");
		assertEquals(list.get(2),"\nCourse:MATH192 CRN:31512 Credits:3 Instructor:June Person Room:NL123");
			}

	@Test
	public void testRead() {
		
		try {
			File inputFile = new File("student.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 12351 3 NA941 Josh Kingsman");
			inFile.print("CMSC214 51234 4 GQ833 Mario Mario");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
