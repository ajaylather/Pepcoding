package apr29;

import java.util.HashSet;

import apr30.HashMap;

public class GrpahClient {

	static HashMap<String, HashMap<String, Integer>> graph;

	public static void main(String[] args) {
		// graph = new HashMap<>();
		//
		// graph.put("A", new HashMap<>());
		// graph.put("B", new HashMap<>());
		// graph.put("C", new HashMap<>());
		// graph.put("D", new HashMap<>());
		// graph.put("E", new HashMap<>());
		// graph.put("F", new HashMap<>());
		// graph.put("G", new HashMap<>());
		//
		// graph.get("A").put("B", 10);
		// graph.get("B").put("A", 10);
		//
		// graph.get("B").put("C", 10);
		// graph.get("C").put("B", 10);
		//
		// graph.get("C").put("D", 10);
		// graph.get("D").put("C", 10);
		//
		// graph.get("A").put("D", 40);
		// graph.get("D").put("A", 40);
		//
		// graph.get("D").put("E", 2);
		// graph.get("E").put("D", 2);
		//
		// graph.get("E").put("F", 3);
		// graph.get("F").put("E", 3);
		//
		// graph.get("E").put("G", 8);
		// graph.get("G").put("E", 8);
		//
		// graph.get("F").put("G", 3);
		// graph.get("G").put("F", 3);
		//
		// graph.get("C").put("F", 2);
		// graph.get("F").put("C", 2);
		//
		// hamiltonian("A", "A", "A", new HashSet<>());

		int[][] gmatrix = { { 0, 5, 0, 10 }, { 0, 0, 3, 0 }, 
				{ 0, 0, 0, 1 }, { 0, 0, 0, 0 } };

		floydwarshall(gmatrix);

	}

	// all pair shortest paths
	private static void floydwarshall(int[][] gmatrix) {
		Integer[][] fdp = new Integer[gmatrix.length][gmatrix.length];

		for (int i = 0; i < gmatrix.length; i++) {
			for (int j = 0; j < gmatrix.length; j++) {
				if (i == j) {
					fdp[i][j] = 0;
				} else if (gmatrix[i][j] != 0) {
					fdp[i][j] = gmatrix[i][j];
				} else {
					fdp[i][j] = null;
				}
			}
		}

		for (int i = 0; i < gmatrix.length; i++) {
			for (int s = 0; s < gmatrix.length; s++) {
				for (int d = 0; d < gmatrix.length; d++) {
					if (i == s || i == d) { // intermediate equal to source or dest
						continue;
					} else if (fdp[s][i] == null || fdp[i][d] == null) {
						// no path from source to inter or from inter to dest
						continue;
					} else {
						if (fdp[s][d] == null) { // no path yet exists for src to dest
							fdp[s][d] = fdp[s][i] + fdp[i][d];
						} else if (fdp[s][i] + fdp[i][d] < fdp[s][d]) { // real work
							fdp[s][d] = fdp[s][i] + fdp[i][d];
						}
					}
				}
			}
		}
		
		for(int i = 0; i < fdp.length; i++){
			for(int j = 0; j < fdp[i].length; j++){
				System.out.print(fdp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void hamiltonian(String src, String psf, String osrc, HashSet<String> visited) {
		visited.add(src);

		if (visited.size() == graph.size()) {
			System.out.print(psf + " is a hamiltonian path");
			if (graph.get(src).containsKey(osrc)) {
				System.out.print(" and a cycle as well");
			}
			System.out.println(".");
		} else {
			for (String nbr : graph.get(src).keyset()) {
				if (visited.contains(nbr) == false) {
					hamiltonian(nbr, psf + nbr, osrc, visited);
				}
			}
		}

		visited.remove(src);
	}

}
