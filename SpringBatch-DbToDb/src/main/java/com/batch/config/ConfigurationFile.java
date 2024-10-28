//package com.batch.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.JpaPagingItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class ConfigurationFile {
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    public SourceRepository sourceRepository;
//
//    @Autowired
//    public TargetRepository targetRepository;
//
//    @Bean
//    public ItemReader<SourceEntity> itemReader() {
//        JpaPagingItemReader<SourceEntity> reader = new JpaPagingItemReader<>();
//        reader.setEntityManagerFactory(entityManagerFactory);
//        reader.setQueryString("SELECT s FROM SourceEntity s");
//        reader.setPageSize(10); // Adjust the page size as needed
//        return reader;
//    }
//
//    @Bean
//    public ItemProcessor<SourceEntity, TargetEntity> itemProcessor() {
//        return sourceEntity -> {
//            TargetEntity targetEntity = new TargetEntity();
//            // Perform data mapping and transformation here
//            targetEntity.setName(sourceEntity.getName());
//            targetEntity.setAge(sourceEntity.getAge());
//            targetEntity.setEmail(sourceEntity.getEmail());
//            return targetEntity;
//        };
//    }
//
//    @Bean
//    public ItemWriter<TargetEntity> itemWriter() {
//        JpaItemWriter<TargetEntity> writer = new JpaItemWriter<>();
//        writer.setEntityManagerFactory(entityManagerFactory);
//        return writer;
//    }
//
//    @Bean
//    public Step dataTransferStep() {
//        return stepBuilderFactory.get("dataTransferStep")
//            .<SourceEntity, TargetEntity>chunk(10) // Adjust chunk size as needed
//            .reader(itemReader())
//            .processor(itemProcessor())
//            .writer(itemWriter())
//            .build();
//    }
//
//    @Bean
//    public Job dataTransferJob() {
//        return jobBuilderFactory.get("dataTransferJob")
//            .incrementer(new RunIdIncrementer())
//            .start(dataTransferStep())
//            .build();
//    }
//}
//
