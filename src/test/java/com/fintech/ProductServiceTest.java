package com.fintech;

import com.fintech.entity.Product;
import com.fintech.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    @Test
    public void itShouldSaveProductSuccess() {
        ProductService service = new ProductService();
        Product product = new Product();
        product.setName("Bánh Kem");
        Product productResult = service.addProduct(product);
        assertThat(productResult).isNotNull();
        assertThat(productResult.getName()).isEqualTo(product.getName());
    }

    @Test
    public void itShouldGetProoductById() {
        ProductService service = new ProductService();
        Product productResult = service.getById(1L);
        assertThat(productResult).isNotNull();
    }
}
