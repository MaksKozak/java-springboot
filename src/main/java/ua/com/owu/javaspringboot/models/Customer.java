package ua.com.owu.javaspringboot.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ua.com.owu.javaspringboot.models.views.Views;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Admin.class})
    private int id;
    @NotEmpty
    @Length(min=3, max=13, message = "aaaaaaaaaaahhha")
    @JsonView({Views.Admin.class, Views.Client.class})
    private String name;
    @JsonView({Views.Admin.class})
    private String surname;
    @JsonView({Views.Admin.class})
    private String email;

}

