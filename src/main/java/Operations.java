import java.awt.font.NumericShaper;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by Damien on 1/22/2016.
 */
public class Operations {
    //This will not work on time based data
    public static double getAverageForCol(Vector<String> someValues){
        Vector <Double> numericValues = new Vector<Double>();
        for(String s: someValues){
            try {
                numericValues.add(Double.parseDouble(s));
            }catch(NumberFormatException nfe){ System.err.println("Ignore the column header...Zzzzz"); }
        }
        Collections.sort(numericValues);
        double average=0.0;
        for(Double d:numericValues) {
            average+=d;
        }
        average /= numericValues.size();
        return average;
    }
}
