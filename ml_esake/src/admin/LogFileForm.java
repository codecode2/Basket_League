package admin;


 
 
import Ui.LoginForm;
import static admin.KlirosiProtForm.centreWindow;
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
  

 
 
/**
 *
 * @author Chameleon
 */
public class LogFileForm extends javax.swing.JFrame implements Runnable{
 
    
    String getUsername;
    String getRole;
       static String driverClassName="oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521/dblabs";
    static Connection dbConnection = null;
    static Connection dbConnection2 = null;
    static String username = "it175093";
    static String passwd = "Powerteam1515";
    static Statement statement =null;
    static ResultSet rs=null;
     static PreparedStatement  insertonList =null;
    static String value1;
    static String value2;
    static String value3;
    static String value4;
    static String value5;
    static String value6;
    static String value7;
    static String value8;
    static String value9;
    static String value10;
   
    public LogFileForm()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        
    }
   
     
     public LogFileForm(String username,String role) {
         
           initComponents(); 
           centreWindow(this);
           Thread t=new Thread(this);
           getRole = role;
           getUsername = username;
           makelist();
           
        }
                         
 void makelist()
    {
         DefaultListModel mylist =new DefaultListModel();
     try{
             Class.forName(driverClassName);
                
         } catch(ClassNotFoundException ex) {}
         
         try{
                 
            
             
             
                dbConnection2= DriverManager.getConnection(url,username,passwd); 
                statement = dbConnection2.createStatement();

                String selectString = "select * from esakelogfile order by logid";
                  
                
               rs=statement.executeQuery(selectString);
               
                
               while(rs.next()){
               
             value1 = rs.getString("logid");
             value2 = rs.getString("valueaction");
             value3 = rs.getString("valuetable");   
             value5 = rs.getString("value1");
             value6 = rs.getString("value2");
             value7 = rs.getString("value3");
             value8 = rs.getString("value4");
             value9 = rs.getString("value5");
            
             
              
             
              if (value1==null)
              {
              
                  value1=" ";
              }
              if(value2==null)
              {
              
                   value2=" ";
              
              }
              if(value3==null || value3.equals("-") || value3.equals("null")|| value3.equals(""))
              {
              
                   value3=" ";
              
              }
              if(value4==null  || value4.equals("-")|| value4.equals("null")|| value4.equals(""))
              {
              
                   value4=" ";
              
              }
              if(value5==null  || value5.equals("-") || value5.equals("null")|| value5.equals(""))
              {
              
                   value5=" ";
              
              }
              if(value6==null  || value6.equals("-") || value6.equals("null") || value6.equals(""))
              {
              
                   value6=" ";
              
              }
              if(value7==null  || value7.equals("-") || value7.equals("null") || value7.equals(""))
              {
              
                   value7="";
              
              }
              if(value8==null  || value8.equals("-") || value8.equals("null")|| value8.equals(""))
              {
              
                   value8=" ";
              
              }
              if(value9==null  || value9.equals("-") || value9.equals("null")|| value9.equals(""))
              {
              
                   value9=" ";
              
              }
              if(value10==null  || value10.equals("-")|| value10.equals("null")|| value10.equals(""))
              {
              
                   value10="";
              
              } 
              
             
              
              String a =(value1+"      " + value2.toUpperCase() +"       "+ value3 +"      "+ value4 +"      "+ value5+"      " + value6 +"      "+ value7+"     "+ value8+"      "+ value9+"      "+ value10 );
                
               mylist.addElement(a);
              
               }
                  
          
              
  
        }
         catch(SQLException ex) 
           {
            System.out.print("\n -- SQL Exception -- \n" + ex.getMessage());
            ex=ex.getNextException();   
             
           }   
    
         logfilelist.setModel(mylist);
    
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        logfilelist = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                WindowOpen(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(164, 210, 218));
        jPanel1.setFocusCycleRoot(true);

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        jLabel1.setText("Log File");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(10);
        jLabel1.setPreferredSize(new java.awt.Dimension(39, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        logfilelist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(logfilelist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Centered page
    public static void centreWindow(Window frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();  
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        
    }  
    

    
    
  
        
    
    private void WindowOpen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowOpen
        
          
             
        
    
    }//GEN-LAST:event_WindowOpen

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        AdminForm adminForm = new AdminForm(getUsername,getRole);
        adminForm.setVisible(true);
        this.hide();
              
        
        
    }//GEN-LAST:event_backActionPerformed

   
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
              
            }
        });
    }
   

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> logfilelist;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






