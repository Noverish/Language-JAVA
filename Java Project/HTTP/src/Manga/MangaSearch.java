package Manga;

import HttpConnection.Http;
import JFrame.Bottom.ConsolePanel;
import JFrame.MainFrame;
import Other.MainProgram;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MangaSearch {
    protected MainFrame mainFrame = MainFrame.getMainFrame();

    protected String htmlCode;
    protected String searchWord = "";
    protected int nowPage = 1;

    protected int mangaNum;
    protected int totalPageNum;

    protected ArrayList<String> mangaNameList;
    protected ArrayList<String> galleryUrlList;
    protected ArrayList<String> coverImgUrlList;
    protected ArrayList<MangaInfo> mangaInfos = new ArrayList<>();

    protected MangaSearch() {}

    abstract public void givenWordSearch();

    abstract public void nextPageSearch();

    abstract public void prevPageSearch();

    abstract public void givenPageSearch();

    public void setSearchWord(String str) {
        searchWord = str;
    }

    public void setPageNum(int num) {
        if(1 <= num && num <= totalPageNum) {
            nowPage = num;
            MainProgram.pageNumStarted = true;
        }
        else {
            ConsolePanel.print("\n가능한 페이지 번호가 아닙니다.\n");
            MainFrame.getMainFrame().pageControlPanel.refrashPageNum();
        }
    }

    public void resetNowPage() {
        nowPage = 1;
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

}
