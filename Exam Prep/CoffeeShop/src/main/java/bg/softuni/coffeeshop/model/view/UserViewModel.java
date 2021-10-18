package bg.softuni.coffeeshop.model.view;

import java.util.List;

public class UserViewModel {

    private String username;
    private List<OrderViewModel> orders;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<OrderViewModel> getOrders() {
        return orders;
    }

    public UserViewModel setOrders(List<OrderViewModel> orders) {
        this.orders = orders;
        return this;
    }
}
