package Hitomi;

import Exhentai.ExhentaiGallery;
import JFrame.Center.InfoPanel;
import Manga.MangaButton;
import Manga.MangaInfo;

public class HitomiButton extends MangaButton {

    public HitomiButton(MangaInfo m) {
        super(m);
    }

    public void onClick() {
        mangaGallery = new HitomiGallery(mangaInfo);

        super.onClick();
    }
}
