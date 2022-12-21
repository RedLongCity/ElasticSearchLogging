package service;

import entity.V24JurLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.V24JurRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("v24JurElasticLogService")
public class V24JurElasticLogServiceImpl implements V24JurElasticLogService {

    private final V24JurRepository repository;

    @Override
    public List<V24JurLog> getLogsByLevel(String level) {
        List<V24JurLog> result = new ArrayList<>();

        int page = 0;
        Pageable pageable = PageRequest.of(page, 10);
        Page<V24JurLog> v24JurLogsPage = null;

        do {
            v24JurLogsPage = repository.findV24JurLogsByLevelEquals(level, pageable);
            List<V24JurLog> content = v24JurLogsPage.getContent();

            if (!CollectionUtils.isEmpty(content))
                result.addAll(content);

            pageable = PageRequest.of(++page, 10);
        }
        while (!v24JurLogsPage.isEmpty());

        return result;
    }


}
