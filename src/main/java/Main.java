import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import com.opencsv.*;
public class Main {
    public static void main(String args[]) {

        File[] csvFiles = FilterFiles.finder();
        for(File f: csvFiles){
            System.out.println(f.getName());
            Vector <String> results = ParseMetricFiles.parseCsv((f));
            try{
                CSVReader csvReader = new CSVReader(new FileReader(f));

            }catch(IOException ioe){ ioe.printStackTrace(); }



        }
    }
}
