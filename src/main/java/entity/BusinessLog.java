package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "v24jur", createIndex = false)
public class BusinessLog {

    @Id
    private String id;

    private String level;

    private String message;

    private BusinessType businessType;

    @Field(type = FieldType.Date_Nanos, name = "@timestamp", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'")
    private LocalDate timestamp;

}
