package br.com.api.pixAPI.controller.dto;

public class Transference {

    private Long receiverPixKey;
    private Double value;

    public Long getReceiverPixKey() {
        return receiverPixKey;
    }

    public void setReceiverPixKey(Long receiverPixKey) {
        this.receiverPixKey = receiverPixKey;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
