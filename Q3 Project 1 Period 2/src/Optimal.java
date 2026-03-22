
public class Optimal {
	public void optimalPath(String[][] maze) {
		MazeSolver solver = new MazeSolver();
		solver.queueApproach(maze);
	}

}
