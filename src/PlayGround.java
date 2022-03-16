import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class PlayGround {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://flcitiesdev.appiancloud.com/database/export.php");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            int file_size = urlConnection.getContentLength();
            System.out.println(file_size);
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }


}
