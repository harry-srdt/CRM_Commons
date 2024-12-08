package in.co.srdt.entity.lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lead_notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadNotesId;

    @ManyToOne()
    @JoinColumn(name = "leadCaptureId")
    private LeadCapture leadCapture;

    @Lob
    private String note;

    @JoinColumn(name = "leadDocAttachmentId")
    @OneToOne(cascade = CascadeType.ALL )
    private LeadDocAttachment leadDocAttachment;

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
