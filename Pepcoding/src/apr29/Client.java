package apr29;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
		// String[] strs = {"hi", "bye", "hello", "world", "abc", "kdjf",
		// "skadlj"};
		// GenericHeap<String> pq = new GenericHeap<>(strs, true);
		//
		// pq.display();
		// pq.erase("kdjf");
		// pq.display();
		//
		// while(pq.size() > 0){
		// System.out.println(pq.remove());
		// }

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

		graph.put("A", new HashMap<>());
		graph.put("B", new HashMap<>());
		graph.put("C", new HashMap<>());
		graph.put("D", new HashMap<>());
		graph.put("E", new HashMap<>());
		graph.put("F", new HashMap<>());
		graph.put("G", new HashMap<>());

		graph.get("A").put("B", 10);
		graph.get("B").put("A", 10);

		graph.get("A").put("D", 40);
		graph.get("D").put("A", 40);

		graph.get("B").put("C", 10);
		graph.get("C").put("B", 10);

		graph.get("C").put("D", 10);
		graph.get("D").put("C", 10);

		graph.get("D").put("E", 2);
		graph.get("E").put("D", 2);

		graph.get("E").put("F", 3);
		graph.get("F").put("E", 3);

		graph.get("E").put("G", 8);
		graph.get("G").put("E", 8);

		graph.get("F").put("G", 3);
		graph.get("G").put("F", 3);

//		djikstra(graph, "A");

		HashMap<String, HashMap<String, Integer>> mst = prims(graph);
		System.out.println(mst);
	}

	private static class dpair implements Comparable<dpair> {
		String vname;
		String psf;
		int csf;

		@Override
		public int compareTo(dpair o) {
			return this.csf - o.csf;
		}

		public String toString() {
			return this.psf + "@" + this.csf;
		}
	}

	private static void djikstra(HashMap<String, HashMap<String, Integer>> graph, String src) {
		HashMap<String, dpair> map = new HashMap<>();
		GenericHeap<dpair> heap = new GenericHeap<>();

		for (String vname : graph.keySet()) {
			dpair pair = new dpair();

			pair.vname = vname;
			pair.psf = "";
			pair.csf = Integer.MAX_VALUE;

			if (src.equals(vname)) {
				pair.psf = src;
				pair.csf = 0;
			}

			map.put(vname, pair);
			heap.add(pair);
		}

		while (heap.size() > 0) {
			dpair rp = heap.remove();

			for (String nbr : graph.get(rp.vname).keySet()) {
				dpair np = map.get(nbr);

				String npsf = rp.psf + nbr;
				int ncsf = rp.csf + graph.get(rp.vname).get(nbr);

				if (ncsf < np.csf) {
					np.csf = ncsf;
					np.psf = npsf;

					heap.erase(np);
					heap.add(np);
				}
			}
		}

		System.out.println(map);
	}

	private static class ppair implements Comparable<ppair> {
		String vname;
		String pvname;
		int csf;

		@Override
		public int compareTo(ppair o) {
			return this.csf - o.csf;
		}

	}

	public static HashMap<String, HashMap<String, Integer>> prims(HashMap<String, HashMap<String, Integer>> graph) {
		HashMap<String, HashMap<String, Integer>> mst = new HashMap<>();
		GenericHeap<ppair> pq = new GenericHeap<>();
		HashMap<String, ppair> map = new HashMap<>();

		for (String vname : graph.keySet()) {
			ppair pair = new ppair();
			pair.vname = vname;
			pair.pvname = "";
			pair.csf = Integer.MAX_VALUE;
			pq.add(pair);
			map.put(vname, pair);
		}

		while (pq.size() > 0) {
			// 1. remove
			ppair rp = pq.remove();

			// 2. acquire
			mst.put(rp.vname, new HashMap<>()); // add vertex
			if (rp.pvname.length() != 0) { // adding an edge
				mst.get(rp.vname).put(rp.pvname, rp.csf);
				mst.get(rp.pvname).put(rp.vname, rp.csf);
			}

			// 3. neighbours
			for (String nbr : graph.get(rp.vname).keySet()) {
				if(mst.containsKey(nbr)){
					continue;
				}
				
				int newcost = graph.get(rp.vname).get(nbr);
				ppair np = map.get(nbr);

				if (newcost < np.csf) {
					np.csf = newcost;
					np.pvname = rp.vname;

					pq.erase(np);
					pq.add(np);
				}
			}
		}

		return mst;
	}

}
