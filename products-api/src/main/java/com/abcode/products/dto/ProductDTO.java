package com.abcode.products.dto;

import com.abcode.products.entity.Product;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotNull
    private Float price;
    @NotBlank
    private String description;
    @NotNull
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        var dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            dto.setCategory(CategoryDTO.convert(product.getCategory()));
        }
        return dto;
    }
}
