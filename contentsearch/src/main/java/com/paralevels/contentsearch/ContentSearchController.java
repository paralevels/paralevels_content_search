package com.paralevels.contentsearch;

import com.paralevels.contentsearch.solr.SolrService;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentSearchController {
    
    @Autowired
    private SolrService solrService;

    @GetMapping("/search")
    public ContentSearchResponse search(
        @RequestParam String query,
        @RequestParam(required = false, defaultValue = "*") String cursorMark
    ) throws Exception {
	QueryResponse solrResponse = solrService.search(query, cursorMark);
	ContentSearchResponse response = new ContentSearchResponse(solrResponse, cursorMark);
	return response;
    }
}
