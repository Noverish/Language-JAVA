package Manga;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Noverish on 2016-01-05.
 */
abstract public class MangaGallery extends Thread{

    protected MangaInfo mangaInfo;
    protected String htmlCode;
    protected String engName;
    protected String japName;
    protected ArrayList<String> imageUrls;
    protected HashMap<String, String[]> tagList;
    protected int totalImageNum;
    protected int totalPageNum;

    public MangaGallery(MangaInfo mangaInfo) {
        this.mangaInfo = mangaInfo;

        japName = "";
        totalImageNum = -1;
        totalPageNum = -1;
        tagList = new HashMap<>();
    }


    abstract public void extractImgUrlsTotalImgNum();

    abstract public void download();

    public ArrayList<String> extractImageUrls() {return new ArrayList<>();}

    public void downloadImage(ArrayList<String> strings) {}

    public void run() {
        download();
    }


    public String getJapName() {
        return japName;
    }

    public String toString() {
        String str = "";

        str += "영문 이름 : " + engName + "\n";
        str += "일본 이름 : " + japName + "\n";
        str += "페이지 수 : " + totalImageNum + "\n";

        str += "\n 태그 목록 \n";

        for(String tagName : tagList.keySet()) {
            String[] tags = tagList.get(tagName);

            str += String.format("%s",tagName) + " : ";

            for(int i = 0;i<tags.length;i++) {
                str += tags[i];

                if(i != tags.length-1)
                    str += ", ";
            }

            str += "\n";
        }

        return str;
    }

    public int getTotalImageNum() {
        return totalImageNum;
    }

    public String getImageUrl(int index) {
        return imageUrls.get(index);
    }
}
