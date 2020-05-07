import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
// see https://cloud.google.com/bigtable/docs/samples-hbase-java-hello?hl=fr
public class PutExample {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("ismahen_table"));
        String rowKey = "dd" ;
        //String rowKey2 ="bb" ;

        // Put a single row into the table. We could also pass a list of Puts to write a batch.
        Put put = new Put(Bytes.toBytes(rowKey));
        Put put2 = new Put(Bytes.toBytes(rowKey));
       // put.addColumn("personal_data".getBytes(), "name".getBytes(), "ismahan".getBytes());
        put.addColumn("personal_data".getBytes(), "name".getBytes(), "asiya".getBytes());
        put2.addColumn("personal_data".getBytes(), "first_name".getBytes(), "kouki".getBytes());
        table.put(put);
        table.put(put2);

    }
}
