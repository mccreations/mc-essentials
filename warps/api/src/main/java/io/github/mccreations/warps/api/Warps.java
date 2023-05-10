package io.github.mccreations.warps.api;

import io.github.mccreations.commons.event.EventService;
import io.github.mccreations.commons.utils.position.FinePosition;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Warps API
 *
 * <p> Obtain an instance of this using {@link WarpsProvider#get()}
 */
public interface Warps {

    WarpsService warpService();

    EventService eventService();

    Warp warp(final String id, final @Nullable String permission, final FinePosition position);
}
