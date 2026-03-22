
public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Running with " + args.length + " arguments");
		System.out.println("File: " + args[args.length-1]);
		String fileName = args[args.length-1];
		
		boolean useStack = false;
		boolean useQueue = false;
		boolean useOpt = false;
		boolean useTime = false;
		boolean useInCoordinate = false;
		boolean useOutCoordinate = false;
		
		for(String arg: args) {
			if(arg.equals("--Stack")) useStack = true;
			if(arg.equals("--Queue")) useQueue = true;
			if(arg.equals("--Opt")) useOpt = true;
			if(arg.equals("--Time")) useStack = true;
			if(arg.equals("--Incoordinate")) useStack = true;
			if(arg.equals("--Outcoordinate")) useStack = true;
			if(args.equals("--Help")) {
				System.out.println("This program fins a path through a maze.");
				System.out.println("Use stack");
				System.out.println("Use queue");
				System.out.println("Use Opt");
				System.out.println("Use Time");
				System.out.println("InCoordinate");
				System.out.println("OutCoordinate");
				System.exit(0);
				
				
			}
		}
		
		int count = 0;
		if(useStack) count++;
		if(useQueue) count++;
		if(useOpt) count++;
		if(count != 1) {
			System.out.println("Error: must specify Stack, Queue, or Opt");
			System.exit(-1);
		}
		
		FileReader fr = new FileReader();
		String[][] maze;
		if(useInCoordinate) {
			maze = fr.getCords(fileName);
		}
		else {
			maze = fr.getText(fileName);
		}
		MazeSolver solver = new MazeSolver();
		long startTime = System.currentTimeMillis();
		
		if(useStack) {
			solver.stackApproach(maze);
		}
		else if(useQueue) {
			solver.queueApproach(maze);
		}
		else if(useOpt) {
			solver.queueApproach(maze);
		}
		
		long endTime = System.currentTimeMillis();
		if(useTime) {
			System.out.println("Total Runtime: " + (endTime - startTime) / 1000.0 + " seconds");
		}
		
		for(int i =0; i<maze.length; i++) {
			for(int j =0; i<maze[0].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}

	}

}
