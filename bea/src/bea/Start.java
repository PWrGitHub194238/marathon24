package bea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Start implements Runnable {

	private String file;
	
	public Start(String file) {
		this.file = file;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		try {
			String picture = in.readLine();
			
			ColorsExecutor c = new ColorsExecutor("/home/mth/Downloads/temp/colors.jpg");
			Map<Integer, Colors> map = c.getColors();
			
			for (Integer i : map.keySet()) {
				System.out.println(i+" :: "+map.get(i).name());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	} 	

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Program needs only one argument with path of input file");
			System.exit(1);
		}
		
		for (String s : args) {
			System.out.println(s);
		}
		
		new Thread(new Start(args[0])).start();
	}
}
