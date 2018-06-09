package osrs.loader;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class RsJarLoader extends ClassLoader {


    private Hashtable<String, byte[]> entries;
    private RsAppleStub appleStub;
    private String gamepackUrl;

    public RsJarLoader() {
        appleStub = new RsAppleStub();
        entries = new Hashtable<String, byte[]>();
        gamepackUrl = appleStub.getLink() + appleStub.getParameter("initial_jar");
        loadJar();
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) {
        try {
            if(entries.containsKey(name)){
                byte[] value = entries.get(name);
                return defineClass(name, value, 0, value.length);
            }
            return super.loadClass(name, resolve);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public RsAppleStub getAppleStub(){
        return appleStub;
    }

    private void loadJar() {
        try {
           JarInputStream jis = new JarInputStream(new URL(gamepackUrl).openStream());
            JarEntry entry;
            while ((entry = jis.getNextJarEntry()) != null) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int read;
                while ((read = jis.read(data, 0, 1024)) > 0) {
                    bos.write(data, 0, read);
                }
                entries.put(entry.getName().replace(".class", ""), bos.toByteArray());
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
