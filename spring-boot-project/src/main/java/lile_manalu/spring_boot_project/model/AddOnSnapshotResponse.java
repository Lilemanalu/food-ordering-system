package lile_manalu.spring_boot_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOnSnapshotResponse {

    private String id;

    private String AddOnId;

    private String FoodSnapshotId;

    private String name;

    private String description;

    private Double price;

}
