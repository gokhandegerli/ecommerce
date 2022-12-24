package com.avazon.ecommerce.service;


import com.avazon.ecommerce.api.model.AddCartProductToCartBody;
import com.avazon.ecommerce.api.model.UpdateCartProductInCartBody;
import com.avazon.ecommerce.model.entity.Cart;
import com.avazon.ecommerce.model.entity.CartProduct;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.model.entity.Product;
import com.avazon.ecommerce.repository.CartProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {


    private CartProductRepository repository;

    private CartService cartService;

    private ProductService productService;

    private UserService userService;

    public CartProductService(CartProductRepository repository, CartService cartService, ProductService productService, UserService userService) {
        this.repository = repository;
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    public void addCartProductToCart(AddCartProductToCartBody addCartProductToCartBody) {

        CartProduct cartProduct = new CartProduct();
        Product product = productService.getProductEntity(addCartProductToCartBody.getProductId()).get();
        product.setQuantity(product.getQuantity() - addCartProductToCartBody.getQuantity());
        cartProduct.setProduct(product);
        cartProduct.setQuantity(addCartProductToCartBody.getQuantity());
        Cart cart = cartService.getCartEntityWithUserId(addCartProductToCartBody.getUserId()).get();
        cart.setTotalPrice(cart.getTotalPrice() + (product.getPrice() * cartProduct.getQuantity()));
        cart.getCartProducts().add(cartProduct);
        cartProduct.setCart(cart);

        repository.save(cartProduct);
    }

    public void updateCartProductInCart(long cartProductId, UpdateCartProductInCartBody updateCartProductInCartBody) {

        int newQuantity = updateCartProductInCartBody.getNewQuantity();
        CartProduct cartProduct = repository.findById(cartProductId).get();
        Cart cart = cartService.getCartEntity(cartProduct.getCart().getId()).get();
        cartProduct.getProduct().
                setQuantity(cartProduct.getProduct().getQuantity() - (newQuantity - cartProduct.getQuantity()));
        cart.setTotalPrice(cart.getTotalPrice()+(cartProduct.getProduct().getPrice() * (newQuantity-cartProduct.getQuantity())));
        cartProduct.setQuantity(newQuantity);
        if (cartProduct.getQuantity() == 0) {
            cart.getCartProducts().remove(cartProduct);
            deleteCartProduct(cartProductId);
        } else {
            repository.save(cartProduct);
        }
    }

    public void deleteCartProduct(long id) {
        repository.deleteById(id);
    }

}
