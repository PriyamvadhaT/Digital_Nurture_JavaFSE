package search;

public class SearchTest {

    public static Product linearSearch(Product[] products, int targetId) {

        for (Product product : products) {

            if (product.productId == targetId) {
                return product;
            }
        }

        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }

            if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        int searchId = 104;

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, searchId);

        if (result1 != null) {
            System.out.println(result1);
        }

        System.out.println();

        System.out.println("Binary Search Result:");
        Product result2 = binarySearch(products, searchId);

        if (result2 != null) {
            System.out.println(result2);
        }
    }
}