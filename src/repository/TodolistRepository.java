package repository;

import entity.TodoList;

public interface TodolistRepository {

    TodoList[] getAll();

    void add(TodoList todolist);

    void remove(Integer number);

}
