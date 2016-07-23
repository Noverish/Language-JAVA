package Hitomi;

import HttpConnection.Http;
import Manga.MangaInfo;
import JFrame.Bottom.ConsolePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Manga.*;

public class HitomiSearch extends MangaSearch {

    public HitomiSearch() {}

    @Override
    public void givenWordSearch() {
        search();
        totalPageNum = extractTotalPageNum(htmlCode);
        mainFrame.pageControlPanel.refrashPageNum();
    }

    @Override
    public void nextPageSearch() {
        if(nowPage < totalPageNum) {
            nowPage++;
            mainFrame.pageControlPanel.refrashPageNum();
            search();
        }
        else {
            ConsolePanel.print("\n이 페이지가 마지막 페이지입니다.");
        }
    }

    @Override
    public void prevPageSearch() {
        if(nowPage != 0) {
            nowPage--;
            mainFrame.pageControlPanel.refrashPageNum();
            search();
        }
        else {
            ConsolePanel.print("\n이 페이지가 첫 페이지입니다.");
        }
    }

    @Override
    public void givenPageSearch() {
        mainFrame.pageControlPanel.refrashPageNum();
        search();
    }


    public void search() {
        htmlCode = new Http("https://hitomi.la/index-korean-" + nowPage + ".html", true,"GET").getHtmlCode();

        mangaNum = extractMangaNum(htmlCode);
        totalPageNum = extractTotalPageNum(htmlCode);
        mangaNameList = extractMangaNameList(htmlCode);
        galleryUrlList = extractGalleryUrlList(htmlCode);
        coverImgUrlList = extractCoverImgUrlList(htmlCode);

        if(mangaNameList.size() == coverImgUrlList.size() && coverImgUrlList.size() == galleryUrlList.size()) {
            mangaInfos.clear();
            ConsolePanel.print("");
            for(int i = 0; i< coverImgUrlList.size(); i++) {
                ConsolePanel.print("커버 이미지 다운로드 중... " + (i+1) + " / " + mangaNum);
                mangaInfos.add(new MangaInfo("Hitomi", mangaNameList.get(i), coverImgUrlList.get(i), galleryUrlList.get(i)));
            }
        }
        else {
            ConsolePanel.print("[WARNING] Mismatch of mangaNameList and imgUrlList");
        }

        mainFrame.selectPanel.removeAll();

        for (int i = 0; i < mangaInfos.size(); i++) {
            ImageIcon ic = mangaInfos.get(i).coverImg;
            MangaButton btn = new HitomiButton(mangaInfos.get(i));

            btn.setIcon(ic);
            btn.setName(i+"");
            mainFrame.selectPanel.addImage(btn);
        }
    }

    private int extractMangaNum(String htmlCode) {
        return htmlCode.split("img-cont").length - 1;
    }

    private int extractTotalPageNum(String htmlCode) {
        Pattern pattern = Pattern.compile("insert_paging[^<]*<");
        Matcher matcher = pattern.matcher(htmlCode);

        int ans = -1;

        while (matcher.find()) {
            String tmp = matcher.group().split("[,][ ]")[4].substring(0,3);
            tmp = tmp.split("[)]")[0];
            int number = Integer.parseInt(tmp);
            if(number > ans)
                ans = number;
        }

        if(ans == -1)
            return 1;
        else
            return ans;
    }

    private ArrayList<String> extractMangaNameList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("<h1>[^>]*>[^>]*>");
        Matcher matcher = pattern.matcher(htmlCode);

        while(matcher.find()) {
            String tmp = matcher.group();
            tmp = tmp.split("[<>]")[4];
            int index1 = 0;
            ans.add(tmp.substring(index1));
        }

        return ans;
    }

    private ArrayList<String> extractGalleryUrlList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("<h1>[^>]*>[^>]*>");
        Matcher matcher = pattern.matcher(htmlCode);

        while(matcher.find()) {
            String tmp = matcher.group();
            tmp = tmp.split("href=\"")[1];

            int index1 = 0;
            int index2 = tmp.indexOf("\"");
            ans.add("https://hitomi.la" + tmp.substring(index1,index2));
        }

        return ans;
    }

    private ArrayList<String> extractCoverImgUrlList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("img1\">[^>]*>");
        Matcher matcher = pattern.matcher(htmlCode);

        while(matcher.find()) {
            String tmp = matcher.group();
            tmp = tmp.split("src=\"")[1];

            int index1 = 0;
            int index2 = tmp.indexOf("\"");
            ans.add("https:" + tmp.substring(index1,index2));
        }

        return ans;
    }
}
