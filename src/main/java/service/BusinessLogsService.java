package service;

import entity.BusinessLog;
import entity.BusinessType;

import java.time.LocalDate;
import java.util.List;

public interface BusinessLogsService {

    List<BusinessLog> getLogsByLevelAndAfterTimestampAndBusinessType(String level, LocalDate timestamp, BusinessType businessType);

    List<BusinessLog> getLogsByLevel(String level);
}
