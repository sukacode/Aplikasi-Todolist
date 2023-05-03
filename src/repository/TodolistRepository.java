package repository;

import entity.TodoList;

public interface TodolistRepository {

    TodoList[] getAll();

    void add(TodoList todolist);

    boolean remove(Integer number);

}
