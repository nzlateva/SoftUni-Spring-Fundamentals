package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.OfferDetailsViewModel;
import bg.softuni.mobilelele.model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryViewModel> findAllOffers();

    OfferDetailsViewModel findById(Long id);

    boolean isLoggedUserOwner(String username);

    void deleteOffer(Long id);
}
