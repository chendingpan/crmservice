package cn.edu.cqut.crmservice.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/crmdb?serverTimezone=Asia/Shanghai", "root", "493349")
                .globalConfig(builder -> {
                    builder.author("CQUT") // 设置作者
                            .outputDir("C:\\Users\\陈皮\\Desktop\\源代码\\crmservice\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.edu.cqut.crmservice"); // 设置父包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user"); // 设置需要生成的表名
                })
                .execute();
    }
}
