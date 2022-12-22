import com.google.common.collect.Lists;
import config.BeanConfiguration;
import entity.BusinessLog;
import entity.BusinessType;
import entity.V24JurLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BusinessLogsService;
import service.V24JurElasticLogService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

//    private static final Logger log = LogManager.getLogger(Main.class);

    private static final Logger logConsole
            = LoggerFactory.getLogger(Main.class);
    private static final Logger logStash
            = LoggerFactory.getLogger("stash");
    private static final Logger logStash_Business_Type1
            = LoggerFactory.getLogger("stash_business_type_1");
    private static final Logger logStash_Business_Type2
            = LoggerFactory.getLogger("stash_business_type_2");
    private static final Logger logStash_Business_Type3
            = LoggerFactory.getLogger("stash_business_type_3");

    public static void main(String[] args) throws InterruptedException {
        logging();
        Thread.sleep(5000);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        BusinessLogsService service = ctx.getBean("businessLogsService", BusinessLogsService.class);
        LocalDate timestamp = LocalDate.now().minusDays(1);

        List<BusinessLog> logs = service.getLogsByLevelAndAfterTimestamp("INFO", timestamp);
        Map<BusinessType, List<BusinessLog>> groupedByBusinessType = logs.stream()
                .collect(Collectors.groupingBy(BusinessLog::getBusinessType));

        assert groupedByBusinessType.containsKey(BusinessType.BUSINESS_TYPE_1);
        assert groupedByBusinessType.containsKey(BusinessType.BUSINESS_TYPE_2);
        assert groupedByBusinessType.containsKey(BusinessType.BUSINESS_TYPE_3);

    }


    private static void logging() {
        logStash_Business_Type1.info("business_type_1_message");
        logStash_Business_Type2.info("business_type_2_message");
        logStash_Business_Type3.info("business_type_3_message");
    }

}
