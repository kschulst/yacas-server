package no.udp.yacas.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Value;

@Value
public class UserId {
    @JsonValue
    private final String value;
}
