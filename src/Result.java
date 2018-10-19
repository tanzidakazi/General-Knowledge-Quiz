import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Result {
    JLabel resultlb;

    Result() {
        resultlb = new JLabel();
        resultlb.setForeground(Color.RED);
        resultlb.setFont(new Font("Italic", Font.BOLD, 18));
        resultlb.setBounds(50, 30, 300, 50);
    }
}
