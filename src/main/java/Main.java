import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) {

        File[] csvFiles = FilterFiles.finder();
        for(File f: csvFiles){
            HashMap <String, Integer> headers = ParseMetricFiles.getHeaders(f);
           /* for (Map.Entry<String,Integer> entry : headers.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Key: " + key + " -- Value: " + value); //Debug
            }*/
            //Ticket Id,Subject,Status,Type,Requester Name,First Response Time (in Hrs),Resolution Time (in Hrs)
            Vector <String> results = ParseMetricFiles.colToVector(f, headers.get("First Response Time (in Hrs)"));
            Double averageMinutesToFirstReply = Operations.getAverageResolutionTime(results);
            System.out.println("Average minutes to first reply: " + averageMinutesToFirstReply );
            double median = Operations.getMedianfirstReplyTime(results);
            System.out.println("Median first reply time is: " + median );
            HashMap<String, Double> types = Operations.getTicketTypes ( ParseMetricFiles.colToVector(f, headers.get("Type")));
            for(Map.Entry<String,Double> entry: types.entrySet() ){
                String key = entry.getKey();
                Double value = entry.getValue();
                System.out.println("Type:" + key + " " + value*100 + "%");
            }

        }
    }
}
