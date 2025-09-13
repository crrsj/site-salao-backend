package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Servico {
    @JsonProperty("Corte")
    CORTE_DE_CABELO,
    @JsonProperty("Manicure")
    MANICURE_PEDICURE,
    @JsonProperty("Maquiagem")
    MAQUIAGEM,
    @JsonProperty("Sobrancelha")
    SOBRANCELHA,
    @JsonProperty("Outros")
    OUTROS


}
