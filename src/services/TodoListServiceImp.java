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

        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if( todo != null){
                System.out.println(no + ". " + todo );
            }
        }
    }

    @Override
    public void addTodoList() {

    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
