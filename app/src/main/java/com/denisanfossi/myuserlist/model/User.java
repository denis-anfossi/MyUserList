package com.denisanfossi.myuserlist.model;

import androidx.annotation.Nullable;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String avatarUrl;

    public User(Long id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        return (((User) obj).avatarUrl.equals(this.avatarUrl) && ((User) obj).name.equals(this.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, avatarUrl);
    }
}
