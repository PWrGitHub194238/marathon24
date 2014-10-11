package fall;

import java.util.Arrays;

public class Part {
	
	private Part prev;
	private Part next;
	private double cub;
	private int[] xPoints = new int[0];
	private int[] yPoints = new int[0];
	private int lBorder;
	private int rBorder;
	private double fill;

	public Part() {
	}

	public Part getPrev() {
		return prev;
	}

	public void setPrev(Part prev) {
		this.prev = prev;
	}

	public Part getNext() {
		return next;
	}

	public void setNext(Part next) {
		this.next = next;
	}

	public double getCub() {
		return cub;
	}

	public void setCub(double cub) {
		this.cub = cub;
	}
	
	public void calcCub() {
		
		int idxMin = -1;
		int valMin = Integer.MAX_VALUE;
		for (int i=0 ; i<xPoints.length; i++) {
				if (yPoints[i] < valMin) {
					valMin = yPoints[i];
					idxMin = i;
				}
		}
		
		int lY = yPoints[idxMin-1];
		int rY = yPoints[idxMin+1];
		
		if (lY < rY) {
			double b = (yPoints[idxMin-1]*xPoints[idxMin]- yPoints[idxMin]*xPoints[idxMin-1])/(xPoints[idxMin]-xPoints[idxMin-1]);
			double a = (yPoints[idxMin]-b)/xPoints[idxMin];
			double xp = (yPoints[idxMin-1]-b)/a;
			cub = (yPoints[idxMin-1]-yPoints[idxMin])*xp/2;
			
		} else {
			double b = (yPoints[idxMin+1]*xPoints[idxMin]- yPoints[idxMin]*xPoints[idxMin+1])/(xPoints[idxMin]-xPoints[idxMin+1]);
			double a = (yPoints[idxMin]-b)/xPoints[idxMin];
			double xp = (yPoints[idxMin+1]-b)/a;
			cub = (yPoints[idxMin+1]-yPoints[idxMin])*xp/2;
		}
		
	}
	
	public void calcBorders() {
		lBorder = Integer.MAX_VALUE;
		rBorder = Integer.MIN_VALUE;
		for (int f : xPoints) {
			if (lBorder > f) {
				lBorder = f;
			}
			
			if (rBorder < f) 
				rBorder = f;
		}
	}

	public int getlBorder() {
		return lBorder;
	}

	public void setlBorder(int lBorder) {
		this.lBorder = lBorder;
	}

	public int getrBorder() {
		return rBorder;
	}

	public void setrBorder(int rBorder) {
		this.rBorder = rBorder;
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

	public double getFill() {
		return fill;
	}

	public void setFill(double fill) {
		this.fill = fill;
	}
	
	public void addFill(double ff) {
		fill += ff;
	}
	
	public void addPoints(int x, int y) {
		xPoints = Arrays.copyOf(xPoints, xPoints.length+1);
		xPoints[xPoints.length-1] = x;
		
		yPoints = Arrays.copyOf(yPoints, yPoints.length+1);
		yPoints[yPoints.length-1] = y;
	}

}
