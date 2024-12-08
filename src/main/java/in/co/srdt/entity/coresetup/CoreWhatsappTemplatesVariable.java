package in.co.srdt.entity.coresetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "core_whatsapp_template_variable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreWhatsappTemplatesVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coreWhatsappTemplatesVariableId;

    @ManyToOne
    @JoinColumn(name = "core_whatsapp_templates_id")
    private CoreWhatsappTemplates whatsappTemplates;

    @OneToOne()
    @JoinColumn(name = "core_whatsapp_templates_var_value_id")
    private CoreGeneralVariableValues generalVariableValues;

    private short sequence;

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
