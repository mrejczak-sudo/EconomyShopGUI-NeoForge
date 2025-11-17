package me.gypopo.economyshopgui.vault;

import net.milkbowl.vault.economy.Economy;
import me.gypopo.economyshopgui.EconomyShopGUIMod;

public class VaultService {
    private static Economy instance;

    public static void register() {
        if (instance == null) instance = new VaultForgeBridge();
    }

    public static Economy get() {
        if (instance == null) register();
        return instance;
    }
}
