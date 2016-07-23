package Hitomi;

import Exhentai.ExhentaiSearch;
import HttpConnection.Http;
import Manga.MangaGallery;
import Manga.MangaInfo;
import JFrame.Bottom.ConsolePanel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Noverish on 2016-01-05.
 */
public class HitomiGallery extends MangaGallery {

    public HitomiGallery(MangaInfo mangaInfo) {
        super(mangaInfo);
        htmlCode = new Http(mangaInfo.galleryUrl, true, "GET").getHtmlCode();

        engName = mangaInfo.name;
        japName = extractJapName();
        totalImageNum = extractTotalImageAndPageNum()[0];
        totalPageNum = extractTotalImageAndPageNum()[1];
        tagList = extractTagList();
    }

    private String extractJapName() {
        return "";
    }

    private int[] extractTotalImageAndPageNum() {
        int[] ans = {-1, -1};

        return ans;
    }

    private HashMap<String, String[]> extractTagList() {
        HashMap<String, String[]> list = new HashMap<>();

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

        ConsolePanel.print("\n이미지 URL을 추출하고 있습니다...");

        String url = mangaInfo.galleryUrl;
        String htmlCode;

        url = url.replace("galleries","reader");
        url += "#1-";
        htmlCode = new Http(url, ExhentaiSearch.myCookie, true, "GET").getHtmlCode();

        Pattern pattern = Pattern.compile("img-url\">[^<]*");
        Matcher matcher = pattern.matcher(htmlCode);

        while (matcher.find()) {
            String str = matcher.group().split("[>]")[1];
            str = "https:" + str;
            ans.add(str);
        }

        return ans;
    }

    @Override
    public void downloadImage(ArrayList<String> strings) {
        ConsolePanel.print("");

        for (int i = 0; i < strings.size(); i++) {
            String url = strings.get(i);

            File file = new File("Download");
            if(!file.exists())
                if (!file.mkdir())
                    ConsolePanel.print("Failed to create Download Directory");

            file = new File("Download/" + engName);
            if(!file.exists())
                if (!file.mkdir())
                    ConsolePanel.print("Failed to create Manga Directory");

            String fileName = "Download/" + engName + "/" + String.format("%03d",i) + ".jpg";

            Http.downloadImg(url, fileName, "", true, "GET");

            ConsolePanel.print((i+1) + " / " + strings.size() + "번 째 이미지 다운 완료!");
        }

        try {
            FileWriter fileWriter = new FileWriter("Download/" + engName + "/information.txt");
            fileWriter.write(this + "\n");
            fileWriter.write(this.mangaInfo.galleryUrl);
            fileWriter.close();
        } catch (IOException io) {
            ConsolePanel.print("[WARNING!] IOException occurred! During writing Html code on" + engName);
        }

        ConsolePanel.print("\n" + engName + " 다운로드 완료!");
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
