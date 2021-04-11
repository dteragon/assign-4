import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	LinkedList<CourseDBElement>[] hashTable;
	
	public CourseDBStructure(int size) {
		this("", size);
	}
	
	public CourseDBStructure(String test, int size) {
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
	}
	
	private CourseDBElement find(CourseDBElement element, int loc) {
		
		for (CourseDBElement next : hashTable[loc])
			if (next.compareTo(element) == 0)
				return next;
		return null;
	}
	
	public void add(CourseDBElement element) {
		
		int loc = element.hashCode() % hashTable.length;
		if (hashTable[loc] == null)
			hashTable[loc] = new LinkedList<>();
		
		if (find(element, loc) == null)
			hashTable[loc].add(element);
	}

	public CourseDBElement get(int crn) throws IOException {
		
		CourseDBElement compare = new CourseDBElement();
		compare.setCRN(crn);
		CourseDBElement locate = find(compare, compare.hashCode() % hashTable.length);
		
		if (locate == null)
			throw new IOException();
		return locate;
	}

	public int getTableSize() {
		return hashTable.length;
	}

}
