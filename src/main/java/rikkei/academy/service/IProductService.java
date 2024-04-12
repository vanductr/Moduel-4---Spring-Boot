package rikkei.academy.service;

import rikkei.academy.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    boolean save(Product product);

    boolean delete(Long id);
}
