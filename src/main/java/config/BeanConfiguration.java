package config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"service"})
@EnableElasticsearchRepositories(basePackages = "repository")
public class BeanConfiguration {

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
//                new HttpHost("0.0.0.0", 12345)).build();
                new HttpHost("localhost", 9200)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);

        SimpleElasticsearchMappingContext simpleElasticsearchMappingContext = new SimpleElasticsearchMappingContext();
        ElasticsearchConverter elasticsearchConverter = new MappingElasticsearchConverter(simpleElasticsearchMappingContext);

        return new ElasticsearchTemplate(client, elasticsearchConverter);
    }

}
