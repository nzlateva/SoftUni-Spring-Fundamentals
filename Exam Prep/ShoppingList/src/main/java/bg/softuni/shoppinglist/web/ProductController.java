package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.binding.ProductAddBindingModel;
import bg.softuni.shoppinglist.model.service.ProductServiceModel;
import bg.softuni.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("productAddBindingModel")
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:/products/add";
        }

        productService.add(modelMapper
                .map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        productService.buy(id);
        return "redirect:/home";
    }

    @GetMapping("/buy/all")
    public String buy() {
        productService.buyAll();
        return "redirect:/home";
    }
}
