package edu.neu.csye6200.ca;

import java.awt.*;

/* This is a companion class to hexgame.java. It handles all of the mechanics related to hexagon grids. */

public class CACrytal
{
  

	//Constants
	public final static boolean orFLAT= true;
	public final static boolean orPOINT= false;
	public static boolean ORIENT= orFLAT;  //this is not used. We're never going to do pointy orientation

	public static boolean XYVertex=true;	//true: x,y are the co-ords of the first vertex.
	//false: x,y are the co-ords of the top left rect. co-ord.

	private static int BORDERS=10;	//default number of pixels for the border.

	private static double s=0;	// length of one side
	private static double t=0;	// short side of 30o triangle outside of each hex
	private static double r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
	private static double h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

	public static void setXYasVertex(boolean b) {
		XYVertex=b;
	}
	public static void setBorders(int b){
		BORDERS=b;
	}

	public static void setSide(int side) {
		s=side;
		t =   (s / 2);			//t = s sin(30) = (int) CalculateH(s);
		r =   (s * 0.8660254037844);	//r = s cos(30) = (int) CalculateR(s); 
		h=2*r;
	}
	public static void setHeight(int height) {
		h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
		r = h/2;			// r = radius of inscribed circle
		s =  (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
		t =  (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
	}


	public static Polygon hex (double x0, double y0) {

		double y = y0 + BORDERS;
		double x = x0 + BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
				      // NO! Done below in cx= section
		if (s == 0  || h == 0) {
			System.out.println("ERROR: size of hex has not been set");
			return new Polygon();
		}

		int[] cx;
		int[] cy;

//I think that this XYvertex stuff is taken care of in the int x line above. Why is it here twice?
		if (XYVertex) 
			cx = new int[] {(int) x,(int) (x+s),(int) (x+s+t),(int) (x+s),(int) x,(int) (x-t)};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
		else
			cx = new int[] {(int) (x+t),(int) (x+s+t),(int) (x+s+t+t),(int) (x+s+t),(int) (x+t),(int) x};	//this is for the whole hexagon to be below and to the right of this point

		cy = new int[] {(int) y,(int) y,(int) (y+r),(int) (y+r+r),(int) (y+r+r),(int) (y+r)};
		return new Polygon(cx,cy,6);
		//return new Polygon();

		/*
		   x=200;
		   poly = new Polygon();
		   poly.addPoint(x,y);
		   poly.addPoint(x+s,y);
		   poly.addPoint(x+s+t,y+r);
		   poly.addPoint(x+s,y+r+r);
		   poly.addPoint(x,y+r+r);
		   poly.addPoint(x-t,y+r);
		 */
	}


	public static void drawHex(int i, int j, Graphics2D g2) {
		double x = i * (s+t);
		double y = j * h + (i%2) * h/2;
		Polygon poly = hex(x,y);
		g2.setColor(CACrystalSet.COLOURCELL);
		//g2.fillPolygon(hexmech.hex(x,y));
		g2.fillPolygon(poly);
		g2.setColor(CACrystalSet.COLOURGRID);
		g2.drawPolygon(poly);
	}


	public static void fillHex(int i, int j, int n, Graphics2D g2) {
		char c='o';
		double x = i * (s+t);
		double y = j * h + (i%2) * h/2;
		if (n < 0) {
			g2.setColor(CACrystalSet.COLOURONE);
			g2.fillPolygon(hex(x,y));
			//g2.setColor(CACrystalSet.COLOURONETXT);
			c = (char)(-n);
			g2.drawString(""+c, (int)(x+r+BORDERS), (int)(y+r+BORDERS+4));//(""+c, x+r+BORDERS, y+r+BORDERS+4); //FIXME: handle XYVertex
			//g2.drawString(x+","+y, x+r+BORDERS, y+r+BORDERS+4);
		}
		if (n > 0) {
			g2.setColor(CACrystalSet.COLOURTWO);
			g2.fillPolygon(hex(x,y));
			//g2.setColor(CACrystalSet.COLOURTWOTXT);
			c = (char)n;
			g2.drawString(""+c,(int)(x+r+BORDERS), (int)(y+r+BORDERS+4)); //FIXME handle XYVertex
			//g2.drawString(i+","+j, x+r+BORDERS, y+r+BORDERS+4);
		}
	}
}

	