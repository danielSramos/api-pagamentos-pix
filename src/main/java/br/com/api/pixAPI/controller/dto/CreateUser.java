package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateUser {

    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;
    private String phone;

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPhone(this.phone);
        return user;
    }
}
