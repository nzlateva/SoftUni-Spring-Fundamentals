package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.binding.OrderAddBindingModel;
import bg.softuni.coffeeshop.model.service.OrderServiceModel;
import bg.softuni.coffeeshop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("orderAddBindingModel")
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);

            return "redirect:/orders/add";
        }

        orderService.add(modelMapper
                .map(orderAddBindingModel, OrderServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id) {
        orderService.readyOrder(id);
        return "redirect:/home";
    }
}
