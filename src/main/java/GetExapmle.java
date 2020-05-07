import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class GetExapmle {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("ismahen_table"));
        String rowKey = "rowKey-43";
        Result getResult = table.get(new Get(Bytes.toBytes(rowKey)));
        String name_value = Bytes.toString(getResult.getValue("personal_data".getBytes(), "name".getBytes()));
        String first_name_value = Bytes.toString(getResult.getValue("personal_data".getBytes(), "first_name".getBytes()));
        System.out.println("name value  = "+name_value+ " ; first name value = " +first_name_value);
        table.close();
        connection.close();
    }
}
