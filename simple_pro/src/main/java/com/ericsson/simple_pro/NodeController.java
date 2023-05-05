package com.ericsson.simple_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }


    //works
    @GetMapping("/api/v1/nodes")
    public ResponseEntity<?> allNodes() {
        return ResponseEntity.ok(nodeService.allNodes());
    }

    //works
    @GetMapping("/api/v1/node/{id}")
    public ResponseEntity<?> getNode(@PathVariable("id") long id) {
        return ResponseEntity.ok(nodeService.getNode(id));
    }


    //works
    @PostMapping("/api/v1/node")
    public ResponseEntity<?> createNode(@RequestBody Node node) {
        nodeService.createNode(node.getId(),node.getName(), node.getLocation(), node.getLatitude(), node.getLongitude());
        return new ResponseEntity<>(node, HttpStatus.OK);
    }



    //works
    @PutMapping("/api/v1/node/{id}")
    public ResponseEntity<?> updateNode(@PathVariable("id") long id,@RequestBody Node node) {
        return ResponseEntity.ok(nodeService.updateNode(id,node));
    }

    @DeleteMapping("/api/v1/node/{id}")
    public ResponseEntity<?> deleteNode(@PathVariable("id") long id) {
        return ResponseEntity.ok(nodeService.deleteNode(id));
    }

}
