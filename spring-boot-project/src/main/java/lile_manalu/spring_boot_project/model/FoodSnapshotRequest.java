package lile_manalu.spring_boot_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodSnapshotRequest {

    @JsonIgnore
    private String orderId;

    @JsonIgnore
    private String foodId;

    @JsonIgnore
    private String outletId;

    private String name;

    private String description;

    private Double price;

    private List<AddOnSnapshotResponse> addOnSnapshots;

}
