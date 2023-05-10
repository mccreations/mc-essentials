package io.github.mccreations.warps.api.event;

import io.github.mccreations.commons.event.Event;
import io.github.mccreations.warps.api.warp.Warp;
import net.kyori.event.Cancellable;

import java.util.UUID;

/**
 * Fired when a player attempts to use a warp
 */
public final class WarpEvent implements Cancellable, Event {

    private final UUID uuid;
    private final Warp warp;
    private boolean cancelled;

    public WarpEvent(final UUID uuid, final Warp warp) {
        this.uuid = uuid;
        this.warp = warp;
        this.cancelled = false;
    }

    /**
     * @return the user's uuid
     */
    public UUID uuid() {
        return this.uuid;
    }

    /**
     * @return the warp
     */
    public Warp warp() {
        return this.warp;
    }

    @Override
    public boolean cancelled() {
        return this.cancelled;
    }

    @Override
    public void cancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
}
