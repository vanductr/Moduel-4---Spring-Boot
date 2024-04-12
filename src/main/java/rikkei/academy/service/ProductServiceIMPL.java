package rikkei.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rikkei.academy.model.entity.Product;
import rikkei.academy.repository.IProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements IProductService{
    private final IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        if (product.getId() == null) {
            product.setSku(UUID.randomUUID().toString());
        }
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        return productRepository.delete(id);
    }
}
