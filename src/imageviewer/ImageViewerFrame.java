/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author MAC
 */
public class ImageViewerFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFLAUT_WIDTH = 300;
    private static final int DEFLAUT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFLAUT_HEIGHT, DEFLAUT_WIDTH);
        // Uzycie etykiety do wyświetlania obrazów
        label = new JLabel();
        add(label);
//wybór obrazu
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
// pasek menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("otwórz");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int result = chooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                }

            }
        });
        JMenuItem exitItem = new JMenuItem("zakoncz");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

    }

}
