package apr26.adjacencymap;

import java.util.ArrayList;

public class DirectedGraph extends Graph {
	
	@Override
	public void addEdge(String v1name, String v2name, int weight) {
		if(vces.containsKey(v1name) && vces.containsKey(v2name)){
			vces.get(v1name).put(v2name, weight);
		}
	}
	
	@Override
	public void removeEdge(String v1name, String v2name) {
		if(vces.containsKey(v1name) && vces.containsKey(v2name)){
			vces.get(v1name).remove(v2name);
		}
	}
	
	@Override
	public int numEdges() {
		int count = 0;
		
		for(String vname: vces.keySet()){
			count += vces.get(vname).size();
		}
		
		return count;
	}
	
	@Override
	public void removeVertex(String vname) {
		ArrayList<String> nbrs = new ArrayList<>(vces.keySet());
		for (String nbr : nbrs) {
			vces.get(nbr).remove(vname);
		}

		vces.remove(vname);

	}
}
