package com.hxx.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity(label = "Date")
public class DateNode {
    @Id
    @GeneratedValue
    private Long id;

    private String date;
    @Relationship(type = "LATEST")
    private PersonNode person;

    @JsonIgnoreProperties("occurDate")
    @Relationship(type = "NEXT", direction = Relationship.INCOMING)
    private NextRelation next;

    @JsonIgnoreProperties("occurDate")
    @Relationship(type = "HANG", direction = Relationship.INCOMING)
    private List<HangRelation> hangs;
}
