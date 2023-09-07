package temp;

import java.io.File;
import java.io.IOException;

public class FileHandling{

    public static void createFile() throws IOException {

        String path = "C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\";
        File file = new File(path+"BookMyShowDB.json");
        if ( !file.isFile()) {
            file.createNewFile();
        }

        File filePath = new File(path);
        if( !filePath.isDirectory()){
            filePath.mkdir();
        }



    }


}