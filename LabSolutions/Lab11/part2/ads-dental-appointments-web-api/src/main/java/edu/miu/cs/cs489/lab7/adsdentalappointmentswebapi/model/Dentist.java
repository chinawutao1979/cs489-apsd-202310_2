package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    @Column(nullable = false)
    @NotBlank(message = "Dentist's FirstName is required. And it cannot be null, empty or blank space(s)")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Dentist's LastName is required. And it cannot be null, empty or blank space(s)")
    private String lastName;
    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;
}
