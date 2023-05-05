package com.ericsson.simple_pro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {


    List<Node> findAll();


    Node save(Node node);

    void deleteById(long id);

    List<Node> findAllById(long id);

    Node findById(long id);


}
