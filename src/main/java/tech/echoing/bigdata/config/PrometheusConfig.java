package tech.echoing.bigdata.config;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrometheusConfig {
    @Autowired
    private CollectorRegistry collectorRegistry;

    @Bean
    public Counter requestTotalCountCollector(){
        return  Counter.build()
                .name("http_requests_total")
                .labelNames("path", "method", "code")
                .help("http请求总计数").register(collectorRegistry);
    }
}