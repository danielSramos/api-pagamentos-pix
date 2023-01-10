package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UpdateUser {

    private String name;
    @Email(message = "{email.not.valid}")
    private String email;
    private String phone;

    public User toUser(User user) {
        if (this.name !=null) user.setName(this.name);
        if (this.email !=null) user.setEmail(this.email);
        if (this.phone !=null) user.setPhone(this.phone);
        return user;
    }

}
