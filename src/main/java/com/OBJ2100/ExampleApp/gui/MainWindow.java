package com.OBJ2100.ExampleApp.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class MainWindow extends JFrame {

    private ApplicationMenu appMenu = new ApplicationMenu();
    private MainContent content = new MainContent();

    public MainWindow() {
        setTitle("Example application");

        // Set the preferred size of the JFrame
        setPreferredSize(new Dimension(1000, 900));

        setLayout(new BorderLayout());

        // Add content panel to the center of the frame
        add(content, BorderLayout.CENTER);

        // Add main menu
        setJMenuBar(appMenu);

        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        // Center the window on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
        });
    }
}