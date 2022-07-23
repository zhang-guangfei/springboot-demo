package com.neo.mbg;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.sql.SQLException;
import java.util.Collections;

public class MybatisPlusGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(
            "jdbc:mysql://47.94.145.115:3306/springboot-demo?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true",
            "root",
            "123456");

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        String modelName = System.getProperty("user.dir") + "/model/mbg";
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("zhangguangfei") // 设置作者
                            .outputDir(modelName + "/src/main/java") // 指定输出目录
                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-MM-dd") //时间格式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                    ;
                })
                .packageConfig(builder -> {
                    builder.parent("com.neo") // 设置父包名
                            .moduleName("mbg") // 设置父包模块名
                            .entity("entity")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, modelName + "/src/main/resources/mapper")) // 设置mapperXml生成路径
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude(Collections.emptyList()) // 设置需要生成的表名
                            .entityBuilder()    //实体类配置
                            .enableLombok()     //开启Lombok
                            .logicDeleteColumnName("delete_flag")//逻辑删除字段名
                            .versionColumnName("version")   //乐观锁
                            .enableTableFieldAnnotation()   //注释注解
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .mapperBuilder() //Dao层配置
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")
                            .enableMapperAnnotation() //@Mapper注解开启
                            .serviceBuilder() //Service层配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .controllerBuilder()//controller配置
                            .formatFileName("%sController")
                            .enableRestStyle()
                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder
                            .disable(TemplateType.XML)
//                            .disable(TemplateType.SERVICE)
//                            .disable(TemplateType.SERVICEIMPL)
//                            .disable(TemplateType.CONTROLLER)
                    ;
                })
                .execute();
    }

}

