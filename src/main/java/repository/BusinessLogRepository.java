package repository;

import entity.BusinessLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface BusinessLogRepository extends ElasticsearchRepository<BusinessLog, String> {

//    Page<BusinessLog> findBusinessLogByLevelEqualsAndTimestampAfter(String level,
//                                                                    Timestamp timestamp,
//                                                                    Pageable pageable);

    Page<BusinessLog> findBusinessLogByLevelEquals(String level,
                                                   Pageable pageable);

}
