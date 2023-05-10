package io.github.mccreations.warps.plugin.command;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import com.google.inject.Inject;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.commons.container.CommandContainer;
import io.github.mccreations.commons.utils.position.FinePosition;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.config.Messages;
import io.github.mccreations.warps.plugin.warp.WarpImpl;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.Nullable;

@CommandContainer
public final class SetWarpCommand {

    private final ConfigManager configManager;
    private final WarpsService warpsService;

    @Inject
    public SetWarpCommand(final ConfigManager configManager, final WarpsService warpsService) {
        this.configManager = configManager;
        this.warpsService = warpsService;
    }

    @CommandMethod("warps set <name> [permission] [location]")
    @CommandPermission("warps.admin")
    private void setWarp(final Player sender, final @Argument String name, final @Argument(defaultValue = "") String permission, @Nullable @Argument Location location) {
        if (location == null) {
            location = sender.getLocation();
        }

        final Warp warp = new WarpImpl(name, permission, new FinePosition(location));
        warpsService.registerWarp(warp, true);

        this.configManager.get(Messages.class).message(sender, "admin.setwarp", warp.placeholders(null));
    }
}
