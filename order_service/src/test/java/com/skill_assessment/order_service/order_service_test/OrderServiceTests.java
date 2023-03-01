package com.skill_assessment.order_service.order_service_test;

import com.skill_assessment.order_service.order_adapter.OrderEntity;
import com.skill_assessment.order_service.order_adapter.OrderRepositoryAdapter;
import com.skill_assessment.order_service.order_adapter.ShippingAddressEntity;
import com.skill_assessment.order_service.order_constants.OrderStatus;
import com.skill_assessment.order_service.order_models.ChangeOrderStatus;
import com.skill_assessment.order_service.order_models.Order;
import com.skill_assessment.order_service.order_models.ShippingAddress;
import com.skill_assessment.order_service.order_service.AuthenticatorWebClient;
import com.skill_assessment.order_service.order_service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTests {

    @Mock
    private OrderRepositoryAdapter orderRepositoryAdapter;

    @Mock
    private AuthenticatorWebClient authenticatorWebClient;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    private Order orderBuilder(String name, int quantity, OrderStatus status, ShippingAddress shippingAddress) {
        return Order.builder()
                .itemName(name)
                .orderStatus(status)
                .quantity(quantity)
                .shippingAddress(shippingAddress)
                .build();
    }

    private OrderEntity orderEntityBuilder(Long id, String name, int quantity, OrderStatus status, ShippingAddressEntity shippingAddress) {
        return OrderEntity.builder()
                .id(id)
                .itemName(name)
                .orderStatus(status.toString())
                .quantity(quantity)
                .shippingAddressEntity(shippingAddress)
                .build();
    }

    private ShippingAddress shippingAddressBuilder(String city, String number, String postalCode, String street) {
        return ShippingAddress.builder()
                .city(city)
                .no(number)
                .postalCode(postalCode)
                .street(street)
                .build();
    }

    private ShippingAddressEntity shippingAddressEntityBuilder(Long id, ShippingAddress shippingAddress) {
        return ShippingAddressEntity.builder()
                .id(id)
                .city(shippingAddress.getCity())
                .no(shippingAddress.getNo())
                .postalCode(shippingAddress.getPostalCode())
                .street(shippingAddress.getStreet())
                .build();
    }

    @Test
    void testCreateNewValidOrder() throws Exception {
        String authHeader = "Bearer header";
        Mockito.when(authenticatorWebClient.isAuthenticated(authHeader)).thenReturn(true);
        ShippingAddress shippingAddress = shippingAddressBuilder("Matara", "25", "12345", "main street");
        Order newOrder = orderBuilder("item_1", 2, OrderStatus.NEW, shippingAddress);
        OrderEntity savedOrder = orderEntityBuilder(1L, newOrder.getItemName(), newOrder.getQuantity(), newOrder.getOrderStatus(), shippingAddressEntityBuilder(1L, shippingAddress));
        Mockito.when(orderRepositoryAdapter.create(newOrder)).thenReturn(savedOrder);
        ResponseEntity<OrderEntity> createdOrder = orderServiceImpl.createNewOrder(newOrder, authHeader);
        assertEquals(createdOrder.getBody(), savedOrder);
    }

    @Test
    void testGetAllOrders() throws Exception {
        String authHeader = "Bearer header";
        Mockito.when(authenticatorWebClient.isAuthenticated(authHeader)).thenReturn(true);
        ShippingAddress shippingAddress = shippingAddressBuilder("Matara", "25", "12345", "main street");
        Order firstOrder = orderBuilder("item_1", 2, OrderStatus.NEW, shippingAddress);
        Order secondOrder = orderBuilder("item_2", 3, OrderStatus.NEW, shippingAddress);
        Order thirdOrder = orderBuilder("item_3", 3, OrderStatus.NEW, shippingAddress);
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(firstOrder);
        allOrders.add(secondOrder);
        allOrders.add(thirdOrder);
        Mockito.when(orderRepositoryAdapter.getAll()).thenReturn(allOrders);
        ResponseEntity<List<Order>> response = orderServiceImpl.getAllOrders(authHeader);
        var allOrdersGot = response.getBody();
        assertEquals(allOrdersGot.get(0), allOrders.get(0));
        assertEquals(allOrdersGot.get(1), allOrders.get(1));
        assertEquals(allOrdersGot.get(2), allOrders.get(2));
    }

    @Test
    void testChangeOrderStatus() throws Exception {
        String authHeader = "Bearer header";
        Mockito.when(authenticatorWebClient.isAuthenticated(authHeader)).thenReturn(true);
        ShippingAddress shippingAddress = shippingAddressBuilder("Matara", "25", "12345", "main street");
        Order newOrder = orderBuilder("item_1", 2, OrderStatus.NEW, shippingAddress);
        ChangeOrderStatus changeOrderStatus = new ChangeOrderStatus();
        changeOrderStatus.builder()
                .id(ArgumentMatchers.anyLong())
                .orderStatus(OrderStatus.CANCELLED)
                .build();
        Order stateChangedOrder = orderBuilder("item_1", 2, OrderStatus.CANCELLED, shippingAddress);
        Mockito.when(orderRepositoryAdapter.changeStatus(changeOrderStatus)).thenReturn(stateChangedOrder);
        ResponseEntity<Order> changedOrder = orderServiceImpl.changeOrderStatusById(changeOrderStatus, authHeader);
        assertEquals(OrderStatus.CANCELLED, stateChangedOrder.getOrderStatus());
    }
}
