package bg.softuni.mobilelele.model.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotEmpty(message = "Please enter username.")
    @Size(min = 2, max = 20, message = "Username should be between 2 and 20 characters long.")
    private String username;

    @NotEmpty(message = "Please enter first name.")
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 characters long.")
    private String firstName;

    @NotEmpty(message = "Please enter last name.")
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 characters long.")
    private String lastName;

    @NotEmpty(message = "Please enter password.")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters long.")
    private String password;


    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

}
