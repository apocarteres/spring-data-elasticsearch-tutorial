package ru.decipher.tutorial.bean;

import java.util.Date;

/**
 * Business POJO document which usually kept in database.
 */
public final class BusinessDocument {
    private final String id;
    private final String name;
    private final String url;
    private final Date published;
    private final int views;

    public BusinessDocument(
            String id,
            String name,
            String url,
            Date published,
            int views
    ) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.published = published;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getPublished() {
        return published;
    }

    public int getViews() {
        return views;
    }

    public String getUrl() {
        return url;
    }
}
