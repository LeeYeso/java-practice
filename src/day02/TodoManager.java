package day02;

import java.util.ArrayList;

public class TodoManager {
    private ArrayList<Todo> todoList=new ArrayList<>(); //할 일 리스트 생성

    // 할 일 목록 반 사이즈 반환 메서드
    int getTodoCount() {
        return todoList.size();
    }

    // 할 일 목록이 비어 있는지 반환
    boolean isTodoListEmpty() {
        return todoList.isEmpty();
    }

    // 할 일 등록 메서드
    void addTodo(String name){

        // 초기 할 일 완료 여부는 false
        boolean complete = false;
        //사용자 할일 받아서 리스트로 저장
        Todo todo = new Todo(name, complete);
        todoList.add(todo);
    }

    // 할 일 목록 출력 메서드
    void printTodoList(){

        // 할 일 목록 번호
        int index = 1;
        // 완료/미완료 텍스트 구분(기본값 미완료)
        String completeText = "미완료";

        // 할 일 목록 출력
        System.out.println("\n===== Todo List =====");

        // 등록된 할 일이 없다면 안내 문구 출력
        if (todoList.isEmpty()) {
            System.out.println("등록된 할 일이 없습니다. 할 일을 등록해주세요.\n");
        }
            for (Todo todo : todoList) {
                // 완료 상태라면 완료로 텍스트 변경
                if(todo.getComplete()==true){completeText="완료";}
                else completeText="미완료";
                System.out.println(index + ". " + todo.getName() +
                        " [ " + completeText +" ] "
                );
                index += 1;

            }
    }

    // 할 일의 완료 여부를 변경
    void markAsCompleted(int todoNum){
            // 사용자가 입력한 번호의 할 일 완료 여부를 변경 (미완료 -> 완료)
            todoList.get(todoNum).setComplete(true);
    }
}
