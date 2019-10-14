package com.mobiquity.travelapi.integrations.nsclient.responsemodel;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter

@JsonIgnoreProperties(ignoreUnknown = true)
class Route {
    @JsonAlias("plannedDurationInMinutes")
    private Integer plannedDuration;
    private Integer transfer;
    private List<Leg> legs;

}
