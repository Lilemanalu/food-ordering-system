package lile_manalu.spring_boot_project.model;

import lile_manalu.spring_boot_project.entity.AddOn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFoodResponse {

    private String id;

    private String outlet_id;

    private String name;

    private String description;

    private Double price;

    private List<AddOnResponse> addOns;

}
