package net.milkbowl.vault.economy;

public interface Economy {
    boolean isEnabled();
    String getName();
    boolean hasAccount(String playerName);
    double getBalance(String playerName);
    EconomyResponse withdrawPlayer(String playerName, double amount);
    EconomyResponse depositPlayer(String playerName, double amount);
    String format(double amount);
    boolean createPlayerAccount(String playerName);
}
