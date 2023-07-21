package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameDto {

    private String title;
    private String first;
    private String last;

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }
}
