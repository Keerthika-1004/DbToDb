//package com.batch.rowmapper;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
////
////import java.sql.ResultSet;
////import java.sql.SQLException;
////
////import org.springframework.jdbc.core.RowMapper;
////
////import com.batch.pojo.SourceData;
////
////public class DataModelRowMapper implements RowMapper<SourceData> {
////    
////	@Override
////    public SourceData mapRow(ResultSet resultSet, int rowNum) throws SQLException {
////    	SourceData dataModel = new SourceData();
////        dataModel.setId(resultSet.getInt("id"));
////        dataModel.setName(resultSet.getString("name"));
////        // Map other fields here
////        return dataModel;
////    }
////}
//
//@Configuration
//public class DataModelRowMapper {
//
//    @Bean(name = "h2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.source")
//	@Primary
//    public DataSource h2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "mysqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.target")
//    public DataSource mysqlDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
//
