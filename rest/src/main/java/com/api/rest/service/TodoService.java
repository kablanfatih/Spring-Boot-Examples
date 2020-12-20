package com.api.rest.service;

import com.api.rest.dto.TodoDto;
import com.api.rest.util.TPage;
import org.springframework.data.domain.Pageable;

public interface TodoService {

    TPage<TodoDto> getAllPageable(Pageable pageable);

    TodoDto save(TodoDto todo);

    TodoDto getById(Long id);

    TodoDto update(Long id, TodoDto todo);

    TodoDto delete(Long id);
}
