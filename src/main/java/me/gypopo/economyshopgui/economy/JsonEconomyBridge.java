package me.gypopo.economyshopgui.economy;

import me.gypopo.economyshopgui.EconomyBridge;
import net.minecraft.world.entity.player.Player;
import java.util.UUID;

public class JsonEconomyBridge implements EconomyBridge {

    private final EconomyStorage storage;

    public JsonEconomyBridge(EconomyStorage storage) {
        this.storage = storage;
    }

    private UUID id(Player p) {
        return p.getUUID();
    }

    @Override
    public double getBalance(Player player) {
        return storage.get(id(player));
    }

    @Override
    public boolean withdraw(Player player, double amount) {
        return storage.withdraw(id(player), amount);
    }

    @Override
    public boolean deposit(Player player, double amount) {
        storage.add(id(player), amount);
        return true;
    }
}
