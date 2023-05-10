package io.github.mccreations.warps.api;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.ApiStatus;

public final class WarpsProvider {

    private static Warps instance = null;

    public static Warps get() {
        if (WarpsProvider.instance == null) {
            throw new IllegalStateException("Warps has not been initialized yet.");
        }

        return WarpsProvider.instance;
    }

    @ApiStatus.Internal
    public static void set(final @Nullable Warps instance) {
        WarpsProvider.instance = instance;
    }
}
