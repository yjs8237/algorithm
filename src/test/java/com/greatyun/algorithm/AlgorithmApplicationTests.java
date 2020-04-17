package com.greatyun.algorithm;

import com.greatyun.algorithm.binaryTree.BinaryTreeSearch;
import com.greatyun.algorithm.binaryTree.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class AlgorithmApplicationTests {

    @Autowired
    BinaryTreeSearch binaryTreeSearch;

    @Test
    void contextLoads() {
        Node node = binaryTreeSearch.makeNode(1, null, null);
        binaryTreeSearch.setRoot(node);
        log.info("Test class");
        assertThat(binaryTreeSearch.getRoot()).isEqualTo(node);
    }

}
