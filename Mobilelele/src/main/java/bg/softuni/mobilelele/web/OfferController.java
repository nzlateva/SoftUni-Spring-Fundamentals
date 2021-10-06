package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.view.OfferDetailsViewModel;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.findAllOffers());

        return "offers";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id,
                          Model model) {

        OfferDetailsViewModel detailsViewModel = offerService.findById(id);

        model.addAttribute("offer", detailsViewModel);
        model.addAttribute("currentUserIsOwner",
                offerService.isLoggedUserOwner(detailsViewModel.getSeller().getUsername()));

        return "details";
    }
}
