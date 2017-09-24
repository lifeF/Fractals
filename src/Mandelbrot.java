
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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

public class Mandelbrot extends FractralFrame {
    //Setup Mandelbrot set
    private final double [] realRange;
    private final double [] imagRange;
    private final int iterations;
    private final int width;
    private final int height;
    
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
    public void MandelbroPatten(Graphics g , int itaration) {

        int [] p1 = {0,0};
        int [] p2 = {400,0};
        int [] p3 = {0,400};
        int [] p4 = {400,400};
        int [] p5 = {800,400};
        int [] p6 = {400,800};
        int [] p7 = {800,800};
        
        /*
        *   Threads layerout
        
            P1 ---- P2 ---- _
            |   T1  |   T4  |
            P3 ---- P4 ---- P5
            |   T2  |   T3  |
            _  ---- P6 ---- P7
        
          P - Point 
          T - Thread 
        */
                   
        //double [] realRangeIN =this; // Range for Real
        //double [] imagRangeIN ={0,1}; // Range for Imaginary
                
        ComplexCanvas CC=new ComplexCanvas(800, 800,realRange,imagRange);
        
         MandThread t1=new MandThread(p1,p4,CC,itaration);
         MandThread t2=new MandThread(p2,p5,CC,itaration);
         MandThread t3=new MandThread(p3,p6,CC,itaration);
         MandThread t4=new MandThread(p4,p7,CC,itaration);
      
         // Run 4 threads togather
         t1.start();
         t2.start();
         t3.start();
         t4.start();
         
         try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
         }
         
         catch(InterruptedException e){
         
         }
         finally{
             BufferedImage image=MandThread.getValue();
             g.drawImage(image, 0, 0, this);
         }
         
      
    }
//******************************************************************************
        
}// Class End
    
    

    
