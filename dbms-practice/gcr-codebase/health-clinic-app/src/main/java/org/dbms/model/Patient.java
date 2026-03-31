package org.dbms.model;

import lombok.*;
import org.dbms.annotations.FieldPrompt;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private long id;

    @FieldPrompt(message = "Enter patient name", allowSpaces = true)
    private String name;

    @FieldPrompt(message = "Enter DOB (yyyy-MM-dd)", allowSpaces = false)
    private LocalDate dob;

    @FieldPrompt(
            message = "Enter phone (10 digits)",
            allowSpaces = false,
            regex = "\\d{10}"
    )
    private String phone;

    @FieldPrompt(
            message = "Enter email",
            allowSpaces = false,
            regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    )
    private String email;

    @FieldPrompt(message = "Enter address", allowSpaces = true)
    private String address;

    @FieldPrompt(
            message = "Enter blood group (A+, O-, etc)",
            allowSpaces = false,
            regex = "^(A|B|AB|O)[+-]$"
    )
    private String bloodGroup;
}
