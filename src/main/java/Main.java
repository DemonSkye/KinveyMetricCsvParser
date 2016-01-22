import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) {

        File[] csvFiles = FilterFiles.finder();
        for(File f: csvFiles){
            System.out.println(f.getName());
            HashMap <String, Integer> headers = ParseMetricFiles.getHeaders(f);
           /* for (Map.Entry<String,Integer> entry : headers.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Key: " + key + " -- Value: " + value); //Debug
            }*/

            //Ticket Id,Subject,Status,Type,Requester Name,First Response Time (in Hrs),Resolution Time (in Hrs)
            Vector <String> results = ParseMetricFiles.rowToVector(f, headers.get("Col4"));
            Double average = Operations.getAverageForCol(results);
            System.out.println("Average is: " + average);

        }
    }
}
