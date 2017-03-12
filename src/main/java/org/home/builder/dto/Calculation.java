
package org.home.builder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operation",
    "dividend",
    "divisor"
})
public class Calculation {

    @JsonProperty("operation")
    private String operation;
    @JsonProperty("dividend")
    private Dividend dividend;
    @JsonProperty("divisor")
    private Divisor divisor;

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Calculation withOperation(String operation) {
        this.operation = operation;
        return this;
    }

    @JsonProperty("dividend")
    public Dividend getDividend() {
        return dividend;
    }

    @JsonProperty("dividend")
    public void setDividend(Dividend dividend) {
        this.dividend = dividend;
    }

    public Calculation withDividend(Dividend dividend) {
        this.dividend = dividend;
        return this;
    }

    @JsonProperty("divisor")
    public Divisor getDivisor() {
        return divisor;
    }

    @JsonProperty("divisor")
    public void setDivisor(Divisor divisor) {
        this.divisor = divisor;
    }

    public Calculation withDivisor(Divisor divisor) {
        this.divisor = divisor;
        return this;
    }

}
