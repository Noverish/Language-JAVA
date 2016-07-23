package Manga;

import Exhentai.ExhentaiGallery;
import JFrame.Center.InfoPanel;
import JFrame.*;

import javax.swing.*;

abstract public class MangaButton extends JButton {
    protected MainFrame mainFrame = MainFrame.getMainFrame();

    protected MangaInfo mangaInfo;
    protected MangaGallery mangaGallery;

    public MangaButton(MangaInfo m) {
        mangaInfo = m;
    }

    public void onClick() {
        InfoPanel infoPanel = new InfoPanel(this);

        mainFrame.info.removeAll();
        mainFrame.info.add(infoPanel);
        mainFrame.setVisible(true);
    }


    public MangaInfo getMangaInfo() {
        return mangaInfo;
    }

    public MangaGallery getMangaGallery() { return mangaGallery; }
}
