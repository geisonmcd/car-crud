package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CardLayoutExample {
    JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    JMenu mnuPanels = new JMenu("Panels");
    JMenuItem mniFirstPanel = new JMenuItem("First panel");
    JMenuItem mniSecondPanel = new JMenuItem("Second panel");
    JPanel panel = new JPanel();
    JPanel pnlFirst = new JPanel();
    JPanel pnlSecond = new JPanel();
    CardLayout cardLayout = new CardLayout();

    public CardLayoutExample() {
        panel.setLayout(cardLayout);
        pnlFirst.add(new JLabel("This is first panel"));
        pnlSecond.add(new JLabel("This is second panel"));
        //Add panels and set constraints.
        panel.add(pnlFirst, "pnlFirst");
        panel.add(pnlSecond, "pnlSecond");
        //Shows first layout on startup of application.
        /*Pass parent container (where you set CardLayout) and
        * constraint of panel you would like to show.
        * */
        cardLayout.show(panel, "pnlFirst");
        //Add menu and menu items.
        menuBar.add(mnuPanels);
        mnuPanels.add(mniFirstPanel);
        mnuPanels.add(mniSecondPanel);

        mniFirstPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Shows pnlFirst
                cardLayout.show(panel, "pnlFirst");
            }
        });

        mniSecondPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Shows pnlSecond
                cardLayout.show(panel, "pnlSecond");
            }
        });

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardLayoutExample();
            }
        });
    }

}