package day01;

import java.util.ArrayList;

public class ExpenseManager {
    //클래스 필드
    private ArrayList<Expense> expenses = new ArrayList<>();; // 지출 항목 리스트

    //클래스 메서드
    // 지출 항목 등록
    void addExpense(String name, int amount, String category)
    {
        // 사용자 정보 입력 받아서 리스트 생성
        Expense expense = new Expense(name, amount, category);
        expenses.add(expense);
    }
    // 지출 목록 조회
   void printExpenses()
   {
       // 출력할 항목 인덱스
       int index =1;
       // 지출 목록 출력
       System.out.println("\n===== 지출 내역 =====\n");
       // 지출 내역 유무 확인
       if (expenses.isEmpty()) {
           System.out.println("지출 내역이 없습니다. 지출 항목을 추가해주세요.\n");
       }
           for (Expense expense : expenses) {
                   System.out.println(index + ". "+expense.getName()+
                           " | "+expense.getAmount()+
                           " | "+expense.getCategory() +"\n"
                   );
                   index +=1;
           }
   }
   // 총 지출 조회
   int calculateTotalAmount()
   {
       int totalAmount = 0;
           //총 지출 계산 후 반환
           for (Expense expense : expenses) {
               totalAmount += expense.getAmount();
           }
           return totalAmount;
       }
}
