package me.gypopo.economyshopgui.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ConfigLoader {
    private final File modDir;
    private Map<String,Object> mainConfig;

    public ConfigLoader(File modDir) {
        this.modDir = modDir;
        loadMainConfig();
    }

    private void loadMainConfig() {
        File cfg = new File(modDir, "config.yml");
        if (cfg.exists()) {
            try (InputStream is = new FileInputStream(cfg)) {
                Yaml y = new Yaml(new SafeConstructor());
                mainConfig = y.load(is);
            } catch (IOException e) { mainConfig = new HashMap<>(); }
            return;
        }
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.yml")) {
            if (is != null) {
                Yaml y = new Yaml(new SafeConstructor());
                mainConfig = y.load(is);
                return;
            }
        } catch (Exception ignored) {}
        mainConfig = new HashMap<>();
    }

    public Map<String,Object> getMainConfig() { return mainConfig; }

    public List<Map<String,Object>> loadShopFiles(String shopsFolder) {
        List<Map<String,Object>> shops = new ArrayList<>();
        File folder = new File(modDir, shopsFolder);
        if (folder.exists() && folder.isDirectory()) {
            for (File f : Objects.requireNonNull(folder.listFiles((d,n)->n.endsWith(".yml")))) {
                try (InputStream is = new FileInputStream(f)) {
                    Yaml y = new Yaml(new SafeConstructor());
                    Object obj = y.load(is);
                    if (obj instanceof Map) shops.add((Map<String,Object>)obj);
                } catch (IOException ignored) {}
            }
            return shops;
        }
        // fallback scanning classpath not implemented fully here
        return shops;
    }
}
