package binhkk.test.service;

import binhkk.test.model.Product;
import binhkk.test.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductImplService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
iProductRepository.save(product);
    }

    @Override
    public void remove(Long id) {
iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return iProductRepository.findByName(name) ;
    }

    @Override
    public Iterable<Product> findByNameContaining(String name) {
        return iProductRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPriceAsc() {
        return iProductRepository.findAllByOrderByPriceAsc();
    }
}
