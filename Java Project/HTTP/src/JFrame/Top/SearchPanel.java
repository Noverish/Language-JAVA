package JFrame.Top;

import Exhentai.ExhentaiSearch;
import Other.MainProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel{
    private JTextField userText;

    public SearchPanel() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(445,45));

        JLabel nameLabel = new JLabel("검색어를 입력하세요 : ", JLabel.RIGHT);

        userText = new JTextField(10);

        JButton loginButton = new JButton("검색");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = userText.getText();
                MainProgram.mangaSearch.setSearchWord(str);
                MainProgram.mangaSearch.resetNowPage();
                MainProgram.searchStarted = true;
            }
        });

        add(nameLabel);
        add(userText);
        add(loginButton);
    }

    public void setJTextFieldEditable(boolean a) {
        userText.setEditable(a);
    }
}
