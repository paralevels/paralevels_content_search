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

    private SolrQuery getQuery(String luceneQuery) {
        SolrQuery query = new SolrQuery();
        return query.setQuery(luceneQuery);
    }

    private List<SolrDocument> getResponse(SolrQuery query) throws Exception {
        QueryResponse response = solrClient.query(query);
        return response.getBeans(SolrDocument.class);
    }

    /*
     * Base search function requires both field names and search keywords in
     * the searchTerm argument like (labels:keyword captions:keyword).
     */
    public List<SolrDocument> search(String searchTerm) throws Exception {
        SolrQuery query = this.getQuery(searchTerm);
        return this.getResponse(query);
    }

    /*
     * Search image labels only.
     */
    public List<SolrDocument> searchLabels(String searchTerm) throws Exception {
        SolrQuery query = this.getQuery("labels:" + searchTerm);
        return this.getResponse(query);
    }
    
    /*
     * Search image captions only.
     */
    public List<SolrDocument> searchCaptions(String searchTerm) throws Exception {
        SolrQuery query = this.getQuery("captions:" + searchTerm);
        return this.getResponse(query);
    }

    /*
     * Search image tags only. Tags are words that are not related to
     * the objects in the image.
     */
    public List<SolrDocument> searchTags(String searchTerm) throws Exception {
        SolrQuery query = this.getQuery("tags:" + searchTerm);
        return this.getResponse(query);
    }
}
