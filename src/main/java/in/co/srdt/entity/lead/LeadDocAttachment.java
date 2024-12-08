package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.coresetup.CoreDocAttachmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_doc_attachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDocAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadDocAttachmentId;

    @ManyToOne
    @JoinColumn(name = "coreDocAttachmentTypeId")
    private CoreDocAttachmentType coreDocAttachmentType;

    @Column(length = 100)
    private String name;

    private Long leadCaptureId;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    @Column(length = 20)
    private String createdBy;

    @JsonIgnore
    @Column(length = 20)
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
