package service;

import entity.BusinessLog;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface BusinessLogsService {

    List<BusinessLog> getLogsByLevelAndAfterTimestamp(String level, LocalDate timestamp);

    List<BusinessLog> getLogsByLevel(String level);
}
