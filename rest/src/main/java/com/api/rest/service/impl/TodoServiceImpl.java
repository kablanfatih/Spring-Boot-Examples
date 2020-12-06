package com.api.rest.service.impl;

import com.api.rest.entity.Todo;
import com.api.rest.repository.TodoRepository;
import com.api.rest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl  implements TodoService {

    @Autowired
    private final TodoRepository repository ;

    @Override
    public Page<Todo> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    @Override
    public Todo save(Todo todo) {

        todo = repository.save(todo);

        return todo;
    }

    @Override
    public Todo getById(Long id) {
        Todo todo = null;
        try {
            todo = repository.getOne(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return todo;

    }

    @Override
    public Todo update(Long id, Todo todo) {
        Todo reqTodo = repository.getOne(id);

        reqTodo.setAd(todo.getAd());
        reqTodo.setTodo(todo.getTodo());
        reqTodo.setDate(todo.getDate());
        repository.save(reqTodo);
        return reqTodo;
    }

    @Override
    public Todo delete(Long id) {
        Todo todo = repository.getOne(id);
        repository.deleteById(id);
        return todo;
    }
}
