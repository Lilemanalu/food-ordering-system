package lile_manalu.spring_boot_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foods")
public class Food {

    @Id
    private String id;

    private String outlet_id;

    private String name;

    private String description;

    private Double price;
}
