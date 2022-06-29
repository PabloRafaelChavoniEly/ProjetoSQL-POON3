import java.lang.reflect.*;
import java.sql.*;

public class Database {

    private static Connection connect(){
        String url = "jdbc:sqlite:C:\\Users\\rafae\\Desktop\\POO\\POO1-main\\POO1-main\\SQLFactory\\db\\data.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static boolean inserir(SQLClass registro){
        return executarSQL(registro.insertSQL() );
    }

    public static boolean atualizar(SQLClass registro){
        return executarSQL(registro.updateSQL());
    }

    public static boolean deletar(SQLClass registro){
        return executarSQL(registro.deleteSQL());
    }

    public static boolean abrir(SQLClass registro, int id){
        return executarSQL(registro.selectSQL());
    }

    public static boolean executarSQL(String sql){
        boolean ok = false;

        Connection currentConn = connect();

        try {
            Statement statement = currentConn.createStatement();
            statement.execute(sql);
            currentConn.close();
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
            ok = false;
        }

        return ok;
    }

    public static boolean abrirID(SQLClass registro, int id){
        Field[] fields = registro.getClass().getDeclaredFields();
        
        boolean ok = false;
        
        Connection currentConnection = connect();
        
        try {
            PreparedStatement stmt = currentConnection.prepareStatement(registro.selectSQL() + " where id = " + id);
            ResultSet resultSet = stmt.executeQuery();
            
            for (Field field : fields) {
                if (field.getType() == String.class){
                field.set(registro, resultSet.getString(field.getName()));
                } else {
                field.set(registro, resultSet.getInt(field.getName()));
                }
            }
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
            ok = false;
        }
            return ok;
        }

}
