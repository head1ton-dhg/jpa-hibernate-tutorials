package com.youwiz.springbatchn1.config;

import com.youwiz.springbatchn1.domain.Store;
import com.youwiz.springbatchn1.domain.StoreHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.youwiz.springbatchn1.config.StoreBackupBatchConfiguration.JOB_NAME;

@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(name = "job.name", havingValue = JOB_NAME)
public class StoreBackupBatchConfiguration {

    public static final String JOB_NAME = "storeBackupBatch";
    private static final String STEP_NAME = JOB_NAME + "Step";

    private final EntityManagerFactory entityManagerFactory;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private static String ADDRESS_PARAM = null;

    @Bean
    public Job job() {
        return jobBuilderFactory.get(JOB_NAME)
                .start(step())
                .build();
    }

    @Bean
    @JobScope
    public Step step() {
        return stepBuilderFactory.get(STEP_NAME)
                .<Store, StoreHistory>chunk(chunkSize)
                .reader(reader(ADDRESS_PARAM))
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<Store> reader (
            @Value("#{jobParameters[address]}") String address
    ) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("address", address+"%");

        return new JpaPagingItemReaderBuilder<Store>()
                .pageSize(chunkSize)
                .parameterValues(parameters)
                .queryString("SELECT s FROM Store s WHERE s.address LIKE :address order by s.id")
                .entityManagerFactory(entityManagerFactory)
                .name("reader")
                .transacted(false)
                .build();
    }


    @Value("${chunkSize:2}")
    private int chunkSize;

    private static int count = 0;

    @Bean
    @StepScope
    public ItemProcessor<Store, StoreHistory> processor() {
        return item -> {
//            count++;
//            if (count > 2) {
//                throw new IllegalStateException();
//            }
            return new StoreHistory(item, item.getProducts(), item.getEmployees());
        };
    }

    public JpaItemWriter<StoreHistory> writer() {
        JpaItemWriter<StoreHistory> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
}
