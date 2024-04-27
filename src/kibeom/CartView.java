package kibeom;

import util.SimpleInput;

import static kibeom.CartRepository.getItems;
import static kibeom.CartRepository.item;

public class CartView {

    private static CartRepository cartRepo;

    public CartView() {
        this.cartRepo = new CartRepository();

    }


    public static void showCartRepository() {

        while (true) {
        System.out.println("============ 장바구니 목록 =============");
            CartRepository.showCartRepository();
        System.out.println("1. 결제하기");
        System.out.println("2. 장바구니 물품 빼기");
        String num = SimpleInput.input("\n>> ");


            switch (num) {
                case "1":

                    break;
                case "2":
                    deleteItem();
                    break;
                default:
                    System.out.println("1 ~ 2!");
            }
        }

    }



    public static void deleteItem() {
//        String num = SimpleInput.input("삭제 하고 싶은 제품의 번호를 입력해주세요\n>> ");
        String itemName = SimpleInput.input("삭제 하고 싶은 제품명을 입력해주세요.\n>> ");

        // itemName 탐색

        if (item.containsKey(itemName)) {
            System.out.println(itemName + "\n" + getItems().get(itemName));
            System.out.println("1. 삭제하기");
            System.out.println("2. 취소하기");
            String answer = SimpleInput.input(">>\n ");
            if (answer.equals("1")) {
                item.remove(itemName);
                System.out.println(itemName + " 항목이 삭제되었습니다.");
            } else if (answer.equals("2")) {
                System.out.println("실행을 취소합니다.");
            } else {
                System.out.println("1 ~ 2");
            }
        } else {
            System.out.println(itemName + " 항목이 존재하지 않습니다.");
        }
    }
}
/*

    // 전체 도서 정보를 출력
    private void displayAllBooks() {
        System.out.println("\n=============== 전체 도서 목록 ================");
        Book[] informationList = repository.getAllBooksInfo();

        for (int i = 0; i < informationList.length; i++) {
            Book book = informationList[i];
            System.out.printf("%d. %s\n", i+1, book.info());
        }

 */
