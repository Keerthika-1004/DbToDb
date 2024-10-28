//package com.batch.config;
//
//import javax.sql.DataSource;
//
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//
//import com.batch.pojo.SourceData;
//import com.batch.pojo.TargetData;
//
//@Configuration
//@EnableBatchProcessing
//public class ConfigFile {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("sourceDataSource")
//    private DataSource sourceDataSource;
//
//    @Autowired
//    @Qualifier("targetDataSource")
//    private DataSource targetDataSource;
//
////    @Autowired
////    private DataSource dataSource;
//    
//    @Bean
//    public Job transferDataJob() {
//        return jobBuilderFactory.get("transferDataJob")
//            .start(transferDataStep())
//            .build();
//    }
//
//    @Bean
//    public Step transferDataStep() {
//        return stepBuilderFactory.get("transferDataStep")
//            .<SourceData, TargetData>chunk(100)
//            .reader(sourceDataReader())
//            .writer(targetDataWriter())
//            .build();
//    }
//
//    @Bean
//    public JdbcCursorItemReader<SourceData> sourceDataReader() {
//        JdbcCursorItemReader<SourceData> reader = new JdbcCursorItemReader<>();
//        reader.setDataSource(sourceDataSource);
//        reader.setSql("SELECT * FROM source");
//        reader.setRowMapper(new BeanPropertyRowMapper<>(SourceData.class));
//        return reader;
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<TargetData> targetDataWriter() {
//        JdbcBatchItemWriter<TargetData> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(targetDataSource);
//        writer.setSql("INSERT INTO target (id, name) VALUES (:id, :name)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        return writer;
//    }
//}
