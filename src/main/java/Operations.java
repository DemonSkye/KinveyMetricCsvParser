import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import hirondelle.date4j.DateTime;

public class Operations {
    //This will not work on time based data -- Not really sure what this will work on...
    //made it more as a test but it may have some use someday (average ticket interactions or something?
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

    //Similar to the above, this is mostly for testing, but could be useful at some point.
    public static double getMedianForCol(Vector<String> someValues){
        Vector <Double> numericValues = new Vector<Double>();
        for(String s: someValues){
            try {
                numericValues.add(Double.parseDouble(s));
            }catch(NumberFormatException nfe){ System.err.println("Ignore the column header...Zzzzz"); }
        }
        Collections.sort(numericValues);


        double median = numericValues.get(numericValues.size()/2);
        return median;
    }

    public static double getAverageResolutionTime (Vector<String> firstReply){
        double minutes = 0.0;
        for(String s: firstReply){
            if(!s.contains("First")) {
                DateTime resolutionTime = new DateTime(s);
                minutes += resolutionTime.getMinute();
                minutes += resolutionTime.getHour()* 60;
            }
        }
        minutes /= firstReply.size();

        return minutes;
    }

    public static double getMedianfirstReplyTime (Vector<String> firstReply){
        Vector <Double> minutes = new Vector<Double>();
        for(String s:firstReply){
            if(!s.contains("First")){
                int minute =0;
                DateTime resolutionTime = new DateTime(s);
                minute += resolutionTime.getMinute();
                minute += resolutionTime.getHour()*60;
                minutes.add(minute*1.0);
            }
        }
        Collections.sort(minutes);
        return minutes.get(minutes.size()/2);
    }

    public static HashMap<String, Double> getTicketTypes (Vector <String> Types){
        HashMap<String, Double> ticketTypes = new HashMap<String, Double>();
        double[] typeCount = new double[10];
        int count =0;
        for(String s: Types){
            if(!s.toLowerCase().contains("type")  ){
                if(s.equalsIgnoreCase("Bug Report")){
                    typeCount[0]++;
                }
                if(s.equalsIgnoreCase("Duplicate Ticket")){
                    typeCount[1]++;
                }
                if(s.equalsIgnoreCase("Feature Request")){
                    typeCount[2]++;
                }
                if(s.equalsIgnoreCase("Incident")){
                    typeCount[3]++;
                }
                if(s.equalsIgnoreCase("Junk")){
                    typeCount[4]++;
                }
                if(s.equalsIgnoreCase("Outage Analysis")){
                    typeCount[5]++;
                }
                if(s.equalsIgnoreCase("Question - Code")) {
                    typeCount[6]++;
                }
                if(s.equalsIgnoreCase("Question - Sales")) {
                    typeCount[7]++;
                }
                if(s.equalsIgnoreCase("Question - Product")) {
                    typeCount[8]++;
                }
                count++;

            }
            ticketTypes.put("Bug Report", typeCount[0]/ count);
            ticketTypes.put("Duplicate Ticket", typeCount[1] / count);
            ticketTypes.put("Feature Request", typeCount[2] / count);
            ticketTypes.put("Incident", typeCount[3] / count);
            ticketTypes.put("Junk", typeCount[4] / count);
            ticketTypes.put("Outage Analysis", typeCount[5] / count);
            ticketTypes.put("Question - Code", typeCount[6] / count);
            ticketTypes.put("Question - Sales", typeCount[7] / count);
            ticketTypes.put("Question - Product", typeCount[8] / count);
        }
        return ticketTypes;
    }



}
