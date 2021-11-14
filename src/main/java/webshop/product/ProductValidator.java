package webshop.product;

import webshop.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class ProductValidator implements Validator {

    private ProductService productService;

    public ProductValidator(ProductService productService) {
        this.productService = productService;
    }

    public boolean isValidAddress(String address){
        List<String> addresses = productService.listAllProducts().stream().map(Product::getAddress).collect(Collectors.toList());
        return address != null && !address.trim().equals("") && addresses.contains(address);
    }

    public void isAddressNull(Product product){
        if (product.getAddress() == null || "".equals(product.getAddress().trim())){
            product.setAddress(product.generateAddress());
        }
    }
}
