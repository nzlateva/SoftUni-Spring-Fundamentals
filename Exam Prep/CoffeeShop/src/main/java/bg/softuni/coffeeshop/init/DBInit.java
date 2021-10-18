package bg.softuni.coffeeshop.init;

import bg.softuni.coffeeshop.model.entity.CategoryEntity;
import bg.softuni.coffeeshop.model.entity.enums.CategoryEnum;
import bg.softuni.coffeeshop.repository.CategoryRepository;
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
        int neededTime = 0;
        switch (categoryEnum) {
            case CAKE -> neededTime = 10;
            case DRINK -> neededTime = 1;
            case COFFEE -> neededTime = 2;
            case OTHER -> neededTime = 5;
        }

        return new CategoryEntity()
                .setName(categoryEnum)
                .setNeededTime(neededTime);
    }
}
