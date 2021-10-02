package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final OfferService offerService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService, UserRoleService userRoleService, OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userRoleService.initializeRoles();
        userService.initializeUsers();
        offerService.initializeOffers();
    }


}
