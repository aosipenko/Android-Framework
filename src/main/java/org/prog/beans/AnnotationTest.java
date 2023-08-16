package org.prog.beans;

import org.prog.annotations.CustomAnnotation;
import org.springframework.stereotype.Component;

@Component
public class AnnotationTest {

    @CustomAnnotation(value = "--replace")
    public void smth(String s) {
        System.out.println(s);
    }

    @CustomAnnotation(value = "--replace another")
    public void anotherMethod(String s) {
        System.out.println(s);
    }
}
