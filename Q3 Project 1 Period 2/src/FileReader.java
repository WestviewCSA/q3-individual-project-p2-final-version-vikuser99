import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FileReader {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[][][] getText(String passedFile) {
		File file = new File(passedFile);
		
		 try {
			 Scanner scan= new Scanner(file);
			 
			  int rows= Integer.parseInt(scan.next());
			  int cols = Integer.parseInt(scan.next());
			  int levels = Integer.parseInt(scan.next());
			  
			  String[][][] maze = new String[levels][rows][cols];
			  
			  for(int level =0; level < levels; level++) {
			  for(int i =0; i<rows; i++) {
				  String line = scan.next();
				  for(int j =0; j<cols; j++) {
					  maze[level][i][j] = "" + line.charAt(j);
				  }
			  }
			  }
			  return maze;
			 
			 
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();  
		 }
		 return null;
		
	}
	
	public String[][][] getCords (String passedFile) {
		
		int rows = 0;		
		int columns = 0;
		int levels = 0;
		
		File fileObj = new File(passedFile);
		try {
			Scanner scan = new Scanner(fileObj);
			rows = Integer.parseInt(scan.next());
			columns = Integer.parseInt(scan.next());
			levels = Integer.parseInt(scan.next());
			
			String[][][] maze = new String[levels][rows][columns];
			for(int l =0; l < levels; l++) {
			for(int i = 0; i < maze.length; i++) {
				for(int j = 0; j < maze[0].length; j++) {
					if(maze[i][j] == null) {
						maze[l][i][j] = ".";
					}
				}
			}

			}
			while(scan.hasNext()) {
				
				String character = scan.next();
				int rowL = Integer.parseInt(scan.next());
				int colL = Integer.parseInt(scan.next());
				int levelL = Integer.parseInt(scan.next());
				if(rowL >= rows || colL >= columns || levelL >= levels) {
					System.out.println("Coords don't match");
					return null;
				}
				maze[levelL][rowL][colL] = character;
				
			}
			
			
			
			return maze;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}

