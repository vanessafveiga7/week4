package week4;

import acm.program.*;
import java.util.*;
public class NameCounts extends ConsoleProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		HashMap<String,Integer> nameMap = new HashMap<String,Integer>();
		readNames(nameMap);
		printMap(nameMap);
	}

	private void readNames(Map<String,Integer> map) {
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;

			Integer count = map.get(name);
			if (count == null) {
				count = new Integer(1);
			} else {
				count = new Integer(count + 1);
			}
			map.put(name, count);
		}
	}

	private void printMap(Map<String,Integer> map) {
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			int count = map.get(key);
			println("Entry [" + key + "] has count " + count);
		}
	}
} 
