package webshop.product;

import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class ProductValidator implements Validator {

    private ProductService productService;

    public ProductValidator(ProductService productService) {
        this.productService = productService;
    }

    public CustomResponseStatus validateProduct(Product product){
        if (isEmpty(product.getName()) || isEmpty(product.getCode()) || isEmpty(product.getManufacturer()) || product.getPrice() == 0){
            return new CustomResponseStatus(Response.FAILED, "These parameters can not be empty: code, name, manufacturer, price");
        }
        if (product.getPrice() > 2_000_000 || product.getPrice() < 0){
            return new CustomResponseStatus(Response.FAILED, "Price must be between 0 and 2M Ft.");
        }
        return new CustomResponseStatus(Response.SUCCESS, "Product is okay.");
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
