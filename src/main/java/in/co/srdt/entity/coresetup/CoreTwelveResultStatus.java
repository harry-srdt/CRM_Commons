package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="core_twelve_result_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreTwelveResultStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long twelveMarkingSchemeId;

    @Column(length = 50,unique = true)
    private String name;

    @Column(length = 200)
    private String displayName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

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
