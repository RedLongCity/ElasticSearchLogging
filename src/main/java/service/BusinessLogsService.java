package service;

import entity.BusinessLog;

import java.sql.Timestamp;
import java.util.List;

public interface BusinessLogsService {

//    List<BusinessLog> getLogsByLevelAndAfterTimestamp(String level, Timestamp timestamp);

    List<BusinessLog> getLogsByLevel(String level);
}
