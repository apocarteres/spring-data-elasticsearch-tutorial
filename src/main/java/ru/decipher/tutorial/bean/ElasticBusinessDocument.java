package ru.decipher.tutorial.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ElasticSearch representation of business document.
 * <p>
 * Essentially, allows to feed business document to
 * ElasticSearch effectively without modifying
 * original document.
 */
@Document(
        indexName = "business_document",
        type = "business_document",
        refreshInterval = "5s",

        /*
        can't be modified in future. Be careful on it.
        Depends on amount of documents. Please read ES docs to understand how to calc it right.
        */
        shards = 5,
        replicas = 0/*for fail-over purposes. */
)
public final class ElasticBusinessDocument {
    @Id
    public String id;

    @Field(type = FieldType.String)
    private final String name;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private final String url;

    @Field(type = FieldType.Long, index = FieldIndex.not_analyzed)
    private final long published;

    @Field(type = FieldType.Integer, index = FieldIndex.not_analyzed)
    private final int views;

    public ElasticBusinessDocument(
            BusinessDocument document
    ) {
        this.id = document.getId();
        this.url = document.getUrl();
        this.name = document.getName();
        this.published = document.getPublished().getTime();
        this.views = document.getViews();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public long getPublished() {
        return published;
    }

    public int getViews() {
        return views;
    }
}
