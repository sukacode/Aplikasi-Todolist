package test.service;

import entity.TodoList;
import repository.TodoListRepositoryImpl;
import repository.TodolistRepository;
import services.TodoListServiceImp;
import services.TodoListServices;

public class TodoListServiceTest {
    public static void main(String[] args) {
    testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todolistRepository= new TodoListRepositoryImpl();
        todolistRepository.data[0] = new TodoList("Dasar");
        todolistRepository.data[1] = new TodoList("OOP");
        todolistRepository.data[2] = new TodoList("Standart Classes");

        TodoListServices todoListServices = new TodoListServiceImp(todolistRepository);

        todoListServices.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        TodoListServices todoListServices = new TodoListServiceImp(todoListRepository);

        todoListServices.addTodoList("Dasar");
        todoListServices.addTodoList("OOP");
        todoListServices.addTodoList("Standart Classes");

        todoListServices.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        TodoListServices todoListServices = new TodoListServiceImp(todoListRepository);

        todoListServices.addTodoList("Dasar");
        todoListServices.addTodoList("OOP");
        todoListServices.addTodoList("Standart Classes");

        todoListServices.removeTodoList(2);

        todoListServices.showTodoList();
    }

}
