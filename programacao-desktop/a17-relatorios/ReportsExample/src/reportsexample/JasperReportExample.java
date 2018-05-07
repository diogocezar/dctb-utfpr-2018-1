package reportsexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

 
public class JasperReportExample {
 
    private static final String url      = "jdbc:mysql://localhost/utfpr_tests";
    private static final String driver   = "com.mysql.jdbc.Driver";
    private static final String user     = "root";
    private static final String password = "";
 
    public JasperReportExample(){
    }
 
    public void generate(String layout) throws JRException , SQLException, ClassNotFoundException{
        //gerando o jasper design
        JasperDesign drawing = JRXmlLoader.load(layout);

        //compila o relatório
        JasperReport report = JasperCompileManager.compileReport(drawing);

        //estabelece conexão
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stm  = con.createStatement();
        String query   = "SELECT * from java_item";
        ResultSet rs   = stm.executeQuery(query);

        //implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        //executa o relatório
        Map params = new HashMap();
        params.put("HEADER", "Relatório de Clientes");
        params.put("FOOTER", "Final do Relatório - 2018 - UTFPR");
        JasperPrint print = JasperFillManager.fillReport(report, params, jrRS);

        //exibe o resultado
        JasperViewer viewer = new JasperViewer(print, true);
        viewer.show();
    }
}