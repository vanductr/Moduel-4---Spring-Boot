package rikkei.academy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.model.entity.Product;

import java.util.List;

@Repository
@Transactional
public class ProductRepositoryIMPL implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("FROM Product ", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public boolean save(Product product) {
        if (product.getId() == null) {
            // Thêm mới
            entityManager.persist(product);
        } else {
            // Cập nhật
            entityManager.merge(product);
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
