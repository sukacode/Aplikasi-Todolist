package services;

import entity.TodoList;
import repository.TodolistRepository;

public class TodoListServiceImp implements TodoListServices {

    private TodolistRepository todolistRepository;

    public TodoListServiceImp(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todolistRepository.getAll();

        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++){
            var todoList = model[i];
            var no = i + 1;

            if( todoList != null){
                System.out.println(no + ". " + todoList.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todolist = new TodoList(todo);
        todolistRepository.add(todolist);
        System.out.println("Sukses Menambahkan TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
