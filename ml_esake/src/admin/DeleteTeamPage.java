package admin;


 
 
import Ui.LoginForm;
import static admin.CreatePlayer.dbConnection;
import static admin.CreatePlayer.passwd;
import static admin.CreatePlayer.rs;
import static admin.CreatePlayer.statement;
import static admin.CreatePlayer.url;
import static admin.CreatePlayer.username;
import static admin.DeletePlayerPage.centreWindow;
import static admin.DeletePlayerPage.insertonList;
import static admin.GivesRoleForm.dbConnection;
import static admin.GivesRoleForm.passwd;
import static admin.GivesRoleForm.rs;
import static admin.GivesRoleForm.statement;
import static admin.GivesRoleForm.url;
import static admin.GivesRoleForm.username;
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
  

 
 
/**
 *
 * @author Chameleon
 */
public class DeleteTeamPage extends javax.swing.JFrame implements Runnable{
 
     String getUsername;
    String getRole;
    
     static String driverClassName="oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521/dblabs";
    static Connection dbConnection = null;
    static String username = "it175093";
    static String passwd = "Powerteam1515";
    static Statement statement =null; 
    static ResultSet rs   = null;
    
  
    
   
    public DeleteTeamPage()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        
        filltheTable();
        
    }
   
     public DeleteTeamPage(String username,String role) {
         
           initComponents(); 
           centreWindow(this);
           Thread t=new Thread(this);
           getRole = role;
           getUsername = username;
           
           filltheTable();
         }
     
                  
      void filltheTable()
      
      {
             DefaultListModel mylist =new DefaultListModel();
             
             try{  
                    dbConnection= DriverManager.getConnection(url,username,passwd);  
                    statement = dbConnection.createStatement();
                    String selectString ="select * from  teams";                                    
                    rs=statement.executeQuery(selectString);  
                    
                    while(rs.next())
                    {
                        int   id = rs.getInt("id");
                       String tName = rs.getString("name");
                       String tTown = rs.getString("town");
                       String tchamp = rs.getString("champ");
                        mylist.addElement(id+"---"+tName+"---"+ tTown+"---"+tchamp);
                    
                    }
                    
                   listOfTeams.setModel(mylist);
                   statement.close();
                   dbConnection.close();
                    
                 }   
               
               catch(SQLException ex) 
                {
                   System.out.print("\n -- SQL Exception -- \n" + ex.getMessage());
                   ex=ex.getNextException();         
                }    
      
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
        back = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfTeams = new javax.swing.JList<>();

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

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel2.setText("Delete Team");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        listOfTeams.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listOfTeams);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
         DeleteForm deleteForm = new DeleteForm(getUsername,getRole);
         deleteForm.setVisible(true);
         this.hide();      
        
        
        
        
    }//GEN-LAST:event_backActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       
        String tableSelection2 = String.valueOf( listOfTeams.getSelectedValue());
       if (tableSelection2.equals("null"))
          {
              
             JOptionPane.showMessageDialog(jPanel1, "There are no choises.Please make an option");
             
              
          } else 
          {  int a = JOptionPane.showConfirmDialog(jPanel1,"Do you want to continue?" );
                    
                if(a==JOptionPane.YES_OPTION)
                {
                     String parts[] = tableSelection2.split("---");
                     
           try{
              dbConnection= DriverManager.getConnection(url,username,passwd);  
             statement = dbConnection.createStatement();
             
              int x=Integer.parseInt(parts[0]);
              
             String SelectString="{  call DELETIONESAKE(?,?,?,?)}";
               insertonList= dbConnection.prepareStatement(SelectString);
               insertonList.setInt(1,x);              
               insertonList.setString(2, "Teams");  
                insertonList.setString(3,getUsername);
               insertonList.setString(4,getRole);
               insertonList.executeUpdate();                     
               
         } catch(SQLException ex) 
         {
            System.out.print("\n -- SQL Exception -- \n" + ex.getMessage());
            ex=ex.getNextException();         
         }
         
                   JOptionPane.showMessageDialog(jPanel1, "Deletion was done");
                      filltheTable();
                }    
            
          }
        
        
     
        
        
        
        
    }//GEN-LAST:event_submitActionPerformed

   
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listOfTeams;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






