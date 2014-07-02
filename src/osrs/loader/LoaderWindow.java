package osrs.loader;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Magorium
 * Date: 7/2/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaderWindow extends JFrame {

    private Applet applet;

    public LoaderWindow() {
        setTitle("07 Loader By Magorium");

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
            applet.init();
            applet.start();
            applet.setLocation(0, 0);
            gamePanel.repaint();
            gamePanel.revalidate();
            gamePanel.add(applet, BorderLayout.CENTER);
            gamePanel.setVisible(true);
            gamePanel.setSize(getSize());
        } catch (Exception e) {

        }
    }
}
