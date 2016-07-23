package Exhentai;

import HttpConnection.Http;
import Manga.MangaInfo;
import JFrame.Bottom.ConsolePanel;
import Manga.*;
import Manga.MangaSearch;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExhentaiSearch extends MangaSearch{
    public final static String myCookie = "ipb_member_id=1872686; ipb_pass_hash=82211e477c4681b4fa2ff9060e6619cb";
    public final static String imgDownloadCookie = myCookie + "; "
            + "igneous=90a57a4ff6c391e34fcbc4bf94696e9ac0d2309306a9d6aed6f1d06a4839ae1034f90fe93b3d4fda5d005c7dd6adf112d5f04722c5cab4a98a476c179c2f2757; "
            + "uconfig=tl_m-uh_y-sa_y-oi_n-qb_n-tf_n-hp_-hk_-rc_0-cats_0-xns_0-xl_-ts_m-tr_2-prn_y-dm_l-ar_0-rx_0-ry_0-ms_n-mt_n-cs_a-to_a-pn_0-sc_0; "
            + "lv=1450804951-1450804951";

    public ExhentaiSearch() {}

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
        if(nowPage > 1) {
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


    private void search() {
        searchWord = searchWord.replace(' ','+');
        htmlCode = new Http("http://exhentai.org/?page=" + (nowPage-1) + "&f_search=" + searchWord + "+language%3Akorean&f_apply=Apply+Filter", myCookie, false, "POST").getHtmlCode();

        mangaNum = extractMangaNum(htmlCode);
        mangaNameList = extractMangaNameList(htmlCode);
        galleryUrlList = extractGalleryUrlList(htmlCode);
        coverImgUrlList = extractCoverImgUrlList(htmlCode);

        if(mangaNameList.size() == coverImgUrlList.size() && coverImgUrlList.size() == galleryUrlList.size()) {
            mangaInfos.clear();
            ConsolePanel.print("");
            for(int i = 0; i< coverImgUrlList.size(); i++) {
                ConsolePanel.print("커버 이미지 다운로드 중... " + (i+1) + " / " + mangaNum);
                mangaInfos.add(new MangaInfo("Exhentai", mangaNameList.get(i), coverImgUrlList.get(i), galleryUrlList.get(i)));
            }
        }
        else {
            ConsolePanel.print("[WARNING] Mismatch of mangaNameList and imgUrlList");
        }

        mainFrame.selectPanel.removeAll();

        for (int i = 0; i < mangaInfos.size(); i++) {
            ImageIcon ic = mangaInfos.get(i).coverImg;
            MangaButton btn = new ExhentaiButton(mangaInfos.get(i));

            btn.setIcon(ic);
            btn.setName(i+"");
            mainFrame.selectPanel.addImage(btn);
        }
    }

    private int extractMangaNum(String htmlCode) {
        return htmlCode.split("show_image_pane").length - 1;
    }

    private int extractTotalPageNum(String htmlCode) {
        if(!htmlCode.contains("ptds"))
            return 0;

        Pattern pattern = Pattern.compile("sp[(][0-9]*[)]");
        Matcher matcher = pattern.matcher(htmlCode);

        int ans = -1;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group().split("[(]|[)]")[1]);
            if(number > ans)
                ans = number;
        }

        if(ans == -1)
            return 0;
        else
            return ans;
    }

    private ArrayList<String> extractMangaNameList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("hide_image_pane[^>]*[>][^<]*<[/]a>");
        Matcher matcher = pattern.matcher(htmlCode);

        while(matcher.find()) {
            String tmp = matcher.group();
            int index1 = tmp.indexOf(">");
            int index2 = tmp.lastIndexOf("<");
            ans.add(tmp.substring(index1+1,index2));
        }

        return ans;
    }

    private ArrayList<String> extractGalleryUrlList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();

        Pattern pattern = Pattern.compile("[<]a href[^>]*onmouseover");
        Matcher matcher = pattern.matcher(htmlCode);

        while(matcher.find()) {
            String str = matcher.group();

            int index1 = str.indexOf("href=\"");
            str = str.substring(index1 + 6);
            int index2 = str.indexOf("\"");
            str = str.substring(0, index2);

            ans.add(str);
        }

        return ans;
    }

    private ArrayList<String> extractCoverImgUrlList(String htmlCode) {
        ArrayList<String> ans = new ArrayList<>();
        String[] partOfHtml = htmlCode.split("show_image_pane");

        for(int a = 0;a < partOfHtml.length-1;a++) {
            String partCode = partOfHtml[a];

            Pattern pattern = Pattern.compile("<img[^>]*[/]>");
            Matcher matcher = pattern.matcher(partCode);

            while (matcher.find()) {
                String str = matcher.group();

                if (!str.contains("class=\"") && !str.contains("onclick=\"") && !str.contains("id=\""))
                    if (str.contains("alt=\"") && str.contains("style=\"")) {
                        int index1 = str.indexOf("src=\"");
                        str = str.substring(index1 + 5);
                        int index2 = str.indexOf("\"");
                        str = str.substring(0, index2);

                        ans.add(str);

                        break;
                    }
            }

            pattern = Pattern.compile("exhentai[.]org[~][^~]*[~]");
            matcher = pattern.matcher(partCode);

            while (matcher.find()) {
                String tmp = matcher.group().replace('~', '/');
                ans.add(tmp.substring(0, tmp.length() - 1));
            }
        }

        for (int i = ans.size() - 1; i >= 0; i--) {
            String str = ans.get(i);
            if (!str.contains("http://")) {
                str = "http://" + str;
                ans.set(i, str);
            }
        }

        return ans;
    }
}
