package utilities;

import java.io.FileWriter;
import java.util.Date;

 
public class PersonnalLogger {
    
    public static void WriteToFile(String text) throws Exception{
        FileWriter fw = new FileWriter("/var/log/tomcat9/mylogger.out", true);
        fw.write("[date]:"+new Date().toString()+" "+text+"\n");
        fw.close();
    }
}
