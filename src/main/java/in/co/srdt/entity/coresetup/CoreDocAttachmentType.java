package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.entity.lead.LeadDocAttachment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "core_doc_attachment_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreDocAttachmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreDocAttachmentTypeId;

    @OneToMany(mappedBy = "coreDocAttachmentType",cascade = CascadeType.ALL)
    private List<LeadDocAttachment> leadDocAttachmentList;

    @Column(length = 100)
    private String name;

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
