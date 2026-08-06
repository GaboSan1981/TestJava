package com.example.template.product.Services;

import com.example.template.product.Repository.ProductRepository;
import com.example.template.product.dto.ProductRequest;
import com.example.template.product.dto.ProductResponse;
import com.example.template.product.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        applyRequest(product, request);
        return ProductResponse.from(repository.save(product));
    }

    public ProductResponse getById(Long id) {

        return ProductResponse.from(findOrThrow(id));
    }

    public List<ProductResponse> list() {
        return repository.findAll().stream().map(ProductResponse::from).toList();
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = findOrThrow(id);
        applyRequest(product, request);
        return ProductResponse.from(repository.save(product));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw null;
        }
        repository.deleteById(id);
    }

    private Product findOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> null; //... me falto manejo de errores;
    }

    private void applyRequest(Product product, ProductRequest request) {
        product.setSku(request.sku());
        product.setName(request.name());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setBrand(request.brand());
        product.setPrice(request.price());
        product.setCurrency(request.currency());
        product.setStockQuantity(request.stockQuantity());
        product.setActive(request.active());
    }
}
