
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;

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

public class Mandelbrot extends Fractals {
    //Setup Mandelbrot set
    private double [] realRange;
    private double [] imagRange;
    private int iterations;
    private int width;
    private int height;
    
//Constructor 
//******************************************************************************
    public Mandelbrot(int width, int height,double [] realRange, double [] imagRange,int iterations){
        super(width, height);
        this.width  = width;
        this.height =height;
        this.realRange=realRange;
        this.imagRange=imagRange;
        this.iterations=iterations;
        
    }
//******************************************************************************
    
   
    
    @Override
    public void paintComponent(Graphics g) { 
        
        // call paintComponent from parent class 
	super.paintComponent(g);
        MandelbroPatten(g,1000);
        
        

    }
    
//Methods
//******************************************************************************
    public void MandelbroPatten(Graphics g , int itaration){
        int width1 =width;
        int height1 =height;
        BufferedImage img =new BufferedImage(width1,height1,BufferedImage.TYPE_INT_ARGB);
        File f =null;
        
        ComplexCanvas CC=new ComplexCanvas(width, height,realRange,imagRange);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                double realPart=CC.genarateRealPart(x);
                double imgPart=CC.genareteImgPart(y);
                
                double Zreal=realPart;
                double Zimg=imgPart;
               
                int n=0;
                double newimgPart;
                double newRealPart;
                while(n<itaration){
                    
                    newimgPart  = (2*(Zreal*Zimg) + imgPart);//new Imaginary Part
                    newRealPart = ((Zreal*Zreal ) -(Zimg*Zimg) + realPart); // new real part
                    
                    Zreal=(newRealPart);
                    Zimg=(newimgPart);
                    
                    if((Zreal*Zreal + Zimg*Zimg)>4){//Check Abs(Znew)>2
                        break;
                    }
                    n++;
                }

                    float Brightness = n <itaration  ? 1f : 0;
                    float Hue = (n%256)/255.0f;
                    Color color = Color.getHSBColor((float)Hue, 1, Brightness);

                    img.setRGB(x,y,color.getRGB());

                    }
            }
            try{
                if(img != null){
                    g.drawImage(img, 0, 0, this);
                }
                //ImageIO.write(img,"gif",f);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
//******************************************************************************
        
}// Class End
    
    

    
