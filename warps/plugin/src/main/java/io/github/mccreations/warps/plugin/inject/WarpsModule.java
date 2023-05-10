package io.github.mccreations.warps.plugin.inject;

import com.google.inject.AbstractModule;
import io.github.mccreations.warps.api.warp.WarpsService;
import io.github.mccreations.warps.plugin.warp.WarpsServiceImpl;

public final class WarpsModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(WarpsService.class).to(WarpsServiceImpl.class);
    }
}
