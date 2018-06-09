package osrs.loader;


public class Boot {

    public static void main(String[] args){
        Storage.setJarLoader(new RsJarLoader());
        LoaderWindow loaderWindow = new LoaderWindow();
        loaderWindow.setVisible(true);
    }
}
