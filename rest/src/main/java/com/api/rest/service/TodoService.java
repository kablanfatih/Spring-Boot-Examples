package com.api.rest.service;

import com.api.rest.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoService {

    Page<Todo> getAll(Pageable pageable);

    Todo save(Todo todo);

    Todo getById(Long id);

    Todo update(Long id, Todo todo);

    Todo delete(Long id);
}
