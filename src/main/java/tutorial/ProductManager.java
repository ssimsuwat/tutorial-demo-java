package tutorial;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductManager {

    private static ProductManager instance = null;
    private Connection conn = null;

    private ProductManager() {
        Properties props = new Properties();
        try {
            props.load(ClassLoader.getSystemResourceAsStream("tutorial.properties"));
            Class.forName(props.getProperty("db.driverClass", "com.mysql.jdbc.Driver"));
            String url = props.getProperty("db.url", "jdbc:mysql://localhost:3306/tutorial?user=tutorial&password=tutorial");
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public Product getProduct(String name) {
        Product p = new Product();
        try {
            PreparedStatement stmt = conn.prepareStatement("select ProductName, ProductID, SupplierID from Products where ProductName=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setProductName(rs.getString("ProductName"));
                p.setProductId(rs.getInt("ProductID"));
                p.setSupplierId(rs.getInt("SupplierID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<Product>();
        try {
            PreparedStatement stmt = conn.prepareStatement("select ProductName, ProductID, SupplierID from Products");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setProductId(rs.getInt("ProductID"));
                p.setSupplierId(rs.getInt("SupplierID"));
                result.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
