package Exhentai;

import JFrame.Center.InfoPanel;
import Manga.MangaButton;
import Manga.MangaInfo;

public class ExhentaiButton extends MangaButton {

    public ExhentaiButton (MangaInfo m) {
        super(m);
    }

    public void onClick() {
        mangaGallery = new ExhentaiGallery(mangaInfo);

        super.onClick();
    }
}
