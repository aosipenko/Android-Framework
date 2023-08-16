package org.prog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.annotations.CustomAnnotation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBean {
    private String beanValue;
}
