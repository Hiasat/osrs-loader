package osrs.loader;


public class Storage {

    private static RsJarLoader jarLoader;

    public static RsJarLoader getJarLoader(){
        return jarLoader;
    }
    public static void setJarLoader(RsJarLoader jarLoader){
        Storage.jarLoader = jarLoader;
    }
}
