package lile_manalu.spring_boot_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "add_ons")
public class AddOn {

    @Id
    private String id;

    private String food_id;

    private String name;

    private String description;

    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "food_id")
    private Food food;
}
