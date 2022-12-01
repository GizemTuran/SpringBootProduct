package com.example.demo.productrestcontroller;

import com.example.demo.product.data.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest {

    @Autowired
    private ProductService productService; //dependency injection

    @GetMapping("api/find/{id}")
    public Product findById(@PathVariable("id")long id){
        return productService.findById(id);
    }
    @GetMapping("api/find/all")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("api/findbelow/{price}")
    public List<Product> findByPriceBelow(@PathVariable("price")double price){
        return productService.findByPriceBelow(price);
    }
    @DeleteMapping("api/product/delete/{id}")
    public String deleteProduct(@PathVariable("id")long id){
        return productService.deleteProduct(id);
    }
    @PostMapping("api/product/addproduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PutMapping("api/product/update")
    public String updateProduct(@RequestBody Product product) //input girilecekse requestbody kullanılır.
    {
        return productService.updateProduct(product);
    }
}
