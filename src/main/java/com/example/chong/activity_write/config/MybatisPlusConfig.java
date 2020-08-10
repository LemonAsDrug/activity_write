package com.example.chong.activity_write.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

//Spring boot方式
//@MapperScan("com.example.chong.activity_write.mapper")
//已经被扫描进去。已经扫描过一次。
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件 和 攻击sql阻断解析器
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        //分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 默认false
        // 设置请求的页面大于最大页后操作， true调回到首页;false继续请求,返回空数据.
         paginationInterceptor.setOverflow(false);

        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        //设置为10，如果传入参数pageSize为20，不会报错，只会返回10条数据
         paginationInterceptor.setLimit(500);

        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));


        //攻击sql阻断解析器
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

}