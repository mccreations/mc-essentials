package io.github.mccreations.warps.plugin;

import io.github.mccreations.commons.Loader;
import io.github.mccreations.commons.command.CommandManager;
import io.github.mccreations.commons.event.EventService;
import io.github.mccreations.commons.utils.position.FinePosition;
import io.github.mccreations.warps.api.Warps;
import io.github.mccreations.warps.api.WarpsProvider;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.command.argument.WarpArgument;
import io.github.mccreations.warps.plugin.inject.WarpsModule;
import io.github.mccreations.warps.plugin.warp.WarpImpl;
import io.github.mccreations.warps.plugin.warp.WarpsServiceImpl;
import io.leangen.geantyref.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WarpsLoader extends Loader implements Warps {

    public WarpsLoader() {
        super(new WarpsModule());
    }

    @Override
    protected void enable() {
        this.injector.getInstance(CommandManager.class).parserRegistry().registerParserSupplier(
                TypeToken.get(Warp.class),
                params -> this.injector.getInstance(WarpArgument.class)
        );

        WarpsProvider.set(this);
    }

    @Override
    protected void disable() {
        WarpsProvider.set(null);
    }

    @Override
    public WarpsService warpService() {
        return this.injector.getInstance(WarpsServiceImpl.class);
    }

    @Override
    public EventService eventService() {
        return this.injector.getInstance(EventService.class);
    }

    @Override
    public Warp warp(final String id, final @Nullable String permission, final FinePosition position) {
        return new WarpImpl(id, permission, position);
    }
}
