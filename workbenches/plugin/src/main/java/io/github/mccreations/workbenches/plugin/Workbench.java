package io.github.mccreations.workbenches.plugin;

import org.bukkit.entity.Player;

import java.util.function.Consumer;

public enum Workbench {

    ANVIL(player -> player.openAnvil(null, true)),
    CARTOGRAPHY_TABLE(player -> player.openCartographyTable(null, true)),
    CRAFTING_TABLE(player -> player.openWorkbench(null, true)),
    ENCHANTING_TABLE(player -> player.openEnchanting(null, true)),
    GRINDSTONE(player -> player.openGrindstone(null, true)),
    LOOM(player -> player.openLoom(null, true)),
    SMITHING_TABLE(player -> player.openSmithingTable(null, true)),
    STONECUTTER(player -> player.openStonecutter(null, true));

    private final Consumer<Player> opener;

    Workbench(final Consumer<Player> opener) {
        this.opener = opener;
    }

    public Consumer<Player> opener() {
        return this.opener;
    }
}
