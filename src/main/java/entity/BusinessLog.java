package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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

    //    @Field(name = "_source.@timestamp")
//    @JsonProperty("@timestamp")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//    @Field(type = FieldType.Date, name = "@timestamp", format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//    private LocalDate timestamp;

    //    @Field(name = "_source.@timestamp")
//    @JsonProperty("@timestamp")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//    @Field(type = FieldType.Date, name = "@timestamp", format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//    private Instant timestamp;

}
