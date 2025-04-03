package it.lipari.accademy.service;

import it.lipari.accademy.entity.ProductEntity;
import it.lipari.accademy.model.ProductModel;
import it.lipari.accademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {

        return productRepository.findAll();
    }

    public Optional<ProductEntity> getElementById(Long id) {
        return productRepository.findById(id);
    }

    public Boolean deleteProduct(Long id) {
        Optional<ProductEntity> p = getElementById(id);
        if (p.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public ProductEntity addProduct(ProductModel model) {
        ProductEntity newProduct = new ProductEntity();

        newProduct.setTitle(model.getTitle());
        newProduct.setPrice(model.getPrice());
        newProduct.setDescription(model.getDescription());
        newProduct.setImg(model.getImg());
        newProduct.setImgBackground(model.getImgBackground());
        return productRepository.save(newProduct);

    }

    public ProductEntity editProduct(Long id, ProductModel model) {
        Optional<ProductEntity> existingProductOpt = productRepository.findById(id);

        if (existingProductOpt.isPresent()) {
            ProductEntity updateProduct = existingProductOpt.get();
            updateProduct.setTitle(model.getTitle());
            updateProduct.setPrice(model.getPrice());
            updateProduct.setDescription(model.getDescription());
            updateProduct.setImg(model.getImg());
            updateProduct.setImgBackground(model.getImgBackground());
            return productRepository.save(updateProduct);
        } else {
            return null;
        }
    }

}


