package com.ericsson.simple_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }


    @GetMapping("/api/v1/nodes")
    public ResponseEntity<?> allNodes() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/api/v1/node/{id}")
    public ResponseEntity<?> getNode() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/api/v1/node")
    public ResponseEntity<?> createNode(@RequestBody Node node) {
        nodeService.createNode(node.getId(),node.getName(), node.getLocation(), node.getLatitude(), node.getLongitude());
        return new ResponseEntity<>(node, HttpStatus.OK);
    }

    @PostMapping("/api/v1/node/{id}")
    public ResponseEntity<?> updateNode() {
        return ResponseEntity.ok("Hello World");
    }

    @DeleteMapping("/api/v1/node/{id}")
    public ResponseEntity<?> deleteNode() {
        return ResponseEntity.ok("Hello World");
    }

}
