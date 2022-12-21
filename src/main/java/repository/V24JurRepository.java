package repository;

import entity.V24JurLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface V24JurRepository extends ElasticsearchRepository<V24JurLog, String> {

    Page<V24JurLog> findV24JurLogsByLevelEquals(String level, Pageable pageable);

}
