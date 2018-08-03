package apr26.adjacencymap;

public class Client {

	public static void main(String[] args) {

//		 Graph g = new Graph();
//		
//		 g.addVertex("A");
//		 g.addVertex("B");
//		 g.addVertex("C");
//		 g.addVertex("D");
//		 g.addVertex("E");
//		 g.addVertex("F");
//		 g.addVertex("G");
//		
//		 g.addEdge("A", "B", 10);
//		 g.addEdge("A", "D", 40);
//		 g.addEdge("B", "C", 10);
//		 g.addEdge("C", "D", 10);
//		 g.addEdge("D", "E", 2);
//		 g.addEdge("E", "F", 3);
//		 g.addEdge("F", "G", 3);
//		 g.addEdge("E", "G", 8);
//		
//		 g.display();
//		
//		System.out.println(g.hasPath("A", "G"));
//		g.removeEdge("D", "E");
//		System.out.println(g.hasPath("A", "G"));
//		 g.printAllPaths("A", "G");
//		 g.shortestAndLongestPaths("A", "G");
//		 g.justLargerPath("A", "G", 50);
//		 g.kthLargestPath("A", "G", 2);
//		 System.out.println(g.bfs("A", "G"));
		 
//		 g.removeEdge("D", "E");
//
//		 System.out.println(g.gcc());
//		 g.removeEdge("E", "G");
//		 System.out.println(g.IsBipartite());
		
		DirectedGraph dg = new DirectedGraph();
		dg.addVertex("A");
		dg.addVertex("B");
		dg.addVertex("C");
		dg.addVertex("D");
		dg.addVertex("E");
		dg.addVertex("F");
		dg.addVertex("G");
		
		dg.addEdge("A", "B", 10);
		dg.addEdge("A", "D", 40);
		dg.addEdge("B", "C", 10);
		dg.addEdge("C", "D", 10);
		dg.addEdge("D", "E", 2);
		dg.addEdge("E", "F", 3);
		dg.addEdge("E", "G", 8);
		dg.addEdge("F", "G", 3);
		
		dg.display();
//		System.out.println(dg.hasPath("A", "G"));
//		System.out.println(dg.dfs("A", "G"));
		
//		dg.dft();
//		dg.bft();
//		dg.printAllPaths("A", "G");
//		dg.kthLargestPath("A", "G", 2);
//		dg.shortestAndLongestPaths("A", "G");
		
		
		
	}

	public static boolean floodfill(int[][] maze, boolean[][] visited, int sr, int sc, String psf) {
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			return true;
		}

		if (IsThisAnInvalidSpot(maze, visited, sr, sc) == true) {
			return false;
		}

		visited[sr][sc] = true;
		boolean rres = floodfill(maze, visited, sr, sc + 1, psf + "R");
		boolean dres = floodfill(maze, visited, sr + 1, sc, psf + "D");
		boolean lres = floodfill(maze, visited, sr, sc - 1, psf + "L");
		boolean ures = floodfill(maze, visited, sr - 1, sc, psf + "U");
		visited[sr][sc] = false;
		
		return rres || dres || lres || ures;
	}

	private static boolean IsThisAnInvalidSpot(int[][] maze, boolean[][] visited, int sr, int sc) {
		if (sr >= maze.length) {
			return true;
		} else if (sc >= maze[0].length) {
			return true;
		} else if (sr < 0) {
			return true;
		} else if (sc < 0) {
			return true;
		} else if (maze[sr][sc] == 0) {
			return true;
		} else if (visited[sr][sc] == true) {
			return true;
		} else {
			return false;
		}

	}

}
