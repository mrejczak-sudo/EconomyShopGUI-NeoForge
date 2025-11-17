package me.gypopo.economyshopgui.economy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EconomyStorage {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type TYPE = new TypeToken<Map<UUID, Double>>() {}.getType();

    private final File file;
    private Map<UUID, Double> balances;

    public EconomyStorage(File dir) {
        this.file = new File(dir, "economydata.json");
        load();
    }

    private void load() {
        if (!file.exists()) {
            balances = new HashMap<>();
            save();
            return;
        }
        try (FileReader fr = new FileReader(file)) {
            balances = GSON.fromJson(fr, TYPE);
            if (balances == null) balances = new HashMap<>();
        } catch (IOException e) {
            balances = new HashMap<>();
        }
    }

    public synchronized void save() {
        try (FileWriter fw = new FileWriter(file)) {
            GSON.toJson(balances, fw);
        } catch (IOException ignored) {}
    }

    public synchronized double get(UUID uuid) {
        return balances.getOrDefault(uuid, 0.0);
    }

    public synchronized void set(UUID uuid, double value) {
        balances.put(uuid, value);
        save();
    }

    public synchronized void add(UUID uuid, double amount) {
        set(uuid, get(uuid) + amount);
    }

    public synchronized boolean withdraw(UUID uuid, double amount) {
        double current = get(uuid);
        if (current < amount) return false;
        set(uuid, current - amount);
        return true;
    }
}
