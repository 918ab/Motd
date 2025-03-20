package Motd.impl;


import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class MotdProfileimpl implements PlayerProfile {
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
        return null;
    }

    @Override
    public @NotNull String setName(@Nullable String name) {
        return null;
    }


    @Override
    public @Nullable UUID getId() {
        return null;
    }

    @Override
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

    @Override
    public @NotNull Set<ProfileProperty> getProperties() {
        return null;
    }

    @Override
    public boolean hasProperty(@Nullable String property) {
        return false;
    }

    @Override
    public void setProperty(@NotNull ProfileProperty property) {

    }

    @Override
    public void setProperties(@NotNull Collection<ProfileProperty> properties) {

    }

    @Override
    public boolean removeProperty(@Nullable String property) {
        return false;
    }

    @Override
    public void clearProperties() {

    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean completeFromCache() {
        return false;
    }

    @Override
    public boolean completeFromCache(boolean onlineMode) {
        return false;
    }

    @Override
    public boolean completeFromCache(boolean lookupUUID, boolean onlineMode) {
        return false;
    }

    @Override
    public boolean complete(boolean textures) {
        return false;
    }

    @Override
    public boolean complete(boolean textures, boolean onlineMode) {
        return false;
    }

    @Override
    public @NotNull CompletableFuture<PlayerProfile> update() {
        return null;
    }

    @Override
    public org.bukkit.profile.@NotNull PlayerProfile clone() {
        return null;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return null;
    }
}
