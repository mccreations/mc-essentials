package io.github.mccreations.workbenches.plugin;

import cloud.commandframework.arguments.standard.EnumArgument;
import cloud.commandframework.bukkit.parsers.PlayerArgument;
import io.github.mccreations.commons.Loader;
import io.github.mccreations.commons.command.CommandManager;
import io.github.mccreations.commons.utils.schedulers.Schedulers;
import org.bukkit.entity.Player;

public final class WorkbenchesLoader extends Loader {

    @Override
    protected void enable() {
        final CommandManager commandManager = this.injector.getInstance(CommandManager.class);

        for (final Workbench workbench : Workbench.values()) {
            final String name = workbench.name().toLowerCase().replace("_", "");
            commandManager.command(
                    commandManager.commandBuilder(name)
                            .permission(String.format("workbenches.%s", name))
                            .senderType(Player.class)
                            .handler(context -> Schedulers.server(context.getSender()).run(() -> workbench.opener().accept((Player) context.getSender())))
            );
        }

        commandManager.command(
                commandManager.commandBuilder("workbenches")
                        .permission("workbenches.admin")
                        .literal("open")
                        .argument(PlayerArgument.of("player"))
                        .argument(EnumArgument.of(Workbench.class, "workbench"))
                        .handler(context -> {
                            final Player player = context.get("player");
                            Schedulers.server(player).run(() -> context.<Workbench>get("workbench").opener().accept(player));
                        })
        );
    }
}
