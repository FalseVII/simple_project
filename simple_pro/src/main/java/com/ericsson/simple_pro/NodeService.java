package com.ericsson.simple_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeService {
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public List<Node> getNode(long id) {
        return nodeRepository.findAllById(id);
    }

    public List<Node> allNodes() {
        return nodeRepository.findAll();
    }

    public String createNode(long id, String name, String location, int latitude, int longitude ) {
        Node node = new Node(id, name, location, latitude, longitude);
        nodeRepository.save(node);
        return "Node saved.";
    }

    public String updateNode(long id,Node node) {
        Node nodeToUpdate = nodeRepository.findById(id);
        if(nodeToUpdate == null) {
            return "Node not found.";
        }
        nodeToUpdate.setName(node.getName());
        nodeToUpdate.setLocation(node.getLocation());
        nodeToUpdate.setLatitude(node.getLatitude());
        nodeToUpdate.setLongitude(node.getLongitude());
        nodeRepository.save(nodeToUpdate);
        return "Node updated.";
    }

    public String deleteNode(long id) {
        nodeRepository.deleteById(id);
        return "Node deleted.";
    }

}
