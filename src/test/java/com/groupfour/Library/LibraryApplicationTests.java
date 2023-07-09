package com.groupfour.Library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

@SpringBootTest
@RunAs("LibraryApplication.class")
public class LibraryApplicationTests {

    @Test
    void contextLoads() {
    }

}
