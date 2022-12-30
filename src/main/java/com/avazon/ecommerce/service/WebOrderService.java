package com.avazon.ecommerce.service;


import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.model.entity.Cart;
import com.avazon.ecommerce.model.entity.CartProduct;
import com.avazon.ecommerce.model.entity.OrderProduct;
import com.avazon.ecommerce.model.entity.WebOrder;
import com.avazon.ecommerce.model.enums.OrderStatus;
import com.avazon.ecommerce.repository.CartProductRepository;
import com.avazon.ecommerce.repository.CartRepository;
import com.avazon.ecommerce.repository.OrderProductRepository;
import com.avazon.ecommerce.repository.WebOrderRepository;
import com.avazon.ecommerce.response.WebOrderResponse;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WebOrderService {

    private WebOrderRepository repository;
    private OrderProductRepository orderProductRepository;
    private CartRepository cartRepository;
    private CartProductRepository cartProductRepository;

    public WebOrderService(WebOrderRepository repository, OrderProductRepository orderProductRepository, CartRepository cartRepository,
                           CartProductRepository cartProductRepository) {
        this.repository = repository;
        this.orderProductRepository = orderProductRepository;
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Transactional
    public WebOrderResponse checkoutCart(long cartId) {
        Cart cart = cartRepository.findById(cartId).get();

        WebOrder order = new WebOrder();
        order.setStatus(OrderStatus.CONFIRMED);
        order.setOrderedDate(LocalDate.now());
        order.setTotalPrice(cart.getTotalPrice());
        order.setUser(cart.getUser());
        Set<OrderProduct> orderedProducts = new HashSet<>();
        for (CartProduct cartProduct : cart.getCartProducts()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setQuantity(cartProduct.getQuantity());
            orderProduct.setProduct(cartProduct.getProduct());
            orderedProducts.add(orderProduct);
            orderProductRepository.save(orderProduct);
            //cartProductRepository.deleteByCartId(cart.getId());

        }
        order.setOrderedProducts(orderedProducts);
        repository.save(order);
        WebOrderResponse response = new WebOrderResponse();
        response.setOrder(order.toDto());
        cart.setTotalPrice(0);
        cartRepository.save(cart);
        cart.setCartProducts(null);
        cartProductRepository.deleteAllByCartId(cart.getId());
        return response;

    }


}
