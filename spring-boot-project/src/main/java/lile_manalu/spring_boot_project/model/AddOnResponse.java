package lile_manalu.spring_boot_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOnResponse {

    private String id;

    private String food_id;

    private String name;

    private String description;

    private Double price;
}
