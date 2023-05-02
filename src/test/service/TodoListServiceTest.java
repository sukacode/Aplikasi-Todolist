package test.service;

import repository.TodoListRepositoryImpl;
import repository.TodolistRepository;
import services.TodoListServiceImp;
import services.TodoListServices;

public class TodoListServiceTest {
    public static void main(String[] args) {
    testShowTodoList();
    }

    public static void testShowTodoList(){
        TodolistRepository todolistRepository= new TodoListRepositoryImpl();
        TodoListServices todoListServices = new TodoListServiceImp(todolistRepository);

        todoListServices.showTodoList();
    }

}
