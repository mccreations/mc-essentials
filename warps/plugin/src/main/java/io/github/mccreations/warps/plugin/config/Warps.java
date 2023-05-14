package io.github.mccreations.warps.plugin.config;

import io.github.mccreations.commons.container.ConfigContainer;
import io.github.mccreations.commons.utils.FinePosition;
import io.github.mccreations.warps.plugin.warp.WarpImpl;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.List;

@ConfigContainer
@ConfigSerializable
public final class Warps {

    private final List<WarpImpl> warps = List.of(new WarpImpl("test-warp", "warps.admin", new FinePosition(0, 100, 0, 0, 0, "world")));

    public List<WarpImpl> warps() {
        return this.warps;
    }
}
