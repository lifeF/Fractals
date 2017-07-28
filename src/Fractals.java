
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * UNIVERSITY OF PERADENIYA 
 * DEPARTMENT OF COMPUTER ENGINEERING
 * 
 * @author Kalana Dhananjaya
 * CO225: Software Construction 
 * Project 1: Fractals (Individual project)
 * 
 */
//------------------------------------------------------------------------------

public class Fractals extends JPanel{
    //Setup
    private int width;
    private int height;
    private double [] range;
    double [] imgRange;
    
//constructor
//******************************************************************************
    public Fractals(int width, int height) { 
	this.width  = width; 
	this.height = height; 
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.white);

    }

}// end class
