package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.PixKey;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreatePixKey {

    @NotNull(message = "{key.not.null}")
    private Long key;
    @NotNull(message = "{userId.not.null}")
    private Long userId;

    public PixKey toPixKey() {
        PixKey pixKey = new PixKey();
        pixKey.setPixKey(this.key);
        return pixKey;
    }

}
