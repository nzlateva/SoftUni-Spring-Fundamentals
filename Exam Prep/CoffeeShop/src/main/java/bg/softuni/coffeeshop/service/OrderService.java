package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.service.OrderServiceModel;
import bg.softuni.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    OrderServiceModel add(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDesc();

    void readyOrder(Long id);
}
