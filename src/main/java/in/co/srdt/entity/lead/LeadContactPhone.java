package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lead_contact_phone")
public class LeadContactPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadContactPhoneId;
    private String contactName;
    private String contactRelation;
    private String contactNumber;
    private boolean isPrimary;

    @ManyToOne
    @JoinColumn(name = "lead_capture_id")
    private LeadCapture leadCapture;

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
