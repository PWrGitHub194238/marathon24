package fall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Stanr extends Thread {

	private String file;
	
	public Stanr(String file) {
		this.file = file;
		this.req = new LinkedList<>();
		this.quer = new LinkedList<>();
	}
	
	private Part parts;
	private List<int[]> req;
	private List<Integer> quer;
	
	public void run() {
		try {
			BufferedReader in  = new BufferedReader(new FileReader(new File(file)));
			
			String line;
			
			int state = 0;
			int Numparts = 0;
			int numQuer;
			List<int[]> list = new LinkedList<>();
			String[] s;
			Part curr;
			
			while ((line = in.readLine()) != null) {
				switch (state) {
				case 0:
					s = line.split(" ");
					Numparts = Integer.parseInt(s[0]);
					numQuer = Integer.parseInt(s[1]);
					state = 1;
					break;
				case 1:
					s = line.split(" ");
					list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1]) });
					Numparts--;
					if (Numparts == 0) 
						state = 2;
					break;
				case 2:
					for (int i=0; i<list.size(); i++) {
						if (i== 0) {
							curr = new Part();
						}
					}
				case 3:
					s = line.split(" ");
					if (s[0].endsWith("Q"))
						quer.add(Integer.parseInt(s[1]));
					else if (s[0].endsWith("R")) {
						req.
					}
				} 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main (String[] args) {
		Stanr ff = new Stanr(args[0]);
		ff.start();
	}

}
