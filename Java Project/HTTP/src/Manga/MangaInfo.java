package Manga;

import Exhentai.ExhentaiSearch;
import HttpConnection.Http;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MangaInfo {
    public String site;
    public String smallCoverImageUrl;
    public String name;
    public String galleryUrl;
    public ImageIcon coverImg;

    public MangaInfo(String site, String name, String smallCoverImageUrl, String galleryUrl) {
        this.name = name;
        this.smallCoverImageUrl = smallCoverImageUrl;
        this.galleryUrl = galleryUrl;

        if(site.equals("Exhentai"))
            this.coverImg = new ImageIcon(Http.getBufferedImage(smallCoverImageUrl, ExhentaiSearch.imgDownloadCookie, false, "GET"));
        else if(site.equals("Hitomi")) {
            BufferedImage tmp = Http.getBufferedImage(smallCoverImageUrl, "", true, "GET");

            int width = tmp.getWidth();
            int height = tmp.getHeight();

            float rate = (float)200/width;

            width *= rate;
            height *= rate;

            coverImg = new ImageIcon(tmp.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
        }
    }

}
