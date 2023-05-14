package io.github.mccreations.warps.api.warp;

import io.github.mccreations.commons.utils.Placeholdered;
import io.github.mccreations.commons.utils.FinePosition;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/**
 * A warp
 */
public interface Warp extends Placeholdered {

    /**
     * @return the unique id of the warp
     */
    String id();

    /**
     * @return the required permission to use the warp. if null, no permission is required
     */
    @Nullable
    String permission();

    /**
     * @return the position of this warp
     */
    FinePosition position();

    @Override
    default TagResolver[] placeholders(final @Nullable Audience context) {
        return new TagResolver[] {
                Placeholder.unparsed("id", this.id()),
                Placeholder.unparsed("permission", Objects.requireNonNullElse(this.permission(), "null")),
                TagResolver.resolver(this.position().placeholders(context))
        };
    }
}
