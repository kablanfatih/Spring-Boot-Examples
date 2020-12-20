package com.api.rest.service.impl;

import com.api.rest.dto.TodoDto;
import com.api.rest.entity.Todo;
import com.api.rest.repository.TodoRepository;
import com.api.rest.service.TodoService;
import com.api.rest.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public TPage<TodoDto> getAllPageable(Pageable pageable) {
        Page<Todo> todo = repository.findAll(pageable);
        TPage page = new TPage<TodoDto>();
        TodoDto[] dtos = modelMapper.map(todo.getContent(), TodoDto[].class);
        page.setStat(todo, Arrays.asList(dtos));
        return page;
    }

    @Override
    public TodoDto save(TodoDto todoDto) {

        Todo todo = new Todo();
        todo.setName(todoDto.getName());
        todo.setTodo(todoDto.getTodo());
        todo.setDate(todoDto.getDate());
        final Todo todoDb = repository.save(todo);
        todo.setId(todoDb.getId());

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto getById(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(todo, TodoDto.class);

    }

    @Override
    public TodoDto update(Long id, TodoDto todoDto) {
        Todo todo = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        todo.setName(todoDto.getName());
        todo.setTodo(todoDto.getTodo());
        todo.setDate(todoDto.getDate());
        todo = repository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto delete(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        repository.deleteById(id);
        return modelMapper.map(todo, TodoDto.class);
    }
}
