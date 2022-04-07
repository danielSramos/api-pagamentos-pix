package br.com.api.pixAPI.controller.dto;

public class NewTransaction {

    private Long receiverId;
    private Long sendId;
    private Double value;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
