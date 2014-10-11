import java.awt.Point;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author tomasz
 *
 */
public class Main {

	static Scanner scanner;
	static BufferedOutputStream bos;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		scanner = new Scanner(System.in);
		bos = new BufferedOutputStream(System.out);
		int n = scanner.nextInt();
		
		int left_down = n-3;
		int x=0,y=0;
		int dx=0,dy=0;
		
		ArrayList<Point> coords = new ArrayList<Point>();
		coords.add(new Point(0,0));
		for ( int m = 1; m <= left_down; m++ ) {
			if ( m % 2 == 0 ) {
				dx += 2;
				x += dx;	
			} else {
				dy = dx + 1;
				y += dy;
			}
			coords.add(new Point(x,y));
//			System.out.println("Add point nr. " + m + " coord: ("+x+" : "+y+")");
		}

		dx += 2;
		x += dx;	
		
//		System.out.println("Last _: " + dx + " last |: " + dy );

		if ( y == dx ) {
			dx += 1;
			x += 1;
		}
		
		coords.add(new Point(x,y));
//		System.out.println("Add point coord: ("+x+" : "+y+")");
		
		coords.add(new Point(x,0));
//		System.out.println("Add point coord: ("+x+" : 0)");
		
		System.out.println((2*x+2*y));
		
		for ( Point p : coords ) {
			System.out.println(p.x + " " + p.y);
		}
	}
	
}
