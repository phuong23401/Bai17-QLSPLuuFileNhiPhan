import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Product> PRODUCT_LIST = new ArrayList<>();

    public static void show() {
        for (Product product : PRODUCT_LIST) {
            System.out.println(product);
        }
    }

    public static void add() {
        int id = inputId();
        String name = inputName();
        String producer = inputProducer();
        int price = inputPrice();
        String otherDescription = inputDescription();

        Product product = new Product(id, name, producer, price, otherDescription);
        PRODUCT_LIST.add(product);
    }

    public static void searchById(int id) {
        Product product = getProductById(id);
        System.out.println(product);
    }

    public static void searchByName(String name) {
        Product product = getProductByName(name);
        System.out.println(product);
    }

    public static void writeFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("Products.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Product product : PRODUCT_LIST) {
                bufferedWriter.write(product.toString());
            }
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Đã ghi vào file!");
    }

    public static void readFile() {
        try {
            FileInputStream fileInput = new FileInputStream("Products.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInput);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product getProductById(int id) {
        Product product = null;
        boolean isExisted = false;
        for (Product product1 : PRODUCT_LIST) {
            if (product1.getId() == id) {
                isExisted = true;
                product = product1;
                break;
            }
        }
        if (!isExisted) {
            System.out.println("Không tìm thấy sản phẩm với mã sẩn phẩm trên!");
        }
        return product;
    }

    public static Product getProductByName(String name) {
        Product product = null;
        boolean isExisted = false;
        for (Product product1 : PRODUCT_LIST) {
            if (product1.getName().equals(name)) {
                isExisted = true;
                product = product1;
                break;
            }
        }
        if (!isExisted) {
            System.out.println("Không tìm thấy sản phẩm với tên sẩn phẩm trên!");
        }
        return product;
    }

    public static int inputId() {
        System.out.print("Nhập mã sản phẩm: ");
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (Exception e) {
                System.out.println("Mã sẩn phẩm không hợp lệ!");
            }
        }
    }

    public static String inputName() {
        System.out.print("Nhập tên sản phẩm: ");
        return SCANNER.nextLine();
    }

    public static String inputProducer() {
        System.out.print("Nhập nhà sản xuất: ");
        return SCANNER.nextLine();
    }

    public static int inputPrice() {
        System.out.print("Nhập giá sản phẩm: ");
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (Exception e) {
                System.out.println("Giá sản phẩm không hợp lệ!");
            }
        }
    }

    public static String inputDescription() {
        System.out.print("Mô tả khác: ");
        return SCANNER.nextLine();
    }
}
