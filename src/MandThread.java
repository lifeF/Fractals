


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalana
 */



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

public class MandThread extends Thread{
  public static int value=0; 
    public static BufferedImage image = new BufferedImage(800,800,BufferedImage.TYPE_INT_ARGB);
    
    private int [] point1;
    private int [] point2;
    private ComplexCanvas CC;
    private int iteration;
    private int [] colormap;
    
    public MandThread(int [] p1, int [] p2,ComplexCanvas cc,int iteration){
        this.point1=p1;
        this.point2=p2;
        this.CC=cc;
        this.iteration=iteration;
        colormap=ColorMap.initColorMap(iteration, Color.white,Color.BLUE, Color.DARK_GRAY);
    }
    
    @Override
    public void run(){
        for (int x = point1[0]; x < point2[0]; x++) {
            
           for (int y = point1[1]; y< point2[1]; y++) {
               //============================================================
                double realPart=CC.genarateRealPart(x);
                double imgPart= CC.genareteImgPart(y);
                   
                double Zreal=0;
                double Zimg=0;

                int n=0;

                while(n<iteration){
                    double newimgPart  = (2*(Zreal*Zimg) + imgPart);
                    double newRealPart = ((Zreal*Zreal ) -(Zimg*Zimg) + realPart);
                    Zreal=(newRealPart);
                    Zimg=(newimgPart);
                    if(abs(Zreal*Zreal + Zimg*Zimg)>4){
                        break;
                    }
                    n++;
                }
                
                
                image.setRGB(x,y,colormap[(n-1)]);
                
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
