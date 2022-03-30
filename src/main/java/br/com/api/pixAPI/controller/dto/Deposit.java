package br.com.api.pixAPI.controller.dto;

public class Deposit {
    private Long userId;
    private Double value;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
