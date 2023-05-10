package io.github.mccreations.warps.plugin.command;

import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import com.google.inject.Inject;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.commons.container.CommandContainer;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.config.Messages;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.command.CommandSender;

import java.util.Map;

@CommandContainer
public final class WarpsCommand {

    private final ConfigManager configManager;
    private final WarpsService warpsService;

    @Inject
    public WarpsCommand(final ConfigManager configManager, final WarpsService warpsService) {
        this.configManager = configManager;
        this.warpsService = warpsService;
    }

    @CommandMethod("warps")
    @CommandPermission("warps.use")
    private void warps(final CommandSender sender) {
        this.configManager.get(Messages.class).message(
                sender,
                "warps",
                Placeholder.unparsed("warps", String.join(
                        ", ",
                        this.warpsService.warps()
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue().permission() == null || sender.hasPermission(entry.getValue().permission()))
                                .map(Map.Entry::getKey)
                                .toList()
                ))
        );
    }
}
