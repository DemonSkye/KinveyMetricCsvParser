import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import com.opencsv.*;

public class ParseMetricFiles {

    //Parse row to new Vector & return to caller
    public static Vector<String> colToVector(File csv, Integer i){
        Vector<String> results = new Vector<String>();
        String[] nextLine;
        boolean isValid = true;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(csv));
            while( (nextLine = csvReader.readNext() ) != null){
                for(String s: nextLine){
                    if(s.toLowerCase().contains("junk") || s.toLowerCase().contains("duplicate") || s.toLowerCase().contains("spam")){
                        isValid =false;
                    }
                }
                if(isValid) {
                    results.add(nextLine[i]);
                }
                isValid = true;
            }
        }catch (IOException ioe){ ioe.printStackTrace(); }
        return results;
    }

    //Get Headers and return as hashmap
    public static HashMap<String, Integer> getHeaders(File csv){
        HashMap <String, Integer> headerMapping = new HashMap<String, Integer>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(csv));
            String[] nextLine;
            int i=0;
            int j = 0;
            while( (nextLine = csvReader.readNext() ) != null){
                if (i ==0){
                    while(j < nextLine.length) {
                        headerMapping.put(nextLine[j], j);
                        j++;
                    }
                    i++;
                }
            }
        }catch (IOException ioe){ ioe.printStackTrace(); }
        return headerMapping;
    }

}
