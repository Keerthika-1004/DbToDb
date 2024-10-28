//package com.batch.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.batch.pojo.SourceData;
//import com.batch.pojo.TargetData;
//import com.batch.rowmapper.DataModelRowMapper;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//	private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    
//    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//    
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    DataSource dataSource() {
//        return new DriverManagerDataSource();
//    }
//    
//    @Bean
//    Job copyDataJob() {
//        return jobBuilderFactory.get("copyDataJob")
//            .start(copyDataStep())
//            .build();
//    }
//
//    @Bean
//    Step copyDataStep() {
//        return stepBuilderFactory.get("copyDataStep")
//            .<SourceData, TargetData>chunk(100)
//            .reader(sourceDataReader())
//            .writer(targetDataWriter())
//            .build();
//    }
//
//    @Bean
//    JdbcCursorItemReader<SourceData> sourceDataReader() {
//    	  JdbcCursorItemReader<SourceData> reader = new JdbcCursorItemReader<>();
//          reader.setDataSource(dataSource());
//          reader.setSql("SELECT * FROM source");
//          reader.setRowMapper(new DataModelRowMapper());
//          return reader;    }
//
//    @Bean
//    JdbcBatchItemWriter<TargetData> targetDataWriter() {
//    	JdbcBatchItemWriter<TargetData> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource());
//        writer.setSql("INSERT INTO target (id, name) VALUES (:id, :name)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;    }
//}
