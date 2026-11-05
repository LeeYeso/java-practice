package day01;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean quit = false; // 전체 프로그램 종료 여부
        ExpenseManager manager = new ExpenseManager(); // 매니저클래스 객체

        //사용자 입력 처리
        Scanner sc = new Scanner(System.in);

        while (!quit) {
            //초기 메뉴 화면 출력
            System.out.println("===== 나의 가계부 =====\n" +
                    "1. 지출 등록\n" +
                    "2. 지출 목록 조회\n" +
                    "3. 총지출 확인\n" +
                    "0. 종료");

            // 메뉴 선택
            int menu = selectMenu(sc);

            // 메뉴 0이면 종료
            if(menu ==0) {quit=true;}

            // 메뉴 1이면 지출 항목 입력
            else if (menu ==1) {
                addUserExpense(sc,manager);
            }

            // 메뉴 2이면 지출 목록 조회
            if(menu ==2) {
                manager.printExpenses();
            }

            // 메뉴 3이면 총지출 조회
            if(menu ==3) {
                System.out.println("\n"+manager.calculateTotalAmount()+"원\n");
            }


        }
    }

    // 메뉴 선택 메소드
    static int selectMenu(Scanner sc){
        // 메뉴 선택 종료 여부
        int selectMenu=10;
        boolean selectQuit = false;

        // 메뉴 선택
        while (!selectQuit) {
            System.out.print("\n메뉴 선택 : ");
            // 메뉴 선택 형식 오류 처리
            if (!sc.hasNextInt()) {
                System.out.println("\n올바르지 않은 메뉴입니다. 다음 보기 중 다시 선택해주세요.");
                System.out.println("\n\n===== 나의 가계부 =====\n" +
                        "1. 지출 등록\n" +
                        "2. 지출 목록 조회\n" +
                        "3. 총지출 확인\n" +
                        "0. 종료");
                sc.nextLine();
            } else {
                int menu = sc.nextInt();
                // 메뉴 선택 범위 오류 처리
                if (menu < 0 || menu > 3) {
                    System.out.println("\n올바르지 않은 메뉴입니다. 다음 보기 중 다시 선택해주세요.");
                    System.out.println("\n\n===== 나의 가계부 =====\n" +
                            "1. 지출 등록\n" +
                            "2. 지출 목록 조회\n" +
                            "3. 총지출 확인\n" +
                            "0. 종료");
                    sc.nextLine();
                }if (menu == 1) {
                    selectMenu = 1;
                    selectQuit = true;
                }if (menu == 0) {
                    selectMenu = 0;
                    selectQuit = true;
                }if (menu == 2) {
                    selectMenu = 2;
                    selectQuit = true;
                }if (menu == 3) {
                    selectMenu = 3;
                    selectQuit = true;
                }
            }
        } sc.nextLine();
        return selectMenu;
    }

    // 사용자 입력 처리 메소드
    static void addUserExpense(Scanner sc, ExpenseManager manager){

        // 사용자 입력 실행 및 종료 여부
        boolean inputName = false;
        boolean inputAmount = false;
        boolean inputCategory = false;

        //입력값 저장 변수
        String name = null;
        int amount = 0;
        String category = null;

        //지출 항목 입력
        while(!inputName) {
            System.out.print("\n지출 항목 : ");
            name = sc.nextLine();
            // 공백 제거 및 빈 문자열 검사
            if (name.trim().isEmpty()) {
                System.out.println("\n지출 항목명을 입력해주세요.");
            }
            else inputName = true;
        }

        //지출 금액 입력
        while(!inputAmount) {
            System.out.print("\n금액 : ");
            // 지출 금액 형식 오류 처리
            if (!sc.hasNextInt()) {
                System.out.println("\n숫자가 아닌 형식은 불가합니다. 올바른 금액을 다시 입력해주세요.");
            } else {
                amount = sc.nextInt();
                // 지출 금액 범위 오류 처리
                if (amount <= 0) {
                    System.out.println("\n음수 값은 입력불가합니다. 올바른 금액을 다시 입력해주세요.");
                }
                else inputAmount = true;
            }
            sc.nextLine();
        }

        //지출 카테고리 입력
        while(!inputCategory) {
            System.out.print("\n카테고리 : ");
            category = sc.nextLine();
            // 공백 제거 및 빈 문자열 검사
            if (category.trim().isEmpty()) {
                System.out.println("카테고리를 입력해주세요.");
            }
            else inputCategory = true;
        }
        if(name != null && amount !=0 && category !=null){
        manager.addExpense(name,amount,category);
        }
    }
}