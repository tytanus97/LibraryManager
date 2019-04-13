package mainpack.crm.user;

import mainpack.validation.EmailValidator;
import mainpack.validation.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {


    @NotNull(message = "Username is required")
    @Size(min = 1, message = "Username is required")
    private String userName;

    @NotNull(message = "Password is required")
    @Size(min = 1, message = "Passowrd is required")
    private String password;

    @NotNull(message = "Password is required")
    @Size(min = 1, message = "Password is required")
    private String matchingPassword;

    @EmailValidator
    @NotNull(message = "Email is required")
    @Size(min = 1, message = "Email is required")
    private String email;

    public CrmUser() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
