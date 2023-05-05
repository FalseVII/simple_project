package com.ericsson.simple_pro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node, Long> {

    Node findById(long id);

    List<Node> findAll();

    Node save(Node node);

    void deleteById(long id);

    void updateById(long id, Node node);

}
