package com.example.marketStoreAPI.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.marketStoreAPI.persistence.entity.CategoryEntity;
import com.example.marketStoreAPI.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mappings({
      @Mapping(source = "idCategory", target = "categoryId"),
      @Mapping(source = "description", target = "category"),
      @Mapping(source = "status", target = "active"),
  })
  Category toCategory(CategoryEntity categoryEntity);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  CategoryEntity toCategoryEntity(Category category);

}
