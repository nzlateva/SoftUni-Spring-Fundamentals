package bg.softuni.coffeeshop.service.impl;

import bg.softuni.coffeeshop.model.entity.OrderEntity;
import bg.softuni.coffeeshop.model.service.OrderServiceModel;
import bg.softuni.coffeeshop.model.view.OrderViewModel;
import bg.softuni.coffeeshop.repository.CategoryRepository;
import bg.softuni.coffeeshop.repository.OrderRepository;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public OrderServiceModel add(OrderServiceModel orderServiceModel) {

        OrderEntity orderEntity = modelMapper
                .map(orderServiceModel, OrderEntity.class);

        orderEntity
                .setEmployee(userRepository.findById(currentUser.getId()).orElse(null))
                .setCategory(categoryRepository.findByName(orderServiceModel.getCategory()).orElse(null));

        orderEntity = orderRepository.save(orderEntity);

        return modelMapper
                .map(orderEntity, OrderServiceModel.class);
    }

    @Override
    public List<OrderViewModel> findAllOrdersByPriceDesc() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
