import java.awt.Component;
import javax.swing.JFrame;

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

public class Main {//Main Methods

    public static void main(String [] args) {
        
        //Default values
        //**********************************************************************
        double [] realRange ={-1,1}; // Range for Real
        double [] imagRange ={-1,1}; // Range for Imaginary
        int iteration =1000;
        double [] DefC ={-0.4, 0.6};// C Value
        //**********************************************************************
        
        
            JFrame Frame =new JFrame();//new frame create
            Frame.setResizable(false);
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //Add JPanel to JFrame
            //******************************************************************
            if(args[0].equals("Mandelbrot")){
                if(args.length>2 && args.length<6 ){
                    realRange[0]=Double.parseDouble(args[1]);
                    realRange[1]=Double.parseDouble(args[2]);
                    
                    imagRange[0]=Double.parseDouble(args[3]);
                    imagRange[1]=Double.parseDouble(args[4]);
                       
                }
                else if(args.length>5 ){
                    
                    realRange[0]=Double.parseDouble(args[1]);
                    realRange[1]=Double.parseDouble(args[2]);
                    
                    imagRange[0]=Double.parseDouble(args[3]);
                    imagRange[1]=Double.parseDouble(args[4]);
                    
                    iteration=Integer.parseInt(args[5]);
                       
                }
                Frame.add(new Mandelbrot(800,800,realRange,imagRange,iteration));
                Frame.setTitle(args[0]+ " Set");
                Frame.pack();
                Frame.setVisible(true);
            }
            if(args[0].equals("Julia")){
                
                try{
                    if(args.length>2 ){
                       DefC[0]=Double.parseDouble(args[1]);
                       DefC[0]=Double.parseDouble(args[2]);
                       iteration=Integer.parseInt(args[3]);
                    }
                    
                    Julia F1 =new Julia(800,800,realRange,imagRange,DefC,iteration);
                    Frame.add(F1);
                    Frame.setTitle(args[0]+" Set");
                    Frame.pack();
                    Frame.setVisible(true);
                }
                catch (Exception e){
                    System.err.println("Your inputs have Problem");
                }
            }
            
            //******************************************************************     
               
          
        
    }
    
}
