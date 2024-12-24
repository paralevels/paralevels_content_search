package com.paralevels.contentsearch;

import com.paralevels.contentsearch.solr.SolrDocument;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.List;

class ContentSearchResponse {
    private List<SolrDocument> searchResults;
    private String nextCursorMark;
    private boolean hasMore;

    public ContentSearchResponse(QueryResponse solrQueryResponse, String currentCursorMark) {
        this.searchResults = solrQueryResponse.getBeans(SolrDocument.class);
        this.nextCursorMark = solrQueryResponse.getNextCursorMark();
        this.hasMore = !this.nextCursorMark.equals(currentCursorMark);
    }

    // Getters and setters are required by Java Spring framework.
    public List<SolrDocument> getSearchResults() {
        return searchResults;
    }

    public void setSolrDocuments(List<SolrDocument> solrDocuments) {
        this.searchResults = solrDocuments;
    }

    public String getNextCursorMark() {
        return nextCursorMark;
    }

    public void setNextCursorMark(String nextCursorMark) {
        this.nextCursorMark = nextCursorMark;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
