package lile_manalu.spring_boot_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOnRequest {

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String food_id;

    private String name;

    private String description;

    private Double price;

}
