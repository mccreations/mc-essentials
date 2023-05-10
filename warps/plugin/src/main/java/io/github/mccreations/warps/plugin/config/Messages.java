package io.github.mccreations.warps.plugin.config;

import io.github.mccreations.commons.config.ConfigurableMessages;
import io.github.mccreations.commons.container.ConfigContainer;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.Locale;
import java.util.Map;

@ConfigContainer
@ConfigSerializable
public final class Messages implements ConfigurableMessages {

    private final Map<Locale, Map<String, String>> messages = Map.of(
            Locale.ENGLISH, Map.of(
                    "warps", ConfigurableMessages.builder().info().text("Warps: <warps>").build(),
                    "warped", ConfigurableMessages.builder().info().text("You have been warped to <id>").build(),
                    "admin.warped", ConfigurableMessages.builder().info().text("You warped <player> to <id>.").build(),
                    "admin.reloaded", ConfigurableMessages.builder().info().text("Warps has been reloaded.").build(),
                    "admin.setwarp", ConfigurableMessages.builder().info().text("You have set warp <id>.").build(),
                    "admin.deleted", ConfigurableMessages.builder().info().text("You have deleted <id>.").build()
            )
    );

    @Override
    public Map<Locale, Map<String, String>> messages() {
        return this.messages;
    }
}
