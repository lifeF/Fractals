
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
public class Julia extends FractralFrame {
    
    // Setup julia set Panel
    private final double [] realRange;
    private final double [] C;
    private final double [] imagRange;
    private final int iterations;
    private final int width; // panel Width
    private final int height;// panel Height
    
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
        
        //Define Points (Break the area os Panel)
        int [] p1 = {0,0};
        int [] p2 = {400,0};
        int [] p3 = {0,400};
        int [] p4 = {400,400};
        int [] p5 = {800,400};
        int [] p6 = {400,800};
        int [] p7 = {800,800};
        
        /*
        *   Threads LayerOut
        
            P1 ---- P2 ---- _
            |   T1  |   T4  |
            P3 ---- P4 ---- P5
            |   T2  |   T3  |
            _  ---- P6 ---- P7
        
          P - Point 
          T - Thread 
        */
       
        //Create Complex Canvas
        ComplexCanvas CC=new ComplexCanvas(800, 800,realRange,imagRange); 
        
        // Create Julia Threads for each Region 
         JuliaThread t1=new JuliaThread(p1,p4,CC,this.C,itaration);
         JuliaThread t2=new JuliaThread(p2,p5,CC,this.C,itaration);
         JuliaThread t3=new JuliaThread(p3,p6,CC,this.C,itaration);
         JuliaThread t4=new JuliaThread(p4,p7,CC,this.C,itaration);
      
         // Run four threads 
         t1.start();
         t2.start();
         t3.start();
         t4.start();
         
         try{
            // join Threads 
            t1.join();
            t2.join();
            t3.join();
            t4.join();
         }
         
         catch(InterruptedException e){
             // if need Error msg for Exception Setup it ( Kalana )
         }
         finally{
             // get Genarated image from JuliaThread Class
             BufferedImage image=JuliaThread.getValue();
             
             // Set Genarated Image to Panel face 
             g.drawImage(image, 0, 0, this);
         }
    }
//******************************************************************************
   
}// End class
