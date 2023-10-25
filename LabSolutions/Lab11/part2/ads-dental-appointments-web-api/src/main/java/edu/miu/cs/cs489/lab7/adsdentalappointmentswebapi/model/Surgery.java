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
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Surgery's Number is required. And it cannot be null, empty or blank space(s)")
    private String surgeryNo;
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = true, unique = true)
    private Address address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
