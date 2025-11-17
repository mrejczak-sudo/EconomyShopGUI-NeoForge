package me.gypopo.economyshopgui.vault;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import me.gypopo.economyshopgui.EconomyShopGUIMod;
import me.gypopo.economyshopgui.EconomyBridge;
import net.minecraft.world.entity.player.Player;
import java.util.UUID;
import java.util.Optional;

public class VaultForgeBridge implements Economy {

    private final EconomyBridge bridge;

    public VaultForgeBridge() {
        this.bridge = EconomyShopGUIMod.economy;
    }

    @Override
    public boolean isEnabled() { return bridge != null; }

    @Override
    public String getName() { return "Vault-Forge-Compat"; }

    @Override
    public boolean hasAccount(String playerName) { return true; }

    @Override
    public double getBalance(String playerName) {
        // Name-based lookup not implemented here.
        return 0.0;
    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, double amount) {
        return new EconomyResponse(0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Name-based operations not supported in this bridge");
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, double amount) {
        return new EconomyResponse(0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "Name-based operations not supported in this bridge");
    }

    @Override
    public String format(double amount) { return String.format("%.2f", amount); }

    @Override
    public boolean createPlayerAccount(String playerName) { return true; }
}
