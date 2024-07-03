package com.shopping.fashion.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.fashion.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Procedure(name = "add_product")
    void add_product(
        @Param("p_name") String name,
        @Param("p_description") String description,
        @Param("p_image") String image,
        @Param("p_price") double price,
        @Param("p_discount") int discount,
        @Param("p_quantity") int quantity,
        @Param("p_category_id") int category_id
    );

    @Procedure(name = "delete_product")
    void delete_product(@Param("p_id") int id);

    @Procedure(name = "update_product")
    void update_product(
        @Param("p_id") int id,
        @Param("p_name") String name,
        @Param("p_description") String description,
        @Param("p_image") String image,
        @Param("p_price") double price,
        @Param("p_discount") int discount,
        @Param("p_quantity") int quantity
    );

    // calculate_inventory_value để tính giá trị kho hàng
    // nativeQuery = true nghĩa là để tương tác với các đối tượng thay vì bảng cơ sở dữ liệu trực tiếp
    @Query(value = "SELECT calculate_inventory_value()", nativeQuery = true)
    double calculate_inventory_value();
}
