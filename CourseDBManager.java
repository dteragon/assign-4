import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure hash;
	
	public CourseDBManager() {
		hash = new CourseDBStructure(20);
	}
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		hash.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	public CourseDBElement get(int crn) {
		try {
			return hash.get(crn);
		} catch (IOException e) {
			return null;
		}
	}

	public void readFile(File input) throws FileNotFoundException {
		
		Scanner in = new Scanner(input);
		while(in.hasNextLine()) {
			
			String next = in.nextLine();
			
			String id = next.substring(0, next.indexOf(" "));
			next = next.substring(id.length() + 1);
			
			int crn = Integer.parseInt(next.substring(0, next.indexOf(" ")));
			next = next.substring(next.indexOf(" ") + 1);
			
			int credits = Integer.parseInt(next.substring(0, next.indexOf(" ")));
			next = next.substring(next.indexOf(" ") + 1);
			
			String roomNum = next.substring(0, next.indexOf(" "));
			next = next.substring(id.length() + 1);
			
			add(id, crn, credits, roomNum, next);
		}
		
	}

	public ArrayList<String> showAll() {
		
		ArrayList<String> all = new ArrayList<>();
		for (LinkedList<CourseDBElement> nextList : hash.hashTable) {
			
			if (nextList != null) {
				for (CourseDBElement next : nextList)
					all.add(next.toString());
			}
		}
		return all;
	}

}
