package day02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean quit = false; // 전체 프로그램 종료 여부
        TodoManager manager = new TodoManager(); // 매니저클래스 객체

        //사용자 입력 처리
        Scanner sc = new Scanner(System.in);

        // 전체 프로그램 반복문
        while(!quit)
        {
            // 메뉴 선택
            int menu = selectMenu(sc);

            // 0번 선택 시 종료
            if(menu==0){
                quit=true;
            }

            //1번 선택 시 할 일 등록
            if(menu==1){
                addUserTodo(sc,manager);
            }

            //2번 선택 시 할 일 목록 조회
            if(menu==2){
                manager.printTodoList();
            }

            //3번 선택 시 할 일 완료 처리
            if(menu==3){
                // 사용자 번호 입력 메소드 실행 후
                // 완료 여부 변경 메소드 호출
                int todoNum = completeUserTodo(sc, manager);
                // 처음 완료할 목록이 없다면 변경 메소드 호출 안 함
                if(todoNum != -2){
                manager.markAsCompleted(todoNum);}
            }
        }
    }

    // 메뉴 선택 메소드
    static int selectMenu(Scanner sc){
        // 메뉴 선택 종료 여부
        int selectMenu=10;
        boolean selectQuit = false;
        System.out.println("===== My Todo List =====\n" +
                "1. 할 일 등록\n" +
                "2. 할 일 목록 조회\n" +
                "3. 할 일 완료 처리\n" +
                "0. 종료");

        // 메뉴 선택
        while (!selectQuit) {
            System.out.print("\n메뉴 선택 : ");
            // 메뉴 선택 형식 오류 처리
            if (!sc.hasNextInt()) {
                System.out.println("\n올바르지 않은 메뉴입니다. 다음 보기 중 다시 선택해주세요.\n");
                sc.nextLine();
            } else {
                int menu = sc.nextInt();
                // 메뉴 선택 범위 오류 처리
                if (menu < 0 || menu > 3) {
                    System.out.println("\n올바르지 않은 메뉴입니다. 다음 보기 중 다시 선택해주세요.\n");
                    sc.nextLine();
                } // 메뉴 선택에 따른 반환값 처리
                if (menu == 1) {
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

    // 할 일 등록 사용자 입력 메소드
    static void addUserTodo(Scanner sc, TodoManager manager){

        // 사용자 입력 실행 및 종료 여부
        boolean inputName = false;

        //입력값 저장 변수
        String name = null;

        //할 일 입력
        while(!inputName) {
            System.out.print("\n할 일 : ");
            name = sc.nextLine();
            // 공백 제거 및 빈 문자열 검사
            if (name.trim().isEmpty()) {
                System.out.println("\n할 일을 입력해주세요.");
            }
            else inputName = true;
        }

        // 입력한 할 일 전달
        if(name != null){
            manager.addTodo(name);
        }
    }

    // 할 일 완료 처리 사용자 입력 메소드
    static int completeUserTodo(Scanner sc,TodoManager manager) {

        // 반복 종료 여부
        boolean quit = false;

        // 사용자 입력 번호
        int todoNum = -1;

        // 처음 3번 입장 시
        boolean first = false;

        // 입력번호 최대값 (최소값은 1)
        int maxTodoNum = manager.getTodoCount();

        while (!quit) {
            // 목록과 함께 안내문구 제공
            if(!first){System.out.println("\n목록에서 완료 처리할 할 일의 번호를 입력해주세요."); first=true;}
            manager.printTodoList();
            // 만약 리스트가 비어있다면 종료
            if (manager.isTodoListEmpty()) {
                quit = true;
                return -2;
            }
            System.out.print("\n번호 : ");


            // 번호 입력 형식 오류 처리
            if (!sc.hasNextInt()) {
                System.out.println("\n존재하지 않는 번호입니다. 번호를 다시 입력해주세요.");
                sc.nextLine();
            } else {
                int selectNum = sc.nextInt();
                // 번호 입력 범위 오류 처리
                if (selectNum < 1 || selectNum > maxTodoNum) {
                    System.out.println("\n존재하지 않는 번호입니다. 번호를 다시 입력해주세요.");
                    sc.nextLine();
                }else{
                    quit = true;
                    todoNum = selectNum;
                }
            }
        }
        return todoNum-1; //인덱스 값은 0부터 시작
    }
}
