
import java.awt.Color;
import java.awt.Dimension;
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

public class FractralFrame extends JPanel{
    //Setup
    private final int width;
    private final int height;
    private double [] range;
    double [] imgRange;
    
//constructor
//******************************************************************************
    public FractralFrame(int width, int height) { 
	this.width  = width; 
	this.height = height; 
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.white);

    }

}// end class
