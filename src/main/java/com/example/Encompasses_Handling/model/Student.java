package com.example.Encompasses_Handling.model;

import com.example.Encompasses_Handling.model.Address;
import com.example.Encompasses_Handling.model.Book;
import com.example.Encompasses_Handling.model.Course;
import com.example.Encompasses_Handling.model.Laptop;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;


    @OneToOne(cascade = CascadeType.ALL)
     private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Laptop> laptops = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();
}
