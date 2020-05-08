import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class DeleteExample {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("ismahen_table"));
        Delete delete = new Delete(Bytes.toBytes("rowKey-0"));
        delete.addColumn(Bytes.toBytes("personal_data"), Bytes.toBytes("name"));
        // deleting the data
        table.delete(delete);
        table.close();
        connection.close();
    }
}
