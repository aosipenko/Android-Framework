package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultsDto {

    private List<UserDto> results;
//
//    public ResultsDto() {
//    }
//
//    public ResultsDto(List<UserDto> results) {
//        this.results = results;
//    }
//
//    public List<UserDto> getResults() {
//        return results;
//    }
//
//    public void setResults(List<UserDto> results) {
//        this.results = results;
//    }
}
