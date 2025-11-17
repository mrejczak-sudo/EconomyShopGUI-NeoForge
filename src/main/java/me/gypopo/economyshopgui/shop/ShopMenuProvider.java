package me.gypopo.economyshopgui.shop;
import net.minecraft.world.MenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import me.gypopo.economyshopgui.EconomyShopGUIMod;

public class ShopMenuProvider implements MenuProvider {
    private final String shopId;

    public ShopMenuProvider(String shopId) { this.shopId = shopId; }

    @Override
    public Component getDisplayName() {
        return Component.literal("Shop");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new ShopMenu(id, inv, EconomyShopGUIMod.getShopManager().getShop(shopId));
    }
}
