package org.prog.db.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Persons")
public class Persons {

    @Id
    @Column(name = "PersonID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "Gender")
    private String gender;
}
