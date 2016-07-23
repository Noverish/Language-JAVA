package JFrame;

import HttpConnection.Http;
import Manga.MangaGallery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Noverish on 2016-01-05.
 */
public class ReaderPanel extends JPanel {
    private MangaGallery mangaGallery;

    private JPanel top;

    private JButton prev;
    private JButton next;
    private JTextField nowPage;
    private JLabel slash;
    private JTextField totalPage;
    private JButton setPage;

    private int nowPageInt;
    private int totalPageInt;

    public ReaderPanel() {

    }

    public ReaderPanel(MangaGallery m) {
        this.mangaGallery = m;
        m.extractImgUrlsTotalImgNum();

        top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setPreferredSize(new Dimension(900,30));

        prev = new JButton("< Prev Page");
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nowPageInt > 1) {
                    nowPageInt--;
                    nowPage.setText(nowPageInt + "");
                    readPage(nowPageInt);
                }
            }
        });

        next = new JButton("Next Page >");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nowPageInt < totalPageInt) {
                    nowPageInt++;
                    nowPage.setText(nowPageInt + "");
                    readPage(nowPageInt);
                }
            }
        });

        nowPage = new JTextField(5);
        slash = new JLabel("/");
        totalPage = new JTextField(5);
        totalPage.setEditable(false);

        setPage = new JButton("페이지로");
        setPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wantedPage = Integer.parseInt(nowPage.getText());

                if(1 <= wantedPage && wantedPage <= totalPageInt) {
                    nowPageInt = wantedPage;
                    readPage(wantedPage);
                }
                else {
                    nowPage.setText(nowPageInt + "");
                }
            }
        });

        nowPageInt = 1;
        totalPageInt = m.getTotalImageNum();

        top.add(prev);
        top.add(nowPage);
        top.add(slash);
        top.add(totalPage);
        top.add(setPage);
        top.add(next);

        nowPage.setText("1");
        totalPage.setText(totalPageInt + "");

        add(top);

        readPage(1);
    }

    private void readPage(int num) {
        BufferedImage image = Http.getBufferedImage(mangaGallery.getImageUrl(num-1), "", true, "GET");

        int width = image.getWidth();
        int height = image.getHeight();
        float rate;
        if(width > height)
            rate = (float)900/width;
        else
            rate = (float)800/height;

        width *= rate;
        height *= rate;

        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(resizedImage));

        if(getComponents().length > 1)
            remove(1);
        add(imageLabel);
    }

}
