package com.api.rest.controller;

import com.api.rest.entity.Todo;
import com.api.rest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    @GetMapping
    public ResponseEntity<Page<Todo>> getAll(Pageable pageable){

        Page<Todo> todos = service.getAll(pageable);

        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> save (@RequestBody Todo todo){
        return ResponseEntity.ok(service.save(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable(value = "id", required = true) Long id){
        Todo todo = service.getById(id);

        return ResponseEntity.ok(todo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update (@PathVariable(value = "id", required = true) Long id, @RequestBody Todo todo){
       todo = service.update(id, todo);
       return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> delete(@PathVariable("id") Long id){
      Todo todo =  service.delete(id);
        return ResponseEntity.ok(todo);
    }
}
