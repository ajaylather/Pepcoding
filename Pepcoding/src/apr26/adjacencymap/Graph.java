package apr26.adjacencymap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {
	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removeVertex(String vname) {
		ArrayList<String> nbrs = new ArrayList<>(vces.get(vname).keySet());
		for (String nbr : nbrs) {
			vces.get(nbr).remove(vname);
		}

		vces.remove(vname);
	}

	public int numEdges() {
		int count = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			HashMap<String, Integer> nbrs = vces.get(vname);
			count += nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		} else {
			return false;
		}
	}

	public void addEdge(String v1name, String v2name, int weight) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).put(v2name, weight);
			vces.get(v2name).put(v1name, weight);
		} else {
			// don't do anything
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		} else {
			// don't do anything
		}
	}

	public void display() {
		System.out.println("-------------------------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			HashMap<String, Integer> nbrs = vces.get(vname);
			System.out.println(vname + " => " + nbrs);
		}
		System.out.println("-------------------------------------------");
	}

	public boolean hasPath(String sv, String dv) {
		return hasPathHelp(sv, dv, new HashSet<>());
	}

	private boolean hasPathHelp(String sv, String dv, HashSet<String> processed) {
		if (sv.equals(dv)) {
			return true;
		}

		processed.add(sv);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(sv).keySet());
		for (String nbr : nbrs) {
			if (processed.contains(nbr) == false) {
				boolean hasPathFromChild = hasPathHelp(nbr, dv, processed);
				if (hasPathFromChild == true) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String sv, String dv) {
		printAllPaths(sv, dv, new HashSet<>(), sv);
	}

	private void printAllPaths(String sv, String dv, HashSet<String> visited, String psf) {
		if (sv.equals(dv)) {
			System.out.println(psf);
			return;
		}

		// System.out.println("Reached " + sv + " via " + psf);
		visited.add(sv);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(sv).keySet());
		for (String nbr : nbrs) {
			if (visited.contains(nbr) == false) {
				// System.out.println("Going to " + nbr + " from " + sv);
				printAllPaths(nbr, dv, visited, psf + nbr);
				// System.out.println("Coming back from " + nbr + " to " + sv);
			}
		}
		visited.remove(sv);
		// System.out.println("Leaving " + sv + " via " + psf);
	}

	private class HeapMover {
		int minDist = Integer.MAX_VALUE;
		String minDistPath = "";
		int maxDist = Integer.MIN_VALUE;
		String maxDistPath = "";

		String justLargerPath = "";
		int justLargerDist = Integer.MAX_VALUE;
	}

	public void shortestAndLongestPaths(String sv, String dv) {
		HeapMover mover = new HeapMover();
		shortestAndLongestPaths(sv, dv, new HashSet<>(), sv, 0, mover);
		System.out.println("Shortest => " + mover.minDistPath + "@" + mover.minDist);
		System.out.println("Longest => " + mover.maxDistPath + "@" + mover.maxDist);
	}

	private void shortestAndLongestPaths(String sv, String dv, HashSet<String> visited, String psf, int dsf,
			HeapMover mover) {
		if (sv.equals(dv)) {
			if (dsf < mover.minDist) {
				mover.minDist = dsf;
				mover.minDistPath = psf;
			}

			if (dsf > mover.maxDist) {
				mover.maxDist = dsf;
				mover.maxDistPath = psf;
			}

			return;
		}

		visited.add(sv);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(sv).keySet());
		for (String nbr : nbrs) {
			if (visited.contains(nbr) == false) {
				shortestAndLongestPaths(nbr, dv, visited, psf + nbr, dsf + vces.get(sv).get(nbr), mover);
			}
		}
		visited.remove(sv);
	}

	public void justLargerPath(String sv, String dv, int minDist) {
		HeapMover mover = new HeapMover();
		justLargerPath(sv, dv, new HashSet<>(), sv, 0, mover, minDist);
		System.out.println(mover.justLargerPath + "@" + mover.justLargerDist);
	}

	private void justLargerPath(String sv, String dv, HashSet<String> visited, String psf, int dsf, HeapMover mover,
			int minDist) {
		if (sv.equals(dv)) {
			if (dsf > minDist) {
				if (dsf < mover.justLargerDist) {
					mover.justLargerDist = dsf;
					mover.justLargerPath = psf;
				}
			}

			return;
		}

		visited.add(sv);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(sv).keySet());
		for (String nbr : nbrs) {
			if (visited.contains(nbr) == false) {
				justLargerPath(nbr, dv, visited, psf + nbr, dsf + vces.get(sv).get(nbr), mover, minDist);
			}
		}
		visited.remove(sv);
	}

	private class kLargerPair implements Comparable<kLargerPair> {
		String psf;
		int dsf;

		public int compareTo(kLargerPair o) {
			return this.dsf - o.dsf;
		}
	}

	public void kthLargestPath(String sv, String dv, int k) {
		PriorityQueue<kLargerPair> pq = new PriorityQueue<>();
		kthLargestPath(sv, dv, new HashSet<>(), sv, 0, pq, k);

		kLargerPair pair = pq.peek();
		System.out.println(pair.psf + "@" + pair.dsf);
	}

	private void kthLargestPath(String sv, String dv, HashSet<String> visited, String psf, int dsf,
			PriorityQueue<kLargerPair> pq, int k) {
		if (sv.equals(dv)) {
			kLargerPair pair = new kLargerPair();
			pair.psf = psf;
			pair.dsf = dsf;

			if (pq.size() < k) {
				pq.add(pair);
			} else {
				if (dsf > pq.peek().dsf) {
					pq.remove();
					pq.add(pair);
				}
			}

			return;
		}

		visited.add(sv);
		ArrayList<String> nbrs = new ArrayList<>(vces.get(sv).keySet());
		for (String nbr : nbrs) {
			if (visited.contains(nbr) == false) {
				kthLargestPath(nbr, dv, visited, psf + nbr, dsf + vces.get(sv).get(nbr), pq, k);
			}
		}
		visited.remove(sv);
	}

	private class Pair {
		String vname;
		String psf;
		String color;
	}

	public boolean bfs(String sv, String dv) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> map = new HashMap<>();

		Pair rootpair = new Pair();
		rootpair.vname = sv;
		rootpair.psf = sv;
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			// 1. remove
			Pair rp = queue.removeFirst();

			// 1'. mark visited
			map.put(rp.vname, rp.psf);

			// 2. print
			System.out.println(rp.vname + " via " + rp.psf);
			if (rp.vname.equals(dv)) {
				return true;
			}

			// 3. enqueue the unvisited children
			ArrayList<String> nbrs = new ArrayList<>(vces.get(rp.vname).keySet());
			for (String nbr : nbrs) {
				if (map.containsKey(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + np.vname;
					queue.addLast(np);
				}
			}
		}

		return false;
	}

	public boolean dfs(String sv, String dv) {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, String> map = new HashMap<>();

		Pair rootpair = new Pair();
		rootpair.vname = sv;
		rootpair.psf = sv;
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			// 1. remove
			Pair rp = stack.removeFirst();

			// 1'. mark visited
			map.put(rp.vname, rp.psf);

			// 2. print
			System.out.println(rp.vname + " via " + rp.psf);
			if (rp.vname.equals(dv)) {
				return true;
			}

			// 3. enqueue the unvisited children
			ArrayList<String> nbrs = new ArrayList<>(vces.get(rp.vname).keySet());
			for (String nbr : nbrs) {
				if (map.containsKey(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + np.vname;
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void bft() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		for (String vname : vnames) {
			if (visited.contains(vname) == false) {
				bftComponent(vname, visited);
			}
		}
	}

	// returns false if there is a cycle in the component
	private boolean bftComponent(String sv, HashSet<String> visited) {
		LinkedList<Pair> queue = new LinkedList<>();

		Pair rootpair = new Pair();
		rootpair.vname = sv;
		rootpair.psf = sv;
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			Pair rp = queue.removeFirst();

			// not acyclic anymore
			if (visited.contains(rp.vname) == true) {
				return false;
			}
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}
		}

		return true;
	}

	public void dft() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		for (String vname : vnames) {
			if (visited.contains(vname) == false) {
				dftComponent(vname, visited);
			}
		}
	}

	private String dftComponent(String sv, HashSet<String> visited) {
		String comp = "";
		LinkedList<Pair> stack = new LinkedList<>();

		Pair rootpair = new Pair();
		rootpair.vname = sv;
		rootpair.psf = sv;
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			Pair rp = stack.removeFirst();

			if (visited.contains(rp.vname) == false) {
				comp += rp.vname;
			}
			visited.add(rp.vname);

			System.out.println(rp.vname + "@" + rp.psf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}

		return comp;
	}

	public boolean IsConnected() {
		HashSet<String> visited = new HashSet<>();
		String vname = vces.keySet().iterator().next();

		bftComponent(vname, visited);
		return visited.size() == vces.size();
	}

	public boolean IsACyclic() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		for (String vname : vnames) {
			if (visited.contains(vname) == false) {
				boolean isCAcyclic = bftComponent(vname, visited);
				if (isCAcyclic == false) {
					return isCAcyclic;
				}
			}
		}

		return true;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> gcc = new ArrayList<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		for (String vname : vnames) {
			if (visited.contains(vname) == false) {
				String comp = dftComponent(vname, visited);
				gcc.add(comp);
			}
		}

		return gcc;
	}

	public boolean IsBipartite() {
		HashMap<String, String> visited = new HashMap<>();
		for (String vname : vces.keySet()) {
			if (visited.containsKey(vname) == false) {
				boolean isBip = IsBiPartiteComp(vname, visited);
				if (isBip == false) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean IsBiPartiteComp(String sv, HashMap<String, String> visited) {
		LinkedList<Pair> queue = new LinkedList<>();
		
		Pair rootpair = new Pair();
		rootpair.vname = sv;
		rootpair.psf = sv;
		rootpair.color = "red";
		queue.addLast(rootpair);
		
		while(queue.size() > 0){
			Pair rp = queue.removeFirst();
			
			if(visited.containsKey(rp.vname)){
				// cyclic, hence visited again
				String oldcolor = visited.get(rp.vname);
				String newcolor = rp.color;
				
				if(!oldcolor.equals(newcolor)){
					return false;
				}
			}
			
			visited.put(rp.vname, rp.color);
			
			for(String nbr: vces.get(rp.vname).keySet()){
				if(visited.containsKey(nbr) == false){
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.color = rp.color.equals("red")? "green": "red";
					queue.addLast(np);
				}
			}
		}
		
		return true;
	}
	
}
