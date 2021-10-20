package bg.softuni.shoppinglist.service.impl;

import bg.softuni.shoppinglist.model.entity.ProductEntity;
import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import bg.softuni.shoppinglist.model.service.ProductServiceModel;
import bg.softuni.shoppinglist.model.view.ProductViewModel;
import bg.softuni.shoppinglist.repository.CategoryRepository;
import bg.softuni.shoppinglist.repository.ProductRepository;
import bg.softuni.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductServiceModel add(ProductServiceModel productServiceModel) {

        ProductEntity productEntity = modelMapper
                .map(productServiceModel, ProductEntity.class)
                .setCategory(categoryRepository
                        .findByName(productServiceModel.getCategory()).orElse(null));

        ProductEntity newEntity = productRepository.save(productEntity);

        return modelMapper
                .map(newEntity, ProductServiceModel.class)
                .setCategory(newEntity.getCategory().getName());
    }

    @Override
    public List<ProductViewModel> findAllByCategory(CategoryEnum categoryEnum) {
        return productRepository
                .findByCategoryName(categoryEnum)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }

    @Override
    public BigDecimal getTotalPriceOfProducts() {
        return productRepository.getTotalPriceOfProducts();
    }
}
