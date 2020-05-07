import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import java.io.IOException;

public class CreateTableExample {
    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();
        //uniquement quant on travail en mode standalone
        config.addResource("/home/kouki/Documents/hbase-2.2.4/conf/hbase-site.xml");
        //on rajoute ces configurations uniquement quant on travail dans un systeme distribue(cluster)
        // config.set("hbase.zookeeper.quorum","zookeepernode0,zookeepernode1,zookeepernode2");
        //config.set("hbase.zookeeper.property.clientPort", "2181");
        //conf.set("zookeeper.znode.parent", "/hbase-unsecure");
        Connection connection = ConnectionFactory.createConnection(config);
        Admin admin = connection.getAdmin();// permet de faire des opérations d'administration (DDL)
        TableName table = TableName.valueOf("ismahen_table");
        TableDescriptor desc = TableDescriptorBuilder.newBuilder(table)
                .setColumnFamily(ColumnFamilyDescriptorBuilder.of("personal_data"))
                .setColumnFamily(ColumnFamilyDescriptorBuilder.of("profesional_data"))
                .build();
        admin.createTable(desc);
        admin.close();
        connection.close();

    }
}
