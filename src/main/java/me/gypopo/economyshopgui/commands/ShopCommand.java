package me.gypopo.economyshopgui.commands;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;
import static net.minecraft.commands.Commands.literal;
import com.mojang.brigadier.arguments.StringArgumentType;
import static net.minecraft.commands.Commands.argument;
import me.gypopo.economyshopgui.EconomyShopGUIMod;
import me.gypopo.economyshopgui.shop.ShopManager;

public class ShopCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(literal("shop")
            .executes(ctx -> {
                CommandSourceStack src = ctx.getSource();
                if (src.getEntity() instanceof ServerPlayer player) {
                    ShopManager sm = EconomyShopGUIMod.getShopManager();
                    if (sm.getShops().iterator().hasNext()) {
                        player.openMenu(new me.gypopo.economyshopgui.shop.ShopMenuProvider(sm.getShops().iterator().next().id));
                    }
                }
                return 1;
            })
            .then(argument("id", StringArgumentType.word()).executes(ctx -> {
                CommandSourceStack src = ctx.getSource();
                String id = StringArgumentType.getString(ctx, "id");
                if (src.getEntity() instanceof ServerPlayer player) {
                    ShopManager sm = EconomyShopGUIMod.getShopManager();
                    player.openMenu(new me.gypopo.economyshopgui.shop.ShopMenuProvider(id));
                }
                return 1;
            }))
        );
    }
}
