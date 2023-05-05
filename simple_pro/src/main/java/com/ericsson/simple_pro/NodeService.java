package com.ericsson.simple_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public String allNodes() {
        return "Hello World";
    }

    public String getNode(long id) {
        return "Hello World";
    }

    public String createNode(long id, String name, String location, int latitude, int longitude ) {
        Node node = new Node(id, name, location, latitude, longitude);
        nodeRepository.save(node);
        return "Node saved.";
    }

    public String updateNode(Node node) {
        return "Hello World";
    }

    public String deleteNode(long id) {
        return "Hello World";
    }

}
