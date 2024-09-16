package edu.mum.cs.cs425.eRegistrar.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double cgpa;
    private LocalDate enrollmentDate;
    private boolean isInternational;

}