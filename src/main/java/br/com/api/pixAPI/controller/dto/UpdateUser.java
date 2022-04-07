package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.User;
import javax.validation.constraints.Email;

public class UpdateUser {

    private Long userId;
    private String name;
    @Email(message = "{email.not.valid}")
    private String email;
    private String phone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public User toUser(User user) {

        if (this.name !=null) user.setName(this.name);
        if (this.email !=null) user.setEmail(this.email);
        if (this.phone !=null) user.setPhone(this.phone);

        return user;
    }
}
