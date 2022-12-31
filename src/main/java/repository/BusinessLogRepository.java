package repository;

import entity.BusinessLog;
import entity.BusinessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BusinessLogRepository extends ElasticsearchRepository<BusinessLog, String> {

    Page<BusinessLog> findBusinessLogByLevelEqualsAndTimestampAfterAndBusinessType(String level,
                                                                                   LocalDate timestamp,
                                                                                   BusinessType businessType,
                                                                                   Pageable pageable);

    Page<BusinessLog> findBusinessLogByLevelEquals(String level,
                                                   Pageable pageable);

}
