package lile_manalu.spring_boot_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodSnapshotResponse {

    private String id;

    private String orderId;

    private String foodId;

    private String outletId;

    private String name;

    private String description;

    private Double price;

    private List<AddOnSnapshotResponse> addOnSnapshots;

}
