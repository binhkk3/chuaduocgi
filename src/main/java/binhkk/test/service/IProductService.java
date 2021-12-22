package binhkk.test.service;

import binhkk.test.model.Product;

public interface IProductService extends IGenaralService<Product>{
    Iterable<Product> findByName(String name);
    Iterable<Product> findByNameContaining (String name);
    Iterable<Product> findAllByOrderByPriceAsc();
}
