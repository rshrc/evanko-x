import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoreLoginInfo
{
    File file = new File("C:\\Users\\Rishi Banerjee\\Desktop\\LoginInfo.txt");


    StoreLoginInfo()throws IOException
    {
        if(!file.exists())
        file.createNewFile();
    }
    void storeLoginInfo(String text)throws IOException
    {

               PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Rishi Banerjee\\Desktop\\LoginInfo.txt",true));
               pw.write(text);
               pw.close();

    }
}
