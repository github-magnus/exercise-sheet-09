package de.unistuttgart.iste.sqa.pse.sheet09.presence.polymorphismCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * A class to test list implementations.
 */
public class ListTester {

	public static void main(String[] args) {
		// Implement exercise 2 (c) and (f) here.
		List<String> syncedList = Collections.synchronizedList(new ArrayList<>());
		List<String> syncedList2 = Collections.synchronizedList(new LinkedList<>());

		ListTester myTester = new ListTester();
		ListTester myTester2 = new ListTester();

		myTester.addElementsToList(syncedList, 1000);
		myTester2.addElementsToList(syncedList2, 1000);
	}
	public void addElementsToList(List<String> myList, int elementCount){
		Timer timer = new Timer();
		timer.start();
		for (int i = 0; i < elementCount; i++) {
			myList.add("a");
		}
		timer.stop();
		float time = timer.getResultInNanoseconds()/1000000f;
		System.out.println("Took " + time + " seconds.");
	}
	// Add operations for exercise 2 (b), (d) and (e) here.
}
