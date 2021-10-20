package bg.softuni.shoppinglist.init;

import bg.softuni.shoppinglist.model.entity.CategoryEntity;
import bg.softuni.shoppinglist.model.entity.enums.CategoryEnum;
import bg.softuni.shoppinglist.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DBInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .map(this::getCategoryEntity)
                .forEach(categoryRepository::save);

    }

    private CategoryEntity getCategoryEntity(CategoryEnum categoryEnum) {
        return new CategoryEntity()
                .setName(categoryEnum)
                .setDescription(categoryEnum.name());
    }
}
