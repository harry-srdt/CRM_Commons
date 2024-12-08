package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="core_general_variable_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreGeneralVariableValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreGeneralVariableValuesId;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String displayName;

    @Column(columnDefinition = "TEXT")
    private String sqlText;

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
