package osrs.loader;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class LoaderWindow extends JFrame {

    private Applet applet;

    public LoaderWindow() {
        setTitle("OSRS Loader By Hiasat");
        setResizable(false);
        setSize(762, 533);
        Container contentPanel = getContentPane();
        contentPanel.setLayout(new BorderLayout());
        JPanel gamePanel = new JPanel();
        contentPanel.add(gamePanel);
        try {
            Class<?> c = Storage.getJarLoader().loadClass("client");
            applet = (Applet) c.newInstance();
            applet.setStub(Storage.getJarLoader().getAppleStub());
            applet.setSize(762, 533);
            applet.init();
            applet.start();
            applet.setLocation(0, 0);
            gamePanel.repaint();
            gamePanel.revalidate();
            gamePanel.add(applet, BorderLayout.CENTER);
            gamePanel.setVisible(true);
            gamePanel.setSize(getSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
