package io.github.mccreations.warps.plugin.command;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandMethod;
import com.google.inject.Inject;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.commons.container.CommandContainer;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.config.Messages;
import org.bukkit.command.CommandSender;

@CommandContainer
public final class DeleteWarpCommand {

    private final ConfigManager configManager;
    private final WarpsService warpsService;

    @Inject
    public DeleteWarpCommand(final ConfigManager configManager, final WarpsService warpsService) {
        this.configManager = configManager;
        this.warpsService = warpsService;
    }

    @CommandMethod("warps delete <warp>")
    private void delete(final CommandSender sender, final @Argument Warp warp) {
        this.warpsService.unregisterWarp(warp.id(), true);
        this.configManager.get(Messages.class).message(sender, "admin.deleted", warp.placeholders(null));
    }
}
