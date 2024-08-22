package lile_manalu.spring_boot_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @JsonIgnore
    private String userId;

    @JsonIgnore
    private String outletId;

    private List<FoodSnapshotResponse> foodSnapshots;

}
