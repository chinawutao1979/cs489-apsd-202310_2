package edu.miu.cs.cs489.lab7.adsdentalappointmentswebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Patient's Number is required")
    private String patientNo;

    @Column(nullable = false)
    @NotBlank(message = "Patient's FirstName is required. And it cannot be null, empty or blank space(s)")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Patient's LastName is required. And it cannot be null, empty or blank space(s)")
    private String lastName;
    private LocalDate dateOfBirth;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address primaryAddress;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("patientId=").append(patientId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", primaryAddress=").append(primaryAddress);
        sb.append('}');
        return sb.toString();
    }
}
