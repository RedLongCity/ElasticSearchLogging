package json;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import entity.BusinessType;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.FieldNamesAware;
import net.logstash.logback.composite.JsonWritingUtils;
import net.logstash.logback.fieldnames.LogstashFieldNames;

import java.io.IOException;

@Slf4j
public class BusinessTypeJsonProvide extends AbstractFieldJsonProvider<ILoggingEvent> implements FieldNamesAware<LogstashFieldNames> {

    private final String FIELD_MESSAGE = "businessType";
    private BusinessType businessType;

    public BusinessTypeJsonProvide() {
        setFieldName(FIELD_MESSAGE);
    }

    @Override
    public void setFieldNames(LogstashFieldNames fieldNames) {
        setFieldName(fieldNames.getMessage());
    }

    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent iLoggingEvent) throws IOException {
        JsonWritingUtils.writeStringField(generator, getFieldName(), businessType.toString());
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

}
