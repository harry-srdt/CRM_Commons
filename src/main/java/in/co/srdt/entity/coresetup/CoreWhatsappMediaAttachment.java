package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "core_whatsapp_media_attachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreWhatsappMediaAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreWhatsappMediaAttachmentId;

    @OneToOne
    @JoinColumn(name = "coreWhatsappTemplatesId")
    private CoreWhatsappTemplates whatsappTemplates;

    private String type;

    private String url;

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
