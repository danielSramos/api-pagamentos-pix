package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.PixKey;

import javax.validation.constraints.NotNull;

public class CreatePixKey {

    @NotNull(message = "{key.not.null}")
    private Long key;
    @NotNull(message = "{userId.not.null}")
    private Long userId;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PixKey toPixKey() {
        PixKey pixKey = new PixKey();
        pixKey.setPixKey(this.key);
        return pixKey;
    }
}
