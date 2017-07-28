
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Math.abs;

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
public class Julia extends Fractals {
    // Setup julia set
    private double [] realRange;
    double [] C;
    private double [] imagRange;
    private int iterations;
    private int width;
    private int height;
    
//Constractor
//******************************************************************************    
    public Julia(int width, int height,double [] realRange, double [] imagRange,double [] C,int iterations){
        super(width, height);
        this.width  = width;
        this.height =height;
        this.realRange=realRange;
        this.imagRange=imagRange;
        this.iterations=iterations;
        this.C=C;
        
    }
//******************************************************************************

    
    @Override
    public void paintComponent(Graphics g) { 
        // call paintComponent from parent class 
	super.paintComponent(g);
        JuliaPatten(g ,iterations);
    }
    
//******************************************************************************

//Methods
//******************************************************************************    
    private  void JuliaPatten(Graphics g ,int itaration){
        
        BufferedImage img =new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        //File f =null;
        ComplexCanvas CC=new ComplexCanvas(width, height,realRange,imagRange);
        //Assign C value
         double realPart= C[0];
         double imgPart = C[1];
         
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                   
                double Zreal=CC.genarateRealPart(x);
                double Zimg=CC.genareteImgPart(y);

                int n=0;

                while(n<itaration){
                    double newimgPart  = (2*(Zreal*Zimg) + imgPart);
                    double newRealPart = ((Zreal*Zreal ) -(Zimg*Zimg) + realPart);
                    Zreal=(newRealPart);
                    Zimg=(newimgPart);
                    if(abs(Zreal*Zreal + Zimg*Zimg)>4){
                        break;
                    }
                    n++;
                }
                
                float Brightness = n <itaration  ? 1f : 0;
                float Hue = (n%256)/255.0f;
                Color c1 = Color.getHSBColor((float)Hue, 1, Brightness);
                img.setRGB(x,y,c1.getRGB());
                
               
            }
        }
        try{
            if(img != null){
                g.drawImage(img, 0, 0, this);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
//******************************************************************************
   
}// End class
