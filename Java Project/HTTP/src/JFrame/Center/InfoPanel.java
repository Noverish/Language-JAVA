package JFrame.Center;

import Manga.MangaButton;
import Manga.MangaGallery;
import Manga.MangaInfo;
import Other.MainProgram;

import JFrame.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {
    public MangaGallery mangaGallery;
    private MangaInfo mangaInfo;
    private JTextArea info;
    private JButton download;
    private JButton read;
    private JScrollPane infoScroll;

    public InfoPanel(MangaButton m) {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400, 490));

        mangaGallery = m.getMangaGallery();
        mangaInfo = m.getMangaInfo();

        info = new JTextArea(mangaGallery.toString());
        info.setLineWrap(true);
        info.setWrapStyleWord(true);

        Border border = BorderFactory.createLineBorder(Color.WHITE);
        info.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        infoScroll = new JScrollPane(info);
        infoScroll.getVerticalScrollBar().setUnitIncrement(16);
        infoScroll.setPreferredSize(new Dimension(400,130));

        download = new JButton("다운로드!");
        download.setPreferredSize(new Dimension(100,50));
        download.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainProgram.queue.add(mangaGallery);
                MainProgram.printQueue();
                MainProgram.downloadStarted = true;
            }
        });

        read = new JButton("만화 보기!");
        read.setPreferredSize(new Dimension(100,50));
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame m = MainFrame.getMainFrame();

                m.jTabbedPane.remove(1);
                m.jTabbedPane.add("Image Reader",new ReaderPanel(mangaGallery));
            }
        });

        add(new JLabel(mangaInfo.coverImg));
        add(infoScroll);
        add(download);
        add(read);

    }
}
