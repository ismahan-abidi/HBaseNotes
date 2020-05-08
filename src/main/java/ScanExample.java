import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

public class ScanExample {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        Connection connection = ConnectionFactory.createConnection(config);
        Table table = connection.getTable(TableName.valueOf("ismahen_table"));
        Scan scan = new Scan();

        System.out.println("Scan for all rows:");
        ResultScanner scanner = table.getScanner(scan);
        for (Result row : scanner) {
            byte[] valueBytes = row.getValue("personal_data".getBytes(), "name".getBytes());
            System.out.println('\t' + Bytes.toString(valueBytes));
        }
        table.close();
        connection.close();
    }

}
