package io.github.mccreations.warps.plugin.command.argument;

import com.google.inject.Inject;
import io.github.mccreations.commons.command.argument.ArgumentType;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import net.kyori.adventure.identity.Identity;

import java.util.Map;

public final class WarpArgument extends ArgumentType<Warp> {

    @Inject
    public WarpArgument(final WarpsService service) {
        super(
                (context, input) -> {
                    final Warp warp = service.warps().get(input);
                    if (warp == null) {
                        return null;
                    }

                    if (warp.permission() != null && !context.getSender().hasPermission(warp.permission())) {
                        return null;
                    }

                    return warp;
                },
                (context, input) -> service.warps()
                        .entrySet()
                        .stream()
                        .filter(it ->
                                context.getSender().get(Identity.UUID).map(uuid -> {
                                    final Warp warp = it.getValue();
                                    return warp.permission() == null || context.getSender().hasPermission(warp.permission());
                                }).orElse(false)
                        ).map(Map.Entry::getKey)
                        .toList()
        );
    }
}
