package com.api.rest.controller;

import com.api.rest.dto.TodoDto;
import com.api.rest.entity.Todo;
import com.api.rest.service.TodoService;
import com.api.rest.util.TPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    @GetMapping
    public ResponseEntity<TPage<TodoDto>> getAll(Pageable pageable){

        TPage<TodoDto> todos = service.getAllPageable(pageable);

        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<TodoDto> save (@RequestBody TodoDto todo){
        return ResponseEntity.ok(service.save(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable(value = "id", required = true) Long id){
        TodoDto todo = service.getById(id);

        return ResponseEntity.ok(todo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update (@PathVariable(value = "id", required = true) Long id, @RequestBody TodoDto todo){
       todo = service.update(id, todo);
       return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoDto> delete(@PathVariable("id") Long id){
        TodoDto todo =  service.delete(id);
        return ResponseEntity.ok(todo);
    }
}
