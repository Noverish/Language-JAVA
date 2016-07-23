package JFrame.Top;

import Exhentai.ExhentaiSearch;
import JFrame.Bottom.ConsolePanel;
import Other.MainProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageControlPanel extends JPanel {

    private JTextField nowPage = new JTextField(3);
    private JTextField totalPage = new JTextField(3);

    public PageControlPanel() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(445,45));

        JButton prev = new JButton("< Prev Page");
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProgram.prevPageStarted = true;
            }
        });

        JLabel slash = new JLabel("/", JLabel.CENTER);
        slash.setPreferredSize(new Dimension(10,40));

        totalPage.setEditable(false);

        JButton setPageButton = new JButton("페이지로");
        setPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int page = -1;
                try {
                    page = Integer.parseInt(nowPage.getText());
                } catch (Exception ex) {
                    ConsolePanel.print("\n페이지 번호에는 숫자만 입력 할 수 있습니다.");
                }
                MainProgram.mangaSearch.setPageNum(page);
            }
        });

        JButton next = new JButton("Next Page >");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProgram.nextPageStarted = true;
            }
        });

        add(prev);
        add(nowPage);
        add(slash);
        add(totalPage);
        add(setPageButton);
        add(next);
    }

    public void refrashPageNum() {
        nowPage.setText((MainProgram.mangaSearch.getNowPage()) + "");
        totalPage.setText((MainProgram.mangaSearch.getTotalPageNum()) + "");
    }
}
