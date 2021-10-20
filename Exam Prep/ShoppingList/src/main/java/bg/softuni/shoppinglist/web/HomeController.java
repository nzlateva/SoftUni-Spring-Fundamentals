package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import bg.softuni.shoppinglist.service.ProductService;
import bg.softuni.shoppinglist.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class HomeController {

    private final ProductService productService;
    private final CurrentUser currentUser;

    public HomeController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        BigDecimal totalPrice = productService.getTotalPriceOfProducts();
        if (totalPrice == null) {
            totalPrice = BigDecimal.valueOf(0);
        }

        model.addAttribute("foods", productService.findAllByCategory(CategoryEnum.FOOD));
        model.addAttribute("drinks", productService.findAllByCategory(CategoryEnum.DRINK));
        model.addAttribute("household", productService.findAllByCategory(CategoryEnum.HOUSEHOLD));
        model.addAttribute("others", productService.findAllByCategory(CategoryEnum.OTHER));
        model.addAttribute("totalPriceOfProducts", totalPrice);

        return "home";
    }

}
