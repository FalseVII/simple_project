package com.ericsson.simple_pro;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NodeController {

    @GetMapping("/api/vi/nodes")
    public ResponseEntity<?> allNodes() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/api/vi/node/{id}")
    public ResponseEntity<?> getNode() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/api/vi/node")
    public ResponseEntity<?> createNode() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/api/vi/node/{id}")
    public ResponseEntity<?> updateNode() {
        return ResponseEntity.ok("Hello World");
    }

    @DeleteMapping("/api/vi/node/{id}")
    public ResponseEntity<?> deleteNode() {
        return ResponseEntity.ok("Hello World");
    }

}
