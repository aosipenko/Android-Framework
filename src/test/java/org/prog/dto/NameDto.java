package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NameDto {

    private String title;
    private String first;
    private String last;

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }
}
