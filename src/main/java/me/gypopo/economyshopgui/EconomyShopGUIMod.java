package me.gypopo.economyshopgui;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.server.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import me.gypopo.economyshopgui.economy.EconomyStorage;
import me.gypopo.economyshopgui.economy.JsonEconomyBridge;
import me.gypopo.economyshopgui.vault.VaultService;
import java.io.File;
import me.gypopo.economyshopgui.shop.ShopManager;

@Mod(EconomyShopGUIMod.MODID)
public class EconomyShopGUIMod {
    public static final String MODID = "economyshopgui";
    public static EconomyBridge economy;
    private static ShopManager shopManager;

    public EconomyShopGUIMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);

        File dir = new File("./economyshopgui");
        if (!dir.exists()) dir.mkdirs();

        EconomyStorage storage = new EconomyStorage(dir);
        economy = new JsonEconomyBridge(storage);
        VaultService.register();

        shopManager = new ShopManager(dir);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // common setup
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        me.gypopo.economyshopgui.commands.ShopCommand.register(event.getDispatcher());
        me.gypopo.economyshopgui.commands.CommandRegistrar.register(event.getDispatcher());
    }

    public static ShopManager getShopManager() {
        return shopManager;
    }

    public static void reloadConfigs() {
        shopManager = new ShopManager(new File("./economyshopgui"));
    }
}
