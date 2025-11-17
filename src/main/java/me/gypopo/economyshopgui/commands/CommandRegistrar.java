package me.gypopo.economyshopgui.commands;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import static net.minecraft.commands.Commands.literal;
import me.gypopo.economyshopgui.EconomyShopGUIMod;
import net.minecraft.network.chat.Component;

public class CommandRegistrar {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(literal("eshop")
            .then(literal("reload").executes(ctx -> {
                EconomyShopGUIMod.reloadConfigs();
                ctx.getSource().sendSuccess(() -> Component.literal("EconomyShopGUI: configs reloaded"), true);
                return 1;
            }))
        );
    }
}
