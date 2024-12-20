package com.paralevels.contentsearch.solr;

import org.apache.solr.client.solrj.beans.Field;
import java.util.List;

public class SolrDocument {

    @Field
    private String id;

    @Field
    private String dataset;

    @Field
    private String filepath;
    
    @Field
    private List<String> captions;

    @Field
    private List<String> labels;

    @Field
    private List<String> tags;

    // Getters and setters
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataset() {
        return this.dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public List<String> getCaptions() {
        return this.captions;
    }

    public void setCaptions(List<String> captions) {
        this.captions = captions;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
