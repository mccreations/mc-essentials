package io.github.mccreations.warps.plugin.command;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import com.google.inject.Inject;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.commons.container.CommandContainer;
import io.github.mccreations.commons.event.EventService;
import io.github.mccreations.warps.api.event.WarpEvent;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.plugin.config.Messages;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.event.PostResult;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandContainer
public final class WarpCommand {

    private final ConfigManager configManager;
    private final EventService eventService;

    @Inject
    public WarpCommand(final ConfigManager configManager, final EventService eventService) {
        this.configManager = configManager;
        this.eventService = eventService;
    }

    @CommandMethod("warp <warp>")
    @CommandPermission("warps.use")
    private void warp(final Player sender, final @Argument Warp warp) {
        final WarpEvent event = new WarpEvent(sender.getUniqueId(), warp);
        final PostResult result = this.eventService.emit(event);

        if (event.cancelled() || !result.wasSuccessful()) {
            return;
        }

        sender.teleportAsync(warp.position().toBukkit()).thenAccept(success -> {
            if (success) {
                this.configManager.get(Messages.class).message(sender, "warped", warp.placeholders(null));
            }
        });
    }

    @CommandMethod("warps warp <warp> <player>")
    @CommandPermission("warps.admin")
    private void warp(final CommandSender sender, final @Argument Warp warp, final @Argument Player player) {
        this.warp(player, warp);
        this.configManager.get(Messages.class).message(
                sender,
                "admin.warped",
                TagResolver.resolver(warp.placeholders(null)),
                Placeholder.unparsed("player", player.getName())
        );
    }
}
