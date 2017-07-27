package org.launchcode.mybestfriend.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LogInForm {

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{8,15}", message = "Usernames must be between 8-15 characters, consisting of only numbers, letters, and the _ or - characters")
    private String username;

    @NotNull
    @Pattern(regexp = "(\\S){4,20}", message = "Password must have 4-20 characters")
    private String password;

    public LogInForm(){}

    public String LogInForm(String username){
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
