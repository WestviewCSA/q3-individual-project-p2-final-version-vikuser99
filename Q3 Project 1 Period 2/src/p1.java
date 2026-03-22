
public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				///
			}
		}
		

	}

}
