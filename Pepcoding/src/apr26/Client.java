package apr26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Client {

	static HashMap<String, HashMap<String, Integer>> dag = new HashMap<>();

	public static void main(String[] args) {
		dag.put("A", new HashMap<>());
		dag.put("B", new HashMap<>());
		dag.put("C", new HashMap<>());
		dag.put("D", new HashMap<>());
		dag.put("E", new HashMap<>());
		dag.put("F", new HashMap<>());

		dag.get("A").put("C", 0);
		dag.get("A").put("F", 0);
		dag.get("B").put("E", 0);
		dag.get("B").put("F", 0);
		dag.get("C").put("D", 0);
		dag.get("D").put("E", 0);

		ArrayList<String> ts = new ArrayList<>();
		HashSet<String> visited = new HashSet<>();
		for (String vname : dag.keySet()) {
			if (visited.contains(vname) == false) {
				topologicalSort(vname, visited, ts);
			}
		}

		System.out.println(ts);
	}

	public static void topologicalSort(String src, 
									   HashSet<String> visited, 
									   ArrayList<String> psf) {
		if (visited.contains(src)) {
			return;
		}

		visited.add(src);
		for (String nbr : dag.get(src).keySet()) {
			topologicalSort(nbr, visited, psf);
		}
		psf.add(0, src);
	}

}
