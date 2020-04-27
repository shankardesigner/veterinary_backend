package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.dto.ProductDto;
import com.shankardesigner.poudelveterinary.model.Product;
import com.shankardesigner.poudelveterinary.repositiory.ProductCategoryRepositiory;
import com.shankardesigner.poudelveterinary.repositiory.ProductRepositiory;
import com.shankardesigner.poudelveterinary.repositiory.VendorRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.shankardesigner.poudelveterinary.configuration.Const.GET_PATH;

@Service
public class ProductServiceImpl implements GenericService<ProductDto> {

    @Autowired
    private ProductRepositiory productRepositiory;

    @Autowired
    private VendorRepositiory vendorRepositiory;

    @Autowired
    private ProductCategoryRepositiory productCategoryRepositiory;

    @Override
    public ProductDto saveInfo(ProductDto productDto) {
        Product product = new Product();
        System.out.println(productDto);
        product.setPrice(productDto.getPrice());
        product.setProductDesc(productDto.getProductDesc());
        product.setProductName(productDto.getProductName());
        product.setImage(productDto.getImagePath());
        product.setVendor(vendorRepositiory.findById(productDto.getVendor()).get());
        product.setProductCat(productCategoryRepositiory.findById(productDto.getProductCat()).get());
        productRepositiory.save(product);
        return productDto;
    }

    @Override
    public ProductDto updateInfo(ProductDto productDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        return false;
    }

    @Override
    public List<ProductDto> getAllInfo() {
        List<Product> allProduct = productRepositiory.findAll();
        return allProduct.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getPid());
            productDto.setProductName(product.getProductName());
            productDto.setPrice(product.getPrice());
            productDto.setProductDesc(product.getProductDesc());
            productDto.setProductCat(product.getProductCat().getCatId());
            productDto.setVendor(product.getVendor().getVid());
            productDto.setImagePath(GET_PATH+product.getImage());
            return productDto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDto getInfoById(long id) {
        return null;
    }
}
