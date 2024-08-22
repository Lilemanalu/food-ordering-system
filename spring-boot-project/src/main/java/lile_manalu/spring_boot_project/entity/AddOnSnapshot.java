package lile_manalu.spring_boot_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "add_on_snapshots")
public class AddOnSnapshot {

    @Id
    private String id;

    private String addOnId;

    private String foodSnapshotId;

    private String name;

    private String description;

    private Double price;

    private Date createdTime;
}
