package day02;

public class Todo {
    private String name; // 할일 이름
    private boolean complete; // 완료 여부

    // 생성자
    Todo(String name, boolean complete){
        this.name = name;
        this.complete = complete;
    }

    // getter
    String getName(){
        return name;
    }
    Boolean getComplete(){
        return complete;
    }
    //setter
    void setComplete(Boolean complete){
        this.complete = complete;
    }
}
