package Motd.impl;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public final class MotdProfileimpl implements PlayerProfile {
    private String name;
    public MotdProfileimpl(String name) {
        this.name = name;
    }

    @Override
    public @Nullable UUID getUniqueId() {
        return null;
    }

    @Override
    public @Nullable String getName() {
        return name;
    }


    public @NotNull String setName(@Nullable String name) {
        String previous = this.name;
        this.name = name;
        return previous;
    }

    public @Nullable UUID getId() {
        return null;
    }

    public @Nullable UUID setId(@Nullable UUID uuid) {
        return null;
    }

    @Override
    public @NotNull PlayerTextures getTextures() {
        return null;
    }

    @Override
    public void setTextures(@Nullable PlayerTextures textures) {

    }

    public @NotNull Set<ProfileProperty> getProperties() {
        return new HashSet();
    }

    public boolean hasProperty(@Nullable String property) {
        return false;
    }

    public void setProperty(@NotNull ProfileProperty property) {
    }

    public void setProperties(@NotNull Collection<ProfileProperty> properties) {
    }

    public boolean removeProperty(@Nullable String property) {
        return false;
    }

    public void clearProperties() {
    }

    public boolean isComplete() {
        return false;
    }

    @Override
    public @NotNull CompletableFuture<org.bukkit.profile.PlayerProfile> update() {
        return null;
    }

    @Override
    public org.bukkit.profile.@NotNull PlayerProfile clone() {
        return null;
    }


    public boolean completeFromCache() {
        return false;
    }

    public boolean completeFromCache(boolean onlineMode) {
        return false;
    }

    public boolean completeFromCache(boolean lookupUUID, boolean onlineMode) {
        return false;
    }

    public boolean complete(boolean textures) {
        return false;
    }

    public boolean complete(boolean textures, boolean onlineMode) {
        return false;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return null;
    }
}
