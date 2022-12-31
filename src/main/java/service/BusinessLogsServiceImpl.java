package service;

import entity.BusinessLog;
import entity.BusinessType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.BusinessLogRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("businessLogsService")
public class BusinessLogsServiceImpl implements BusinessLogsService {

    private final BusinessLogRepository repository;

    @Override
    public List<BusinessLog> getLogsByLevelAndAfterTimestampAndBusinessType(String level,
                                                                            LocalDate timestamp,
                                                                            BusinessType businessType) {
        List<BusinessLog> result = new ArrayList<>();

        int pageNum = 0;
        Pageable pageable = PageRequest.of(pageNum, 10);
        Page<BusinessLog> page;

        do {
            page = repository.findBusinessLogByLevelEqualsAndTimestampAfterAndBusinessType(level, timestamp, businessType, pageable);
            List<BusinessLog> content = page.getContent();

            if (!CollectionUtils.isEmpty(content))
                result.addAll(content);

            pageable = PageRequest.of(++pageNum, 10);
        }
        while (!page.isEmpty());

        return result;
    }

    @Override
    public List<BusinessLog> getLogsByLevel(String level) {
        List<BusinessLog> result = new ArrayList<>();

        int pageNum = 0;
        Pageable pageable = PageRequest.of(pageNum, 10);
        Page<BusinessLog> page;

        do {
            page = repository.findBusinessLogByLevelEquals(level, pageable);
            List<BusinessLog> content = page.getContent();

            if (!CollectionUtils.isEmpty(content))
                result.addAll(content);

            pageable = PageRequest.of(++pageNum, 10);
        }
        while (!page.isEmpty());

        return result;
    }

}
