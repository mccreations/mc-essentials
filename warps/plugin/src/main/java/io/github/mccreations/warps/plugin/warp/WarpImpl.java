package io.github.mccreations.warps.plugin.warp;

import io.github.mccreations.commons.utils.FinePosition;
import io.github.mccreations.warps.api.warp.Warp;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
public record WarpImpl(String id, @Nullable String permission, FinePosition position) implements Warp {
}
