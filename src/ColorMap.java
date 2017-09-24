
import java.awt.Color;
import java.util.Arrays;


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

public class ColorMap {
    // initializing Color Map
   public static int[] initColorMap(int steps, Color ... colors)
    {
        int colorMap[] = new int[steps];
        if (colors.length == 1)
        {
            Arrays.fill(colorMap, colors[0].getRGB());
            return colorMap;
        }
        double colorDelta = 1.0 / (colors.length - 1);
        for (int i=0; i<steps; i++)
        {
            double globalRel = (double)i / (steps - 1);
            int index0 = (int)(globalRel / colorDelta);
            int index1 = Math.min(colors.length-1, index0 + 1);
            double localRel = (globalRel - index0 * colorDelta) / colorDelta;

            Color c0 = colors[index0];
            int r0 = c0.getRed();
            int g0 = c0.getGreen();
            int b0 = c0.getBlue();
            int a0 = c0.getAlpha();

            Color c1 = colors[index1];
            int r1 = c1.getRed();
            int g1 = c1.getGreen();
            int b1 = c1.getBlue();
            int a1 = c1.getAlpha();

            int dr = r1-r0;
            int dg = g1-g0;
            int db = b1-b0;
            int da = a1-a0;

            int r = (int)(r0 + localRel * dr);
            int g = (int)(g0 + localRel * dg);
            int b = (int)(b0 + localRel * db);
            int a = (int)(a0 + localRel * da);
            int rgb =
                (a << 24) |
                (r << 16) |
                (g <<  8) |
                (b);
            colorMap[i] = rgb;
        }
        return colorMap;
    } 
}
