package io.github.mccreations.warps.plugin.command;

import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import com.google.inject.Inject;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.commons.container.CommandContainer;
import io.github.mccreations.warps.plugin.config.Messages;
import io.github.mccreations.warps.plugin.warp.WarpsServiceImpl;
import org.bukkit.command.CommandSender;

@CommandContainer
public final class ReloadCommand {

    private final ConfigManager configManager;
    private final WarpsServiceImpl warpsService;

    @Inject
    public ReloadCommand(final ConfigManager configManager, final WarpsServiceImpl warpsService) {
        this.configManager = configManager;
        this.warpsService = warpsService;
    }

    @CommandMethod("warps reload")
    @CommandPermission("warps.admin")
    private void reload(final CommandSender sender) {
        this.configManager.reload();
        this.warpsService.init();
        this.configManager.get(Messages.class).message(sender, "admin.reloaded");
    }
}
