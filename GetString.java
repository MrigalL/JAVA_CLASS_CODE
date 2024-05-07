import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//从所给的网站名获取一个字符串
public class GetString {
    private String name;
    private static HttpURLConnection connection = null;

    public static String httpRequest(String url)
    {

        String content = "";
        try{
            URL u = new URL(url);
            connection = (HttpURLConnection)u.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
            int code = connection.getResponseCode();
            if(code == 200){
                InputStream in = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader reader = new BufferedReader(isr);
                String line = null;
                while((line = reader.readLine()) != null){
                    content += line;
                }
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
        return content;
    }
}

