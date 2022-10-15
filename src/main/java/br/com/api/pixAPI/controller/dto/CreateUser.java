package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateUser {

    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User toUser() {
        User user = new User();

        user.setName(this.name);
        user.setEmail(this.email);
        user.setPhone(this.phone);

        return user;
    }
}
