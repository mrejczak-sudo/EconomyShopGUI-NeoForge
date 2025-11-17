package me.gypopo.economyshopgui.client;
import me.gypopo.economyshopgui.shop.ShopMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;

public class ShopScreen extends AbstractContainerScreen<ShopMenu> {
    private static final ResourceLocation BG = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");

    public ShopScreen(ShopMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics gfx, float partial, int mx, int my) {
        gfx.blit(BG, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
