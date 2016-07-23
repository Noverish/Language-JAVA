package Other;

import Exhentai.ExhentaiSearch;
import Hitomi.HitomiSearch;
import JFrame.*;
import JFrame.Bottom.ConsolePanel;
import Manga.MangaGallery;
import Manga.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainProgram {
    private static MainFrame mainFrame;
    public static MangaSearch mangaSearch;
    public static ArrayList<MangaGallery> queue;
    public static boolean searchStarted = false;
    public static boolean nextPageStarted = false;
    public static boolean prevPageStarted = false;
    public static boolean downloadStarted = false;
    public static boolean pageNumStarted = false;

    public static void main(String[] args) throws IOException {

        queue = new ArrayList<>();
        mangaSearch = new ExhentaiSearch();
        mainFrame = MainFrame.getMainFrame();
        mainFrame.setSize(900,900);
        mainFrame.setResizable(false);

        while(true) {
            mainFrame.setVisible(true);

            try {
                Thread.sleep(500);
            } catch (InterruptedException io) {
                ConsolePanel.print("Sleep Method was Failed!");
            }

            if(searchStarted) {
                mangaSearch.givenWordSearch();
                searchStarted = false;
            }

            if(nextPageStarted) {
                mangaSearch.nextPageSearch();
                nextPageStarted = false;
            }

            if(prevPageStarted) {
                mangaSearch.prevPageSearch();
                prevPageStarted = false;
            }

            if(pageNumStarted) {
                mangaSearch.givenPageSearch();
                pageNumStarted = false;
            }

            if(downloadStarted) {
                while(queue.size()!=0) {
                    queue.get(0).start();
                    try {
                        queue.get(0).join();
                    } catch(InterruptedException ie) {
                        ConsolePanel.print("[WARNING!] InterruptedException occurred! from queue.get().join()");
                    }
                    queue.remove(0);
                    printQueue();
                }
                downloadStarted = false;
            }
        }
    }

    public static void printQueue() {
        String tmp = "망가 다운로드 예정 목록\n";

        for(MangaGallery mg : queue) {
            tmp += " - " + mg.getJapName() + "\n";
        }

        mainFrame.downloadQueue.setText(tmp);
        mainFrame.downloadQueue.setVisible(true);
    }
}
