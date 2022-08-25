package tech.echoing.bigdata.controller;


import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    @Autowired
    @Qualifier("requestTotalCountCollector")
    private Counter counter;

    @GetMapping("ddd")
    public Object deoi() {
        counter.labels("path1", "method1", "code1").inc();
        return "ok";
    }

}
