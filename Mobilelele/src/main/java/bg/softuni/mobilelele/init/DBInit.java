package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.entity.enums.CategoryEnum;
import bg.softuni.mobilelele.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            ModelEntity fiesta = new ModelEntity();
            fiesta
                    .setName("Fiesta")
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                    .setStartYear(1976)
                    .setBrand(ford);

            ModelEntity escort = new ModelEntity();
            escort
                    .setName("Escort")
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg")
                    .setStartYear(1967)
                    .setEndYear(2004)
                    .setBrand(ford);

            ford.setModels(List.of(fiesta, escort));

            brandRepository.save(ford);
        }
    }
}
