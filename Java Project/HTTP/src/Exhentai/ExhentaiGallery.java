package Exhentai;

import HttpConnection.Http;
import Manga.MangaGallery;
import Manga.MangaInfo;
import JFrame.Bottom.ConsolePanel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExhentaiGallery extends MangaGallery {

    public ExhentaiGallery(MangaInfo mangaInfo) {
        super(mangaInfo);
        htmlCode = new Http(mangaInfo.galleryUrl, ExhentaiSearch.myCookie, false, "POST").getHtmlCode();

        engName = mangaInfo.name;
        japName = extractJapName();
        totalImageNum = extractTotalImageAndPageNum()[0];
        totalPageNum = extractTotalImageAndPageNum()[1];
        tagList = extractTagList();
    }


    private String extractJapName() {
        String ans = "";

        Pattern pattern = Pattern.compile("gj[^<]*[<]");
        Matcher matcher = pattern.matcher(htmlCode);

        if (matcher.find()) {
            ans = matcher.group();
            ans = ans.substring(4, ans.length() - 1);
        } else {
            ConsolePanel.print(ans);
        }

        return ans;
    }

    private int[] extractTotalImageAndPageNum() {
        int[] ans = {-1, -1};

        Pattern pattern = Pattern.compile("Showing[^i]*");
        Matcher matcher = pattern.matcher(htmlCode);

        if (matcher.find()) {
            String[] str = matcher.group().split(" ");
            ans[0] = Integer.parseInt(str[5]);
        } else {
            ConsolePanel.print("There is no Total Image Number");
        }

        ans[1] = (htmlCode.split("sp[(]").length / 2);

        if (ans[1] == 0)
            ans[1] = 1;

        return ans;
    }

    private HashMap<String, String[]> extractTagList() {
        HashMap<String, String[]> list = new HashMap<>();

        String[] tags = htmlCode.split("class=\"tc\">");

        for (int i = 1; i < tags.length; i++) {
            String tagName = tags[i].split(":")[0];
            String[] tagList;

            int tagNum = tags[i].split("td_[^\"]*").length - 1;
            tagList = new String[tagNum];

            Pattern pattern = Pattern.compile("td_[^\"]*");
            Matcher matcher = pattern.matcher(tags[i]);


            for (int j = 0; matcher.find(); j++) {
                String tmp = matcher.group();
                if (tmp.split(":").length == 2) {
                    tagList[j] = tmp.split(":")[1].replace('_', ' ');
                } else {
                    tagList[j] = tmp.split(":")[0].substring(3).replace('_', ' ');
                }
            }

            list.put(tagName, tagList);
        }

        return list;
    }

    @Override
    public void extractImgUrlsTotalImgNum() {
        imageUrls = extractImageUrls();
        totalImageNum = imageUrls.size();
    }

    @Override
    public ArrayList<String> extractImageUrls() {
        ArrayList<String> ans = new ArrayList<>();

        ConsolePanel.print("");

        for (int i = 1; i <= totalPageNum; i++) {
            ConsolePanel.print(i + "페이지의 이미지 URL을 추출하고 있습니다...");

            String url = mangaInfo.galleryUrl;
            String htmlCode;

            if (i == 1)
                htmlCode = this.htmlCode;
            else {
                url += "?p=" + (i + 1);
                htmlCode = new Http(url, ExhentaiSearch.myCookie, false, "POST").getHtmlCode();
            }

            Pattern pattern = Pattern.compile("repeat[^<]*[^>]*>");
            Matcher matcher = pattern.matcher(htmlCode);

            while (matcher.find()) {
                String str = matcher.group();
                int index1 = str.indexOf("href");
                str = str.substring(index1 + 6, str.length() - 2);
                ans.add(str);
            }
        }

        return ans;
    }

    @Override
    public void downloadImage(ArrayList<String> strings) {
        ConsolePanel.print("");

        for (int i = 0; i < strings.size(); i++) {
            String url = strings.get(i);
            String imageUrl = "";
            String htmlCode = new Http(url, ExhentaiSearch.imgDownloadCookie, false, "POST").getHtmlCode();

            Pattern pattern = Pattern.compile("src=\"[^>]*style");
            Matcher matcher = pattern.matcher(htmlCode);

            if (matcher.find()) {
                String str = matcher.group();
                imageUrl = str.substring(5, str.length() - 7);
            }

            File file = new File("Download");
            if (!file.exists())
                if (!file.mkdir())
                    ConsolePanel.print("Failed to create Download Directory");

            file = new File("Download/" + japName);
            if (!file.exists())
                if (!file.mkdir())
                    ConsolePanel.print("Failed to create Manga Directory");

            String fileName = "Download/" + japName + "/" + String.format("%03d", i) + ".jpg";

            Http.downloadImg(imageUrl, fileName, ExhentaiSearch.imgDownloadCookie, false, "GET");

            ConsolePanel.print((i + 1) + " / " + strings.size() + "번 째 이미지 다운 완료!");
        }

        try {
            FileWriter fileWriter = new FileWriter("Download/" + japName + "/information.txt");
            fileWriter.write(this + "\n");
            fileWriter.write(this.mangaInfo.galleryUrl);
            fileWriter.close();
        } catch (IOException io) {
            ConsolePanel.print("[WARNING!] IOException occurred! During writing Html code on" + japName);
        }

        ConsolePanel.print("\n" + japName + " 다운로드 완료!");
    }


    @Override
    public void download() {
        imageUrls = extractImageUrls();
        downloadImage(imageUrls);

        try {
            FileWriter fileWriter = new FileWriter("Download/" + japName + "/ImageUrls.txt");
            for(String str : imageUrls)
                fileWriter.write(str + "\n");
            fileWriter.close();
        } catch (IOException io) {
            ConsolePanel.print("[WARNING!] IOException occurred! During writing Html code on" + japName);
        }
    }
}
