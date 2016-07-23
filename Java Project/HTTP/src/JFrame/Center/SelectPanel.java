package JFrame.Center;

import JFrame.Bottom.ConsolePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Manga.*;
import JFrame.*;

public class SelectPanel extends JPanel {
    public SelectPanel() {
        setLayout(new GridLayout(0,2));
    }

    public void addImage(MangaButton btn) {
        btn.setPreferredSize(new Dimension(200,300));
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsolePanel.print("\n망가 정보 다운 완료!");
                MainFrame.getMainFrame().setVisible(true);
                btn.onClick();
            }
        });
        add(btn);
    }
}
