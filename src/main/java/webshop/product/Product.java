package webshop.product;

import java.text.Normalizer;
import java.util.Objects;

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

    public String generateAddress() {
        String newAddress = name.toLowerCase().replaceAll(" ", "_");
        return normalize(newAddress);
    }

    private String normalize(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

    private String deleteRedundantSpace(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length() - 1; i++) {
            if (!(string.charAt(i) == ' ' && string.charAt(i + 1) == ' ')) {
                stringBuilder.append(string.charAt(i));
            }
        }
        if (string.equals("")) {
            return "";
        }
        return stringBuilder.append(string.charAt(string.length() - 1)).toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code.equals(product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", productStatus=" + productStatus +
                '}';
    }
}
