package es.alfonsomarin.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public OrderEntity get(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        order.getLines().forEach(line -> line.setOrder(order));
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> findAll(LocalDate from, LocalDate to) {
        return orderRepository.findByOrderDateBetween(from, to);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
