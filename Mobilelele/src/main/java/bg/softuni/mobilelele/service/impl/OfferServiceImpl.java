package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeOffers() {
        //TODO
    }

    @Override
    public List<OfferSummaryViewModel> findAllOffers() {
        return offerRepository
                .findAll()
                .stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    private OfferSummaryViewModel mapToModel(OfferEntity offerEntity) {
        return modelMapper
                .map(offerEntity, OfferSummaryViewModel.class);
    }
}
