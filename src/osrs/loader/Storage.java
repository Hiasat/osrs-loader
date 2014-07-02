package osrs.loader;

/**
 * Created with IntelliJ IDEA.
 * User: Magorium
 * Date: 7/2/14
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Storage {

    private static RsJarLoader jarLoader;

    public static RsJarLoader getJarLoader(){
        return jarLoader;
    }
    public static void setJarLoader(RsJarLoader jarLoader){
        Storage.jarLoader = jarLoader;
    }
}
