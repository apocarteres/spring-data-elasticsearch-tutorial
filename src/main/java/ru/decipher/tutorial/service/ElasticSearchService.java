package ru.decipher.tutorial.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;
import ru.decipher.tutorial.bean.BusinessDocument;
import ru.decipher.tutorial.bean.ElasticBusinessDocument;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Service
/**
 * Allows to interact with ElasticSearch.
 */
public final class ElasticSearchService {
    @Autowired
    private ElasticsearchTemplate template;

    private static final Logger LOG = Logger.getLogger(ElasticSearchService.class);

    /**
     * Indexes bunch of documents.
     */
    public void index(Collection<BusinessDocument> documents) {
        template.bulkIndex(
                documents.stream()
                        .map(ElasticBusinessDocument::new)
                        .map(doc -> new IndexQueryBuilder()
                                .withId(doc.getId())
                                .withObject(doc).build())
                        .collect(toList())
        );
        LOG.info(
                String.format("successfully indexed %d documents", documents.size())
        );
    }

}
