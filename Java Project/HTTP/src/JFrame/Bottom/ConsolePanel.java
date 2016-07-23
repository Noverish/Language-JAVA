package JFrame.Bottom;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import java.awt.*;

import JFrame.*;

public class ConsolePanel extends JTextArea {
    public static ConsolePanel consolePanel = null;

    public static ConsolePanel getConsolePanel() {
        if(consolePanel == null) {
            consolePanel = new ConsolePanel();
        }

        return consolePanel;
    }

    public static final String hell = "HELL! CHO! SHEN! 아이피를 우회해 주세요!";
    public static final String no = "검색 결과가 없습니다. 다른 검색어로 검색해 주세요.";


    private ConsolePanel() {
        super();
        setEditable(true);
        setText("Made by 고려대학교 컴퓨터학과 (2015.12.30)");

        DefaultCaret caret = (DefaultCaret)getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        Border border = BorderFactory.createLineBorder(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    }

    public static void print(String str) {
        consolePanel.setText(consolePanel.getText() + "\n" + str);
        hightLight(hell, Color.RED);
        hightLight(no, Color.RED);
        MainFrame.getMainFrame().setVisible(true);
    }

    public static void hightLight(String pattern, Color color)
    {
        DefaultHighlighter.DefaultHighlightPainter myHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(color);

        JTextComponent textComp = consolePanel;
        try
        {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            // see I have updated now its not case sensitive
            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0)
            {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {
            print("BadLocationException");
        }
    }

}
