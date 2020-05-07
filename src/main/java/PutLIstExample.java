import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PutLIstExample {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("ismahen_table"));
        List<Put> listPut = new ArrayList<Put>();
        for (int i = 0 ; i<50 ; i++){
            Put put = new Put(Bytes.toBytes("rowKey-"+ i));
            put.addColumn("personal_data".getBytes(), "name".getBytes(),Bytes.toBytes("value-name-"+i));
            put.addColumn("personal_data".getBytes(), "first_name".getBytes(), Bytes.toBytes("first-name-value-"+i));
            listPut.add(put) ;
        }
       table.put(listPut);
        table.close();
        connection.close();
    }
}
