import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Noverish on 2016-04-22.
 */

public class HttpConnectionThread extends Thread {
    private String htmlCode;
    private String urlStr;
    private String cookies;
    private String requestMethod;
    private boolean isItHttps;

    public HttpConnectionThread(String urlStr, String cookies, String requestMethod) {
        this.urlStr = urlStr;
        this.cookies = (cookies == null) ? "" : cookies;
        this.requestMethod = requestMethod;
        this.htmlCode = "There is no html code";

        if(urlStr.substring(0,5).matches("https")) {
            isItHttps = true;
        } else if(urlStr.substring(0,5).matches("http:")) {
            isItHttps = false;
        } else {
            isItHttps = false;
            System.out.println("HttpConnectionThread.constructor - I don't know it is https or http");
        }
    }

    public void run() {
        request();
    }

    private boolean request() {
        URL url;
        HttpURLConnection con;
        BufferedReader rd;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException m) {
            System.out.println("[Connect!] : MalformedURLException occurred! Because of Wrong SearchWord!");
            return false;
        }


        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException io) {
            System.out.println("[Connect!] IOException occurred! from openConnection");
            return false;
        }


        try {
            con.setRequestProperty("Cookie", cookies);
            con.setRequestMethod(requestMethod);
        }
        catch (ProtocolException pro) {
            System.out.println("[Connect!] ProtocolException occurred! from setRequestMethod");
            return false;
        }


        try {
            rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        } catch (IOException io) {
            System.out.println("[Connect!] IOException occurred! from getInputStream");
            return false;
        }


        try {
            String line;
            while((line = rd.readLine()) != null) {
                htmlCode += line;
            }
        } catch (IOException io) {
            System.out.println("[Connect!] IOException occurred! during reading from BufferedReader");
            return false;
        }

        htmlCode = processHtml(htmlCode);
        return true;
    }

    public static String processHtml(String str) {
        String ans = "";
        int tab = 0;
        int index;

        str = str.replaceAll("[>][\\s]*[<]",">\n<");

        while(0 <= (index = str.indexOf("<"))) {
            if(str.charAt(index + 1) != '/') {

                boolean comment = false;
                if(str.charAt(index + 1) == '!')
                    comment = true;

                if(str.substring(index+1,index+5).equals("link"))
                    comment = true;

                String tabs = "";
                for(int i = 0;i<tab;i++)
                    tabs += "\t";

                ans += str.substring(0,index);
                ans += tabs;
                ans += "<";
                str = str.substring(index+1);
                if(str.charAt(str.indexOf(">")-1) != '/')
                    tab++;

                if(comment)
                    tab--;
            }
            else {
                tab--;
                if(str.charAt(index-1) == '\n') {
                    String tabs = "";
                    for (int i = 0; i < tab; i++)
                        tabs += "\t";

                    ans += str.substring(0, index);
                    ans += tabs;
                    ans += "<";
                    str = str.substring(index + 1);
                }
                else {
                    ans += str.substring(0, index);
                    ans += "<";
                    str = str.substring(index + 1);
                }
            }
        }
        ans += str;

        return ans;
    }

    public String getHtmlCode() {
        return htmlCode;
    }
}
