package osrs.loader;

/**
 * Created with IntelliJ IDEA.
 * User: Magorium
 * Date: 7/2/14
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Boot {

    public static void main(String[] args){
        Storage.setJarLoader(new RsJarLoader());
        LoaderWindow loaderWindow = new LoaderWindow();
        loaderWindow.setVisible(true);
    }
}
