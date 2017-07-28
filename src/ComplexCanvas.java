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

public class ComplexCanvas {
    
   private int width;
   private int height;
   private double[] rangeReal;  // Real axis Range
   private double[] rangeImg;   // Imaginary axis Range   
   

//Constructors
//******************************************************************************   
   public ComplexCanvas(int width, int height , double[] RangeReal, double [] RangeImg){
       // Setup canvas Width and heght and Ranges
       this.width= width;
       this.height=height;
       this.rangeReal=RangeReal;
       this.rangeImg=RangeImg;
   }
//******************************************************************************

//Methods
//******************************************************************************   
   public double genarateRealPart(int x){ 
      // use genarate the real part of complec real componant corresponding Canvas
      return rangeReal[0] + (rangeReal[1]-rangeReal[0])*((double)x/width);                      
   }
   
   public double genareteImgPart(int y){
      // use genarate the imaginary part of complec real componant corresponding Canvas
      return rangeImg[1] - (rangeImg[1]-rangeImg[0])*((double)y/height);
   }
//******************************************************************************
   
}// end Class
