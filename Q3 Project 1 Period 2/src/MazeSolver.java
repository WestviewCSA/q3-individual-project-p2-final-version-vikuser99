import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MazeSolver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FileReader fr = new FileReader();
		    String[][] maze = fr.getCords("test1.txt");
		    
		    MazeSolver solver = new MazeSolver();
		    solver.stackApproach(maze);
		    
		    for(int i = 0; i < maze.length; i++) {
		        for(int j = 0; j < maze[0].length; j++) {
		            System.out.print(maze[i][j]);
		        }
		        System.out.println();
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
		            	if(!maze[current2[0]][current2[1]].equals("$")) {
		            		maze[current2[0]][current2[1]] = "+";	
		            	}
		                
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
		
		
		
	
	public void stackApproach(String [][] maze) {
		Stack<int[]> stack = new Stack<>();
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
		stack.push(new int[] {startRow, startCol}); // will this work?
		visited[startRow][startCol] = true;
		
		while(!stack.isEmpty()) {
			int [] current = stack.pop();
			int row = current[0];
			int col = current[1];
			
			if (maze[row][col].equals("$")) {
				  int[] current2 = {row, col};
		            while(!maze[current2[0]][current2[1]].equals("W")) {
		            	if(!maze[current2[0]][current2[1]].equals("$")) {
		            		maze[current2[0]][current2[1]] = "+";	
		            	}
		                
		                current2 = parent[current2[0]][current2[1]];
		            }
		            return;
		        }
		    
			int newRow = row - 1;
			int newCol = col;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    stack.push(new int[]{newRow, newCol});
			}
			newRow = row + 1;
			newCol = col;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    stack.push(new int[]{newRow, newCol});
			}
			newRow = row;
			newCol = col+1;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    stack.push(new int[]{newRow, newCol});
			}
			
			newRow = row;
			newCol = col-1;
			if(newRow >= 0 && newCol >= 0 && newRow < maze.length && newCol < maze[0].length && !visited[newRow][newCol] && !maze[newRow][newCol].equals("@")) {
				visited[newRow][newCol] = true;
				parent[newRow][newCol] = new int[]{row, col};
			    stack.push(new int[]{newRow, newCol});
			}

		}
		
		
	}
}
