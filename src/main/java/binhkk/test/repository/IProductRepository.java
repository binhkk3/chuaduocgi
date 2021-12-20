package binhkk.test.repository;

import binhkk.test.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product,Long> {

}
