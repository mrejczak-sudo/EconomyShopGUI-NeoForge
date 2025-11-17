package me.gypopo.economyshopgui.client;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import me.gypopo.economyshopgui.EconomyShopGUIMod;
import net.minecraft.client.gui.screens.MenuScreens;
import me.gypopo.economyshopgui.shop.ShopMenu;

@Mod.EventBusSubscriber(modid = EconomyShopGUIMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(EconomyShopGUIMod.SHOP_MENU, ShopScreen::new);
    }
}
