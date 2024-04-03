package productmgmtapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Product {
    private Long productId;
    private String name;
    private Date dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product() {}

    public Product(String name, String dateSupplied, int quantityInStock, double unitPrice) {
        this.name = name;
        try {
            this.dateSupplied = new SimpleDateFormat("yyyy-MM-dd").parse(dateSupplied);
        } catch (Exception e) {
            this.dateSupplied = null;
        }
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(Long productId, String name, String dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        try {
            this.dateSupplied = new SimpleDateFormat("yyyy-MM-dd").parse(dateSupplied);
        } catch (Exception e) {
            this.dateSupplied = null;
        }
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return
                "\"productId\":" + productId +
                ", \"name\":" + name + '\'' +
                ", \"dateSupplied\":" + dateSupplied +
                ", \"quantityInStock\":" + quantityInStock +
                ", \"unitPrice\":" + unitPrice
                ;
    }

    public static void printProducts(List<Product> products) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Print as JSON
        System.out.println("[");
        for (Product product : products) {
            // Print JSON
            System.out.println("{");
            System.out.println("  \"productId\": " + product.productId + ",");
            System.out.println("  \"name\": \"" + product.name + "\",");
            System.out.println("  \"dateSupplied\": \"" + dateFormat.format(product.dateSupplied) + "\",");
            System.out.println("  \"quantityInStock\": " + product.quantityInStock + ",");
            System.out.println("  \"unitPrice\": " + product.unitPrice);
            System.out.println("}");
        }
        System.out.println("]");

        System.out.println();

        // Print XML
        for (Product product : products) {
            System.out.println("<product>");
            System.out.println("  <productId>" + product.productId + "</productId>");
            System.out.println("  <name>" + product.name + "</name>");
            System.out.println("  <dateSupplied>" + dateFormat.format(product.dateSupplied) + "</dateSupplied>");
            System.out.println("  <quantityInStock>" + product.quantityInStock + "</quantityInStock>");
            System.out.println("  <unitPrice>" + product.unitPrice + "</unitPrice>");
            System.out.println("</product>");
        }

        System.out.println();

        // Print CSV
        for (Product product : products) {
            System.out.println(product.productId + "," + product.name + "," + dateFormat.format(product.dateSupplied) + "," + product.quantityInStock + "," + product.unitPrice);
        }

    }
}
