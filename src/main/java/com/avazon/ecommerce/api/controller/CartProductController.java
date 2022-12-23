package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.api.model.AddCartProductToCartBody;
import com.avazon.ecommerce.api.model.UpdateCartProductInCartBody;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.model.entity.Product;
import com.avazon.ecommerce.service.CartProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart-products")
public class CartProductController {

    private CartProductService service;

    public CartProductController(CartProductService cartProductService) {
        this.service = cartProductService;
    }

    @PostMapping()
    public void addCartProductToCart(@RequestBody AddCartProductToCartBody addCartProductToCartBody) {
        service.addCartProductToCart(addCartProductToCartBody);
    }

    @PutMapping("{cartProductId}")
    public void updateCartProductInCart(@PathVariable(value = "cartProductId") long cartProductId,
            @RequestBody UpdateCartProductInCartBody updateCartProductInCartBody) {
        service.updateCartProductInCart(cartProductId, updateCartProductInCartBody);
    }


}
