package com.paralevels.contentsearch.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolrService {

    @Autowired
    private SolrClient solrClient;

    private SolrQuery getQuery(String luceneQuery, String cursorMark) {
        SolrQuery query = new SolrQuery();
        query.setQuery(luceneQuery);
        query.set("cursorMark", cursorMark);
        query.setRows(100);
        query.setSort("id", SolrQuery.ORDER.asc);
        return query;
    }

    /*
     * Base search function requires both field names and search keywords in
     * the searchTerm argument like (labels:keyword captions:keyword).
     */
    public QueryResponse search(String searchTerm, String cursorMark) throws Exception {
        SolrQuery query = this.getQuery(searchTerm, cursorMark);
        return solrClient.query(query);
    }

    /*
     * Search image labels only.
     */
    public QueryResponse searchLabels(String searchTerm, String cursorMark) throws Exception {
        SolrQuery query = this.getQuery("labels:" + searchTerm, cursorMark);
        return solrClient.query(query);
    }
    
    /*
     * Search image captions only.
     */
    public QueryResponse searchCaptions(String searchTerm, String cursorMark) throws Exception {
        SolrQuery query = this.getQuery("captions:" + searchTerm, cursorMark);
        return solrClient.query(query);
    }

    /*
     * Search image tags only. Tags are words that are not related to
     * the objects in the image.
     */
    public QueryResponse searchTags(String searchTerm, String cursorMark) throws Exception {
        SolrQuery query = this.getQuery("tags:" + searchTerm, cursorMark);
        return solrClient.query(query);
    }
}
