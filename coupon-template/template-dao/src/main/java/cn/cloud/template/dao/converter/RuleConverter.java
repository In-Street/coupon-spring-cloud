package cn.cloud.template.dao.converter;

import cn.cloud.template.api.beans.rules.TemplateRule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 12:00
 **/
@Converter
public class RuleConverter implements AttributeConverter<TemplateRule,String> {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        try {
            return objectMapper.writeValueAsString(templateRule);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TemplateRule convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, TemplateRule.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
