package io.github.mccreations.warps.api.warp;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

/**
 * A service that manages warps.
 */
public interface WarpsService {

    /**
     * Register a warp. This will overwrite any warp with the same id.
     *
     * @param warp the warp
     * @param persist whether to persist the warp
     */
    void registerWarp(final Warp warp, final boolean persist);

    /**
     * Unregister a warp.
     *
     * @param id the id of the warp
     * @param persist whether to persist the warp
     * @return the warp that was unregistered, or null if it didn't exist
     */
    @Nullable
    Warp unregisterWarp(final String id, final boolean persist);

    /**
     * @return immutable copy of the registered warps
     */
    Map<String, Warp> warps();
}
