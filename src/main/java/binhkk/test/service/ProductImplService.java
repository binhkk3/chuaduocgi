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

    }
}
