package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodolistRepository {

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
    return data;
    }

    public boolean isFull(){
        var isFull = true;
        for ( var i = 0; i < data.length; i++){
            if (data[i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }


    @Override
    public void add(TodoList todolist) {
        // jika penuh, kita resize ukuran array 2x lipat
        if ( isFull() ){
            var temp = data;
            data = new TodoList[data.length * 2];

            for ( var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        } else {

        }

        for ( var i = 0; i < data.length; i++){
            if( data[i] == null){
                data[i] = todolist;
                break;
            }
        }

        // tambahkan ke posisi array yang NULL
    }

    @Override
    public void remove(Integer number) {

    }
}
