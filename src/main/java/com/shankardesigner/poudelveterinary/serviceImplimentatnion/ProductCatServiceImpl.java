package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.dto.ProductCatDto;
import com.shankardesigner.poudelveterinary.model.ProductCat;
import com.shankardesigner.poudelveterinary.repositiory.ProductCategoryRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCatServiceImpl implements GenericService<ProductCatDto> {

    @Autowired
    private ProductCategoryRepositiory productCategoryRepositiory;

    @Override
    public ProductCatDto saveInfo(ProductCatDto productCatDto) {
        ProductCat productCat = new ProductCat();
        productCat.setCategoryName(productCatDto.getProductCategory().trim());

        if(productCatDto.getProductCategory().trim().length() > 1) {
            productCategoryRepositiory.save(productCat);
            return productCatDto;
        }
        return productCatDto;
    }

    @Override
    public ProductCatDto updateInfo(ProductCatDto productCatDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        return false;
    }

    @Override
    public List<ProductCatDto> getAllInfo() {
        List<ProductCat> allProduct = productCategoryRepositiory.findAll();
        return allProduct.stream().map(e -> {
            ProductCatDto productCatDto = new ProductCatDto();
            productCatDto.setPcatId(e.getCatId());
            productCatDto.setProductCategory(e.getCategoryName());
            return productCatDto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductCatDto getInfoById(long id) {
        ProductCatDto productCatDto = new ProductCatDto();
        ProductCat productCat = productCategoryRepositiory.findById(id).get();
        productCatDto.setPcatId(productCat.getCatId());
        productCatDto.setProductCategory(productCat.getCategoryName());
        return productCatDto;
    }
}
