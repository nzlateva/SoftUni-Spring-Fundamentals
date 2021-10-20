package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import bg.softuni.shoppinglist.model.service.ProductServiceModel;
import bg.softuni.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductServiceModel add(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllByCategory(CategoryEnum categoryEnum);

    void buy(Long id);

    void buyAll();

    BigDecimal getTotalPriceOfProducts();
}
