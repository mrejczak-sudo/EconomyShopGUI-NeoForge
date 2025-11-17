package me.gypopo.economyshopgui.shop;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ShopMenu extends AbstractContainerMenu {
    private final ShopModel shop;
    private final Container container = new SimpleContainer(27);

    // constructor used by MenuType#create
    public ShopMenu(int id, Inventory playerInventory, ShopModel shop) {
        super(null, id);
        this.shop = shop;
        for (ShopModel.ShopItem it : shop.items) {
            ItemStack stack = new ItemStack(Items.STONE, it.amount);
            container.setItem(it.slot, stack);
        }
    }

    @Override
    public boolean stillValid(Player player) { return true; }

    @Override
    public ItemStack quickMoveStack(Player player, int index) { return ItemStack.EMPTY; }
}
