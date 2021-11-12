package webshop.product;

import java.text.Normalizer;

public class Product {

    private long id;
    private String code;
    private String name;
    private String address;
    private String manufacturer;
    private int price;
    private ProductStatus productStatus;

    public Product() {
    }

    public Product(long id, String code, String name, String manufacturer, int price,
                   ProductStatus productStatus) {
        this.id = id;
        this.code = code;
        this.name = deleteRedundantSpace(name.trim());
        address = generateAddress();
        this.manufacturer = manufacturer;
        this.price = price;
        this.productStatus = productStatus;
    }

    public Product(long id, String code, String name, String address, String manufacturer, int price,
                   ProductStatus productStatus) {
        this.id = id;
        this.code = code;
        this.name = deleteRedundantSpace(name.trim());
        this.address = address;
        this.manufacturer = manufacturer;
        this.price = price;
        this.productStatus = productStatus;
    }

    public String generateAddress(){
        String newAddress = name.toLowerCase().replaceAll(" ", "_");
        return normalize(newAddress);
    }

    private String normalize(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

    private String deleteRedundantSpace(String string){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length()-1;i++){
            if (!(string.charAt(i) == ' ' &&  string.charAt(i+1)==' ')){
                stringBuilder.append(string.charAt(i));
            }
        }
        if(string.equals("")){
            return "";
        }
        return stringBuilder.append(string.charAt(string.length()-1)).toString();
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
