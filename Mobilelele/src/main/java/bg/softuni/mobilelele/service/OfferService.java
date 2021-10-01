package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryViewModel> findAllOffers();
}
