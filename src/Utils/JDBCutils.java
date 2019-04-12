package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCutils {
    private static DataSource ds;
    static {
        Properties properties = new Properties();
        InputStream rs = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(rs);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
