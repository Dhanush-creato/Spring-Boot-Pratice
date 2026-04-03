package org.springexmaples.StudentMangament.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private Long roll_no;
    private String name;
    private Integer marks;
}
