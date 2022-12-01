package com.example.demo.product.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ProductRepository extends JpaRepository<Product,Long>{

    @Query("select p from Product AS p where p.pId=:pId")
    Product findBypId(@Param("pId")Long pId);

    @Query("select p from Product  AS p")
    List<Product> findAll();

    @Query("select  p from Product AS p where p.price<=:price")
    List<Product> findByPriceBelow(@Param("price")Double price);

    @Query("select p from Product AS p where p.name=:name")
    Product findByName(@Param("name")String name);
}
