package com.springnovel.config;

import com.springnovel.payment.springmixed.PaymentActionMixed;
import com.springnovel.perfectlogger.ConsoleLogger;
import com.springnovel.perfectlogger.ILogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentJavaConfig {

    @Bean
    public ILogger getIlogger() {
        return new ConsoleLogger();
    }

    @Bean
    public PaymentActionMixed getPaymentActionMixed(ILogger logger) {
        return new PaymentActionMixed(logger);
    }
}
