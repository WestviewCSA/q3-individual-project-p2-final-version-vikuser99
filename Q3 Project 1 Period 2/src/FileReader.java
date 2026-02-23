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
	
	public static String[][] getCords (String passedFile) {
		
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
				cordBased[Integer.parseInt(scan.next())][Integer.parseInt(scan.next())] = character;
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

