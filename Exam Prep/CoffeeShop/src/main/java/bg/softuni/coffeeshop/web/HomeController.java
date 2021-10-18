package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.view.OrderViewModel;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.service.UserService;
import bg.softuni.coffeeshop.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public HomeController(OrderService orderService, UserService userService, CurrentUser currentUser) {
        this.orderService = orderService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllOrdersByPriceDesc();
        int totalTime = orders
                .stream()
                .map(o -> o.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0);


        model.addAttribute("totalTime", totalTime);
        model.addAttribute("orders", orders);
        model.addAttribute("users", userService.findAllUsersByCountOfOrdersDesc());

        return "home";
    }
}
