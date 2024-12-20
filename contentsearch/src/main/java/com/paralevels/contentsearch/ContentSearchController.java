package com.paralevels.contentsearch;

import com.paralevels.contentsearch.solr.SolrService;
import com.paralevels.contentsearch.solr.SolrDocument;
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
    public List<SolrDocument> search(@RequestParam String query) throws Exception {
        return solrService.search(query);
    }
}
