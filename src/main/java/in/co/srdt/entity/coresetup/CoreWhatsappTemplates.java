package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.co.srdt.enums.TemplateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "core_whatsapp_templates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreWhatsappTemplates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreWhatsappTemplatesId;

    @OneToOne(mappedBy = "whatsappTemplates",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CoreWhatsappMediaAttachment coreWhatsappMediaAttachment;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String displayName;

    private String vendorTemplateId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TemplateType templateType;

    private String content;

    @Column(nullable = false)
    private Boolean isVariableUsed;

    @Column(nullable = false)
    private Boolean isMediaAttached;

    @OneToMany(mappedBy = "whatsappTemplates",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CoreWhatsappTemplatesVariable> whatsappTemplatesVariables = new ArrayList<>();

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
