package binhkk.test.repository;

import binhkk.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
Iterable<Product> findByName(String name);
Iterable<Product> findByNameContaining (String name);
Iterable<Product> findAllByOrderByPriceAsc();
}
