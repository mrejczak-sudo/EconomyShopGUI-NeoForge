package me.gypopo.economyshopgui.shop;
import me.gypopo.economyshopgui.config.ConfigLoader;
import java.io.File;
import java.util.*;

public class ShopManager {
    private final Map<String, ShopModel> shops = new LinkedHashMap<>();

    public ShopManager(File modDir) {
        ConfigLoader loader = new ConfigLoader(modDir);
        List<Map<String,Object>> defs = loader.loadShopFiles("110-shops");
        int idx = 0;
        for (Map<String,Object> def : defs) {
            String id = (String)def.getOrDefault("id", "shop-" + (idx++));
            String title = (String)def.getOrDefault("title","Shop");
            ShopModel sm = new ShopModel(id, title);
            Object items = def.get("items");
            if (items instanceof List) {
                for (Object o : (List)items) {
                    if (!(o instanceof Map)) continue;
                    Map<String,Object> m = (Map)o;
                    ShopModel.ShopItem it = new ShopModel.ShopItem();
                    it.material = (String)m.getOrDefault("item","STONE");
                    it.amount = ((Number)m.getOrDefault("amount",1)).intValue();
                    it.buyPrice = ((Number)m.getOrDefault("buy",0)).doubleValue();
                    it.sellPrice = ((Number)m.getOrDefault("sell",0)).doubleValue();
                    it.raw = m;
                    it.slot = ((Number)m.getOrDefault("slot", sm.items.size())).intValue();
                    sm.items.add(it);
                }
            }
            shops.put(id, sm);
        }
    }

    public Collection<ShopModel> getShops() { return shops.values(); }
    public ShopModel getShop(String id) { return shops.get(id); }
}
