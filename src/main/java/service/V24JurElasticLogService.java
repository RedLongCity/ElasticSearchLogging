package service;

import entity.V24JurLog;

import java.util.List;

public interface V24JurElasticLogService {

    List<V24JurLog> getLogsByLevel(String level);

}
