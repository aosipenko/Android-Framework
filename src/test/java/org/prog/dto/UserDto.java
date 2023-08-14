package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.db.table.Persons;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String gender;
    private String nat;
    private NameDto name;
    private LoginDto login;

    public static UserDto fromTable(Persons persons) {
        return UserDto.builder()
                .gender(persons.getGender())
                .name(NameDto.builder()
                        .first(persons.getFirstName())
                        .last(persons.getLastName())
                        .title(persons.getTitle())
                        .build())
                .build();
    }

}
