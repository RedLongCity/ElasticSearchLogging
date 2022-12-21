package entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "v24jur", createIndex = false)
public class V24JurLog {

    @Id
    private String id;

    private String level;

    private String message;

}
