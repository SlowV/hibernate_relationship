package com.fintech;

import com.fintech.entity.Customer;
import com.fintech.entity.Order;
import com.fintech.entity.OrderDetail;
import com.fintech.entity.Product;
import com.fintech.service.OrderService;
import com.fintech.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    @Test
    public void itShouldSaveOrderSuccess() {
        OrderService service = new OrderService();
        ProductService productService = new ProductService();
        Order order = new Order();
        order.setCustomer(new Customer("Hoàng Trường Phước"));

        // order detail 1
        OrderDetail orderDetail1 = new OrderDetail();
        Product product1 = productService.getById(1L);
        orderDetail1.setProduct(product1);
        orderDetail1.setQuantity(2);
        orderDetail1.setUnitPrice(product1.getUnitPrice());

        // Order detail 2
        OrderDetail orderDetail2 = new OrderDetail();
        Product product2 = productService.getById(2L);
        orderDetail2.setProduct(product2);
        orderDetail2.setQuantity(10);
        orderDetail2.setUnitPrice(product2.getUnitPrice());

        order.addOrderDetail(orderDetail1);
        order.addOrderDetail(orderDetail2);

        Order orderResult = service.addOrder(order);
        assertThat(orderResult).isNotNull();
    }
}
