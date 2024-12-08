package in.co.srdt.repository.core;

import in.co.srdt.entity.coresetup.CoreWhatsappTemplates;
import in.co.srdt.entity.coresetup.CoreWhatsappTemplatesVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreWhatsappTemplatesVariableRepository extends JpaRepository<CoreWhatsappTemplatesVariable,Long> {

/*    @Query(value = "SELECT * FROM core_whatsapp_template_variable WHERE core_whatsapp_templates_id = :templateId ORDER BY sequence", nativeQuery = true)
    List<CoreWhatsappTemplatesVariable> findByTemplateIdOrderedBySequence(Long templateId);*/

    List<CoreWhatsappTemplatesVariable> findByWhatsappTemplatesOrderBySequence(CoreWhatsappTemplates whatsappTemplate);
}
