package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Profissional {
    @JsonProperty("Ana")
    ANA_CLARA,
    @JsonProperty("Beatriz")
    BEATRIZ_SOUZA,
    @JsonProperty("Carla")
    CARLA_MENDES,
    @JsonProperty("Qualquer")
    QUALQUER_PROFISSIONAL
}
