import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;

//------------------------------------------------------------------------------
/*
 * UNIVERSITY OF PERADENIYA 
 * DEPARTMENT OF COMPUTER ENGINEERING
 * 
 * @author Kalana Dhananjaya
 * CO225: Software Construction 
 * Project 1: Fractals (Individual project)
 * 
 */
//------------------------------------------------------------------------------

public class JuliaThread extends Thread{
    
     
    public static BufferedImage image = new BufferedImage(800,800,BufferedImage.TYPE_INT_ARGB);
    private final int [] point1;
    private final int [] point2;
    private final ComplexCanvas CC;
    private final double [] C;
    private final int iteration;
    private int[] colormap;
    
    
    public JuliaThread(int [] p1, int [] p2,ComplexCanvas cc, double [] C,int iteration){
        this.point1=p1;
        this.point2=p2;
        this.CC=cc;
        this.C=C;
        this.iteration=iteration;
        colormap=ColorMap.initColorMap(iteration+1,Color.WHITE ,Color.PINK,Color.ORANGE,Color.RED,Color.RED,Color.black,Color.black,Color.black,Color.black,Color.black,Color.black);
        
    }
    
    @Override
    public void run(){
        double realPart= C[0];
        double imgPart = C[1];
        
        for (int x = point1[0]; x < point2[0]; x++) {
            
           for (int y = point1[1]; y< point2[1]; y++) {
               
                   
                double Zreal=CC.genarateRealPart(x);
                double Zimg=CC.genareteImgPart(y);

                int n=0;

                while(n<iteration){
                    n++;
                    double newimgPart  = (2*(Zreal*Zimg) + imgPart);
                    double newRealPart = ((Zreal*Zreal ) -(Zimg*Zimg) + realPart);
                    Zreal=(newRealPart);
                    Zimg=(newimgPart);
                    if(abs(Zreal*Zreal + Zimg*Zimg)>4){
                        break;
                    }
                    
                }
                image.setRGB(x,y,colormap[n]);
            }
        }
               //============================================================
        try{
            Thread.sleep(1);
        }
        catch(InterruptedException e){
             System.out.println(e);
        }
    }
   
    public static BufferedImage getValue(){
        return image;
    }   
}
