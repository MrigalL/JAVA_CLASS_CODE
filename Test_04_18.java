import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test_04_18 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GetString a=new GetString();
        String content =a.httpRequest("https://movie.douban.com/top250");

        String regex = "<em class=\"\">(\\d+)</em>.*?<span class=\"title\">(.*?)</span>.*?导演: (.*?)&nbsp;&nbsp;&nbsp;主演: (.*?)<br>.*?(\\d{4})&nbsp;/&nbsp;.*?<span class=\"rating_num\" property=\"v:average\">(.*?)</span>";

        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(content);
        while(m.find())
        {


            System.out.println("电影排名："+m.group(1)+"\n电影名："+m.group(2) + "\n导演: " +m.group(3)+"\n主演: "+m.group(4)+"\n年份："+m.group(5)+"\n评分："+m.group(6));
            System.out.println("\n===================分割线==================\n");

        }
    }
}

