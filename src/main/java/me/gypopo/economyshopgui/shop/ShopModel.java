package me.gypopo.economyshopgui.shop;
import java.util.*;

public class ShopModel {
    public final String id;
    public final String title;
    public final List<ShopItem> items = new ArrayList<>();

    public ShopModel(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public static class ShopItem {
        public String material;
        public int amount;
        public double buyPrice;
        public double sellPrice;
        public int slot;
        public Map<String,Object> raw;
    }
}
