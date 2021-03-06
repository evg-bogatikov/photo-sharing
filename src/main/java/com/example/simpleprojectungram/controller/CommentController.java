package com.example.simpleprojectungram.controller;

import com.example.simpleprojectungram.model.Comment;
import com.example.simpleprojectungram.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody @Valid Comment comment) {
        return commentService.addComment(comment).isPresent() ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable String id) {
        return new ResponseEntity<>(commentService.getCommentByPostId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(String id){
        Optional<Comment> commentById = commentService.getCommentById(id);
        return commentById.isPresent() ? new ResponseEntity<>(commentById.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
