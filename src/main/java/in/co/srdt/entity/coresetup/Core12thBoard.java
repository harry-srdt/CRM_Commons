package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadAcademicDetailsTwelfth;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_12th_board")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Core12thBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long core12thBoardId;

    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "twelveBoard",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LeadAcademicDetailsTwelfth> leadAcademicDetailsTwelfths = new ArrayList<>();

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
