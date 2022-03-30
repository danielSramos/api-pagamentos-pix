package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.Transaction;

public class Transference {

    private Long sendPixKey;
    private Long receiverPixKey;
    private Double value;

    public Long getSendPixKey() {
        return sendPixKey;
    }

    public void setSendPixKey(Long sendPixKey) {
        this.sendPixKey = sendPixKey;
    }

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
