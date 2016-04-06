package tutorial;

public class Product {
    private String productName;
    private int productId;
    private int supplierId ;

    public Product() {
    }

    public Product(String productName, int productId, int supplierId) {
        this.productName = productName;
        this.productId = productId;
        this.supplierId = supplierId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
