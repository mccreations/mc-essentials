package io.github.mccreations.warps.plugin.warp;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.github.mccreations.commons.config.ConfigManager;
import io.github.mccreations.warps.api.warp.Warp;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.config.Warps;

import java.util.HashMap;
import java.util.Map;

@Singleton
public final class WarpsServiceImpl implements WarpsService {

    private final Map<String, Warp> warps = new HashMap<>();
    private final ConfigManager configManager;

    @Inject
    public WarpsServiceImpl(final ConfigManager configManager) {
        this.configManager = configManager;
        this.init();
    }

    public void init() {
        this.warps.clear();
        this.configManager.get(Warps.class).warps().forEach(warp -> this.warps.put(warp.id(), warp));
    }

    @Override
    public void registerWarp(final Warp warp, final boolean persist) {
        this.warps.put(warp.id(), warp);

        if (persist) {
            final Warps warps = this.configManager.get(Warps.class);
            warps.warps().add(new WarpImpl(warp.id(), warp.permission(), warp.position()));
            this.configManager.save(warps);
        }
    }

    @Override
    public Warp unregisterWarp(final String id, final boolean persist) {
        if (persist) {
            final Warps warps = this.configManager.get(Warps.class);
            warps.warps().removeIf(warp -> warp.id().equals(id));
            this.configManager.save(warps);
        }

        return this.warps.remove(id);
    }

    @Override
    public Map<String, Warp> warps() {
        return Map.copyOf(this.warps);
    }
}
