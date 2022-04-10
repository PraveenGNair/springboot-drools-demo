package com.praveen.drools.example.configuration;

import com.praveen.drools.example.service.CustomerCategorizeService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Drools Config.
 * @author Praveen.Nair
 */
@Configuration
public class DroolsConfig {

    private static final String RULES_CUSTOMER_RULES_DRL = "rules/customer-category.drl";

    @Bean
    public KieContainer kieContainer() {
        final KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    @Bean
    public CustomerCategorizeService customerCategorizeService(KieContainer kieContainer) {
        return new CustomerCategorizeService(kieContainer);
    }
}
