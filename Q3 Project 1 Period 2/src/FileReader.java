import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Queue<String> getText(String passedFile) {
		Queue<String> val = new ArrayDeque<>();
		File file = new File(passedFile);
		
		String rows ="";
		String cols = "";
		 try {
			 Scanner scan= new Scanner(file);
			 scan = new Scanner(file);
			  rows= scan.next();
			  cols = scan.next();
			  String levels = scan.next();
			 while(scan.hasNext()) {
				 String nextVal = scan.next();
				 val.add(nextVal);
			 }
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();  
		 }
		 return val;
		
	}
	
	public String[][] getCords (String passedFile) {
		
		String rows = "";		
		String columns = "";
		String maps = "";
		

		
		File fileObj = new File(passedFile);
		try {
			
			
			Scanner scan = new Scanner(fileObj);
			rows = scan.next();
			columns = scan.next();
			maps = scan.next();
			
			String[][] cordBased = new String[Integer.parseInt(rows)][Integer.parseInt(columns)];
			
			while(scan.hasNext()) {
				
				String character = scan.next();
				int rowL = Integer.parseInt(scan.next());
				int colL = Integer.parseInt(scan.next());
				if(rowL <= Integer.parseInt(rows) || colL <= Integer.parseInt(columns)) {
					System.out.println("Coords don't match");
					String[][]empty =new String[0][0];
					return empty;
				}
				cordBased[rowL][colL] = character;
				scan.next();
			}
			
			for(int i = 0; i < cordBased.length; i++) {
				for(int j = 0; j < cordBased[0].length; j++) {
					if(cordBased[i][j] == null) {
						cordBased[i][j] = ".";
					}
				}

			}
			
			return cordBased;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}

	
	public void queueApproach(String [][] maze) {
		Queue<int[]> queue1 = new ArrayDeque<>();
		boolean [][] visited = new boolean[maze.length][maze[0].length];
		int[][][] parent = new int[maze.length][maze[0].length][2];
		int startRow =0;
		int startCol =0;
		for(int i =0; i< maze.length; i++) {
			for(int j =0; j<maze[0].length; j++) {
				if(maze[i][j].equals("W")) {
					startRow = i;
					startCol = j; // setting coords for the starting position
				}
			}
		
			
		}
		queue1.add(new int[] {startRow, startCol}); // will this work?
		visited[startRow][startCol] = true;
		
		while(!queue1.isEmpty()) {
			int [] current = queue1.remove();
			int row = current[0];
			int col = current[1];
			
			if (maze[row][col].equals("$")) {
				  int[] current2 = {row, col};
		            while(!maze[current2[0]][current2[1]].equals("W")) {
		                maze[current2[0]][current2[1]] = "+";
		                current2 = parent[current2[0]][current2[1]];
		            }
		            return;
		        }
		    
			int newRow = row - 1;
			int newCol = col;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    queue1.add(new int[]{newRow, newCol});
			}
			newRow = row + 1;
			newCol = col;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    queue1.add(new int[]{newRow, newCol});
			}
			newRow = row;
			newCol = col+1;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    queue1.add(new int[]{newRow, newCol});
			}
			
			newRow = row;
			newCol = col-1;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    queue1.add(new int[]{newRow, newCol});
			}

		}
	}
		
		
		
	
	public void stackAppoach(String [][ maze]) {
		Stack<int[]> stack = new Stack<>();
		boolean [][] visited = new boolean[maze.length][maze[0].length];
		int startRow =0;
		int startCol =0;
		for(int i =0; i< maze.length; i++) {
			for(int j =0; j<maze[0].length; j++) {
				if(maze[i][j].equals("W")) {
					startRow = i;
					startCol = j; // setting coords for the starting position
				}
			}
		
			
		}
		
	}
	

