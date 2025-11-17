package me.gypopo.economyshopgui;

import net.minecraft.world.entity.player.Player;

public interface EconomyBridge {
    double getBalance(Player player);
    boolean withdraw(Player player, double amount);
    boolean deposit(Player player, double amount);
}
