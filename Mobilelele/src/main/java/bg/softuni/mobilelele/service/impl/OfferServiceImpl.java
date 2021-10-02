package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import bg.softuni.mobilelele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeOffers() {
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer
                .setDescription("Very nice car.")
                .setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setMileage(10000)
                .setPrice(BigDecimal.valueOf(15000))
                .setTransmission(TransmissionEnum.AUTOMATIC)
                .setYear(2010)
                .setModel(modelRepository.findById(1L).orElse(null))
                .setSeller(userRepository.findByUsername("user").orElse(null));

        OfferEntity escortOffer = new OfferEntity();
        escortOffer
                .setDescription("After full maintenance, insurance, new tires...")
                .setEngine(EngineEnum.DIESEL)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg")
                .setMileage(50000)
                .setPrice(BigDecimal.valueOf(10000))
                .setTransmission(TransmissionEnum.MANUAL)
                .setYear(2006)
                .setModel(modelRepository.findById(2L).orElse(null))
                .setSeller(userRepository.findByUsername("admin").orElse(null));

        offerRepository.saveAll(List.of(fiestaOffer, escortOffer));
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
        OfferSummaryViewModel summaryViewModel = modelMapper
                .map(offerEntity, OfferSummaryViewModel.class);

        summaryViewModel.setModel(offerEntity.getModel().getName());

        return summaryViewModel;
    }
}
