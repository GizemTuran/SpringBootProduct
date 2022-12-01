package com.example.demo.service;

import com.example.demo.product.data.entity.Product;
import com.example.demo.product.data.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product findById(Long id) {
        Product product = productRepository.findBypId(id);
        return product;
    }
    @Override
    public List<Product> findAll() {
        List<Product> list=productRepository.findAll();
        return list;
    }

    @Override
    public String addProduct(Product product) {

        Product product2 = productRepository.findByName(product.getName()); //product2 dbden gelen bilgi
        //product.getName() ile tüm olarak gelen datadan sadece name alınır.
        if(product2!=null){ // bu ürün eğer dbde var ise ekleme
            return "Product already exist.";
        }
        else {
            productRepository.save(product); //db'ye o product ürününü koyar.
            return "Product added successfully.";
        }
    }

    @Override
    public List<Product> findByPriceBelow(double price) {
        List<Product> list=productRepository.findByPriceBelow(price);
        return list;
    }

    @Override
    public String deleteProduct(Long pId) {

        Product product = productRepository.findBypId(pId);

        if(product!=null){
            productRepository.deleteById(pId);
            return "Deleted successfuly!";
        }
        else{
            return"Not found";
        }

    }

    @Override
    public String updateProduct(Product product) {

        Product productdb = productRepository.findBypId(product.getId()); //id alınıp diğer ürünlere ulaşılır.
        if(productdb!=null) {
            productdb.setName(product.getName());
            productdb.setPrice(product.getPrice());
            productRepository.save(productdb);

            return "Product updated...";
        }
        else {
            return "Product doesn't exist";
        }
    }

}
