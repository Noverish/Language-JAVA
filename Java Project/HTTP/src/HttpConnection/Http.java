package HttpConnection;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import JFrame.Bottom.ConsolePanel;

public class Http {
    protected String htmlCode = "";

    public Http() {
        this("http://www.google.com","", false,"POST");
    }

    public Http(String urlStr, boolean https, String requestMethod) {
        this(urlStr,"",https,requestMethod);
    }
    
    public Http(String urlStr, String cookies, boolean https, String requestMethod) {
        if(https) {
            if (!httpsConnect(urlStr, cookies, requestMethod))
                System.exit(-1);
        }
        else {
            if (!httpConnect(urlStr, cookies, requestMethod))
                System.exit(-1);
        }
    }

    public String getHtmlCode() { return htmlCode; }

    private boolean httpConnect(String urlStr, String cookies, String requestMethod) {
        URL url;
        HttpURLConnection con;
        BufferedReader rd;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException m) {
            ConsolePanel.print("[Connect!] : MalformedURLException occurred! Because of Wrong SearchWord!");
            return false;
        }


        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! from openConnection");
            return false;
        }


        try {
            con.setRequestProperty("Cookie", cookies);
            con.setRequestMethod(requestMethod);
        }
        catch (ProtocolException pro) {
            ConsolePanel.print("[Connect!] ProtocolException occurred! from setRequestMethod");
            return false;
        }


        try {
            rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! from getInputStream");
            return false;
        }


        try {
            String line;
            while((line = rd.readLine()) != null) {
                htmlCode += line;
            }
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! during reading from BufferedReader");
            return false;
        }

        htmlCode = processHtml(htmlCode);

        if(htmlCode.contains("불법·유해정보사이트에 대한 차단 안내") || htmlCode.length() == 404) {
            ConsolePanel.print("\n" + ConsolePanel.hell);
        }

        if(htmlCode.contains("No hits found")) {
            ConsolePanel.print("\n" + ConsolePanel.no);
        }

        writeHtmlCode();

        //ConsolePanel.print("HttpConnection Done!");

        return true;
    }

    private boolean httpsConnect(String urlStr, String cookies, String requestMethod) {
        URL url;
        HttpsURLConnection con;
        BufferedReader rd;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException m) {
            ConsolePanel.print("[Connect!] : MalformedURLException occurred! Because of Wrong SearchWord!");
            return false;
        }


        try {
            con = (HttpsURLConnection) url.openConnection();
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! from openConnection");
            return false;
        }


        try {
            con.setRequestProperty("Cookie", cookies);
            con.setRequestMethod(requestMethod);
        }
        catch (ProtocolException pro) {
            ConsolePanel.print("[Connect!] ProtocolException occurred! from setRequestMethod");
            return false;
        }


        try {
            rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! from getInputStream");
            return false;
        }


        try {
            String line;
            while((line = rd.readLine()) != null) {
                htmlCode += line;
            }
        } catch (IOException io) {
            ConsolePanel.print("[Connect!] IOException occurred! during reading from BufferedReader");
            return false;
        }

        htmlCode = processHtml(htmlCode);

        if(htmlCode.contains("불법·유해정보사이트에 대한 차단 안내") || htmlCode.length() == 404) {
            ConsolePanel.print("\n" + ConsolePanel.hell);
        }

        if(htmlCode.contains("No hits found")) {
            ConsolePanel.print("\n" + ConsolePanel.no);
        }

        writeHtmlCode();

        //ConsolePanel.print("HttpConnection Done!");

        return true;
    }

    private void writeHtmlCode() {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(htmlCode);
            fileWriter.close();
        } catch (IOException io) {
            ConsolePanel.print("[WARNING!] IOException occurred! During writing Html code on output.txt");
        }
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

    public static ArrayList<String> getImgUrlList(String html) {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img[^>]*[/]>");
        Matcher matcher = pattern.matcher(html);

        while(matcher.find()) {
            String str = matcher.group();
            int index1 = str.indexOf("src=\"");
            str = str.substring(index1+5);
            int index2 = str.indexOf("\"");
            str = str.substring(0,index2);
            ans.add(str);
        }
        return ans;
    }

    public static boolean downloadImg(String urlStr, String fileName, String cookies, boolean https, String requestMethod) {
        ConsolePanel.print(fileName + " Started!");

        InputStream in;
        FileOutputStream out;
        URL url;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException m) {
            ConsolePanel.print("[Download Image!] : MalformedURLException occurred! Because of Wrong URL!");
            return false;
        }

        if(https) {
            HttpsURLConnection con;

            try {
                con = (HttpsURLConnection) url.openConnection();
            } catch (IOException io) {
                ConsolePanel.print("[Download Image!] IOException occurred! from openConnection");
                return false;
            }


            try {
                con.setRequestProperty("Cookie", cookies);
                con.setRequestMethod(requestMethod);
            } catch (ProtocolException pro) {
                ConsolePanel.print("[Download Image!] ProtocolException occurred! from setRequestMethod");
                return false;
            }


            try {
                in = con.getInputStream();
            } catch (IOException io) {
                ConsolePanel.print("[Download Image!] IOException occurred! from getInputStream");
                return false;
            }


            try {
                out = new FileOutputStream(fileName);
            } catch (FileNotFoundException f) {
                ConsolePanel.print("[Download Image!] FileNotFoundException occurred! from FileOutputStream");
                return false;
            }
        }
        else {
            HttpURLConnection con;

            try {
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException io) {
                ConsolePanel.print("[Download Image!] IOException occurred! from openConnection");
                return false;
            }


            try {
                con.setRequestProperty("Cookie", cookies);
                con.setRequestMethod(requestMethod);
            } catch (ProtocolException pro) {
                ConsolePanel.print("[Download Image!] ProtocolException occurred! from setRequestMethod");
                return false;
            }


            try {
                in = con.getInputStream();
            } catch (IOException io) {
                ConsolePanel.print("[Download Image!] IOException occurred! from getInputStream");
                return false;
            }


            try {
                out = new FileOutputStream(fileName);
            } catch (FileNotFoundException f) {
                ConsolePanel.print("[Download Image!] FileNotFoundException occurred! from FileOutputStream");
                return false;
            }
        }

        int c;
        byte[] b = new byte[1024];

        try {
            if(in != null) {
                while ((c = in.read(b)) != -1)
                    out.write(b, 0, c);
                in.close();
                out.close();
            }
        } catch (IOException io) {
            ConsolePanel.print("[Download Image!] IOException occurred! from write");
            return false;
        }

        ConsolePanel.print(fileName + " Done!");

        return true;
    }

    public static BufferedImage getBufferedImage(String urlStr, String Cookies, boolean https, String requestMethod) {
        BufferedImage bufferedImage = null;
        URL url = null;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException m) {
            ConsolePanel.print("[getBufferedImage] : MalformedURLException occurred! Because of Wrong urlStr!");
        }

        if(https) {
            try {
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestProperty("Cookie", Cookies);
                con.setRequestMethod(requestMethod);
                InputStream in = con.getInputStream();
                bufferedImage = ImageIO.read(in);
                in.close();
            } catch (Exception ex) {
                ConsolePanel.print("Error");
            }
        }
        else {
            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Cookie", Cookies);
                con.setRequestMethod(requestMethod);
                InputStream in = con.getInputStream();
                bufferedImage = ImageIO.read(in);
                in.close();
            } catch (Exception ex) {
                ConsolePanel.print("Error");
            }
        }

        return bufferedImage;
    }
}


