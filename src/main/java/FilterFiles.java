import java.io.File;
import java.io.FilenameFilter;
public class FilterFiles {
    public static File[] finder(){
        String dirName =  new File("").getAbsolutePath();
        System.out.println(dirName);
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".csv"); }
        } );

    }
}
