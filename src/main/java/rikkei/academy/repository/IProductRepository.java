package rikkei.academy.repository;

import rikkei.academy.model.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(Long id);

    boolean save(Product product);

    boolean delete(Long id);
}
