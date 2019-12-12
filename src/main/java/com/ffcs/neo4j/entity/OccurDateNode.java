package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "OccurDate")
public class OccurDateNode {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String date;

    @Labels
    private Set<String> labels = new HashSet<>();

    public void addLabel(String label) {
        if (!StringUtils.isEmpty(label)) {
            this.labels.add(label);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "OccurDateNode{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", labels=" + labels +
                '}';
    }
}
