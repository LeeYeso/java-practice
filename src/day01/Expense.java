package day01;

public class Expense {

    //클래스 필드
    private String name; //지출 항목
    private int amount; //지출 금액
    private String category; //지출 카테고리

    //클래스 메서드
    Expense(String name, int amount, String category)
    {
        this.name = name; this.amount = amount; this.category = category;
    }//생성자

    // getter 메소드
    String getName(){
        return name;
    }
    int getAmount(){
        return amount;
    }
    String getCategory(){
        return category;
    }
}
