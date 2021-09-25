package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import bg.softuni.mobilelele.service.UserRoleService;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final UserRoleService userRoleService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService, UserRoleService userRoleService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsers();
        userRoleService.initializeRoles();
    }


}
