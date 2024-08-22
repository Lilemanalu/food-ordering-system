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
public class OrderResponse {

    private String id;

    private String userId;

    private String outletId;

    private List<FoodSnapshotResponse> foodSnapshots;
}
