package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.Transaction;

public class Transference {

    private Long sendId;
    private Long receiverPixKey;
    private Double value;

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
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
