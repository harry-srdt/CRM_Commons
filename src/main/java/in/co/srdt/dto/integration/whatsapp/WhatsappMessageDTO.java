package in.co.srdt.dto.integration.whatsapp;

import lombok.Data;

@Data
public class WhatsappMessageDTO {

    private String templateId;
    private String from;
    private String to;
    private Message message;
    private MediaAttachment mediaAttachment;

}
