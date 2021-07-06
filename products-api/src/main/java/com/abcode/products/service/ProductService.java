package com.abcode.products.service;

import com.abcode.products.dto.ProductDTO;
import com.abcode.products.entity.Product;
import com.abcode.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        var products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());

    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }

    public ProductDTO save(ProductDTO productDTO) {
        var product = productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    public ProductDTO delete(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(productRepository::delete);
        return null;
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        var products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }
}
