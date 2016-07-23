package JFrame;

import Exhentai.ExhentaiSearch;
import Hitomi.HitomiSearch;
import JFrame.Bottom.ConsolePanel;
import JFrame.Center.SelectPanel;
import JFrame.Top.PageControlPanel;
import JFrame.Top.SearchPanel;
import Other.MainProgram;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private static MainFrame mainFrame = null;

    public static MainFrame getMainFrame() {
        if(mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }
    public JTabbedPane jTabbedPane;

    public JPanel main;

    public ReaderPanel imageReader;

    public JPanel topPanel;

    public JPanel centerPanel;
    public SelectPanel selectPanel;
    public JPanel info;
    public ConsolePanel consolePanel;

    public SearchPanel searchPanel;

    public JTextArea downloadQueue;

    public PageControlPanel pageControlPanel = new PageControlPanel();

    private MainFrame() {
        setTitle("MangaManga Downloader");

        jTabbedPane = new JTabbedPane();

        main = new JPanel();
        main.setLayout(new FlowLayout());

        top();
        center();
        bottom();

        imageReader = new ReaderPanel();

        jTabbedPane.add("Image Search", main);
        jTabbedPane.add("Image Reader", imageReader);

        add(jTabbedPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void top() {
        JPanel toptopPanel = new JPanel();
        toptopPanel.setLayout(new FlowLayout());
        toptopPanel.setPreferredSize(new Dimension(900,30));

        JButton exhentai = new JButton("Exhentai");
        exhentai.setPreferredSize(new Dimension(100, 20));
        exhentai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProgram.mangaSearch = new ExhentaiSearch();
                searchPanel.setJTextFieldEditable(true);

                ConsolePanel.print("\nExhentai로 변경되었습니다!");
            }
        });
        toptopPanel.add(exhentai);

        JButton hitomi = new JButton("Hitomi");
        hitomi.setPreferredSize(new Dimension(100, 20));
        hitomi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProgram.mangaSearch = new HitomiSearch();
                searchPanel.setJTextFieldEditable(false);

                MainProgram.searchStarted = true;

                ConsolePanel.print("\nHitoomi로 변경되었습니다!");
                ConsolePanel.print("Hitoomi는 검색이 불가능 합니다.");
            }
        });
        toptopPanel.add(hitomi);

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(900,50));

        searchPanel = new SearchPanel();
        topPanel.add(searchPanel);
        topPanel.add(pageControlPanel);

        main.add(toptopPanel);
        main.add(topPanel);
    }

    private void center() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setPreferredSize(new Dimension(900,520));

        selectPanel = new SelectPanel();
        JScrollPane selectScroll = new JScrollPane(selectPanel);
        selectScroll.getVerticalScrollBar().setUnitIncrement(16);
        selectScroll.setPreferredSize(new Dimension(445,515));
        centerPanel.add(selectScroll);

        info = new JPanel();
        JScrollPane infoScroll = new JScrollPane(info);
        infoScroll.getVerticalScrollBar().setUnitIncrement(16);
        infoScroll.setPreferredSize(new Dimension(445,515));
        centerPanel.add(infoScroll);

        main.add(centerPanel);
    }

    private void bottom() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setPreferredSize(new Dimension(900,250));

        consolePanel = ConsolePanel.getConsolePanel();
        JScrollPane consoleScroll = new JScrollPane(consolePanel);
        consoleScroll.getVerticalScrollBar().setUnitIncrement(16);
        consoleScroll.setPreferredSize(new Dimension(445,200));

        bottomPanel.add(consoleScroll);

        downloadQueue = new JTextArea("망가 다운로드 예정 목록\n");
        downloadQueue.setEditable(false);
        downloadQueue.setLineWrap(true);
        downloadQueue.setWrapStyleWord(true);
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        downloadQueue.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane queueScroll = new JScrollPane(downloadQueue);
        queueScroll.setPreferredSize(new Dimension(445,200));

        bottomPanel.add(queueScroll);

        main.add(bottomPanel);
    }
}
