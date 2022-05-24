package com.trialdex.dex.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Orientation {
    @JsonProperty("Male")
    MALE,
    @JsonProperty("Female")
    FEMALE,
    @JsonProperty("Other")
    OTHER
}
