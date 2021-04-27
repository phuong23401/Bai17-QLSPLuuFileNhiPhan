import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm kiếm theo mã sản phẩm");
            System.out.println("4. Tìm kiếm theo tên sản phẩm");
            System.out.println("0. Thoát");
            System.out.println("Mời chọn chức năng: ");

            int choose = Integer.parseInt(SCANNER.nextLine());
            switch (choose){
                case 1:
                    Manager.show();
                    break;
                case 2:
                    Manager.add();
                    break;
                case 3:
                    int id = Manager.inputId();
                    Manager.getProductById(id);
                    break;
                case 4:
                    String name = Manager.inputName();
                    Manager.searchByName(name);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập chức năng trong menu!");
                    break;
            }
        }
    }
}
