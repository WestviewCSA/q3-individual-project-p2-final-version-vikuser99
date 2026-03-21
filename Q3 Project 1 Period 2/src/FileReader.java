import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FileReader {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[][] getText(String passedFile) {
		File file = new File(passedFile);
		
		 try {
			 Scanner scan= new Scanner(file);
			 scan = new Scanner(file);
			  int rows= Integer.parseInt(scan.next());
			  int cols = Integer.parseInt(scan.next());
			  int levels = Integer.parseInt(scan.next());
			  
			  String[][] maze = new String[rows][cols];
			  for(int i =0; i<rows; i++) {
				  String line = scan.next();
				  for(int j =0; j<cols; j++) {
					  maze[i][j] = "" + line.charAt(j);
				  }
			  }
			  return maze;
			 
			 
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();  
		 }
		 return null;
		
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
				if(rowL >= Integer.parseInt(rows) || colL >= Integer.parseInt(columns)) {
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

