package com.abcode.products.dto;

import com.abcode.products.entity.Category;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotNull
    private long id;
    private String name;

    public static CategoryDTO convert(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
