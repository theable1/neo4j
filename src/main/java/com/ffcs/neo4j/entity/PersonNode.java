package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Person")
public class PersonNode {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private Long featureId;
    @Property
    private String name;
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

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "id=" + id +
                ", featureId=" + featureId +
                ", name='" + name + '\'' +
                ", labels=" + labels +
                '}';
    }
}
