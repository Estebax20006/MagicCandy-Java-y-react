package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ProductDto;
import com.MagicCandy.AppQuiromar.entity.Product;
import com.MagicCandy.AppQuiromar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBusinnes {

    @Autowired
    private ProductService productService;
    private List<Product> productList;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public List<ProductDto> findAll(){
        try {
            this.productList = this.productService.findAll();
            this.productList.forEach(product -> {
                ProductDto productDto = new ProductDto();
                productDto.setId(product.getId());
                productDto.setName(product.getName());
                productDto.setCategory(product.getCategory());
                productDto.setUnitPrice(product.getUnitPrice());
                productDto.setQuantity(product.getQuantity());
                this.productDtoList.add(productDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.productDtoList;
    }

    public String createProduct(ProductDto productDto){
        String respuesta = "";
        try {
            if (productDto != null){
                Product product = new Product();
                product.setName(productDto.getName());
                product.setCategory(productDto.getCategory());
                product.setUnitPrice(productDto.getUnitPrice());
                product.setQuantity(productDto.getQuantity());

                System.out.println("@@@@@@@@@" + productDto.toString());
                this.productService.create(product);
                respuesta = "Registro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

}
