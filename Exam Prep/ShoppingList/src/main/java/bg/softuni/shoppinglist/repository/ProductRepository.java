package bg.softuni.shoppinglist.repository;

import bg.softuni.shoppinglist.model.entity.ProductEntity;
import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategoryName(CategoryEnum categoryEnum);

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal getTotalPriceOfProducts();
}
