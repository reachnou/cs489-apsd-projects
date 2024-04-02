package productmgmtapp;


import productmgmtapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMgmtApp {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55));
        products.add(new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09));
        products.add(new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99));

        Product.printProducts(products);

    }
}
