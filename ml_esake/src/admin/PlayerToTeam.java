package admin;


 
 
import SimpleUser.SimpleUser;
import static SimpleUser.SimpleUser.centreWindow;
import Ui.LoginForm;
import admin.AdminForm;
import static admin.DeleteTeamPage.dbConnection;
import static admin.DeleteTeamPage.passwd;
import static admin.DeleteTeamPage.rs;
import static admin.DeleteTeamPage.statement;
import static admin.DeleteTeamPage.url;
import static admin.DeleteTeamPage.username;
import gramateia.GramateiaForm;
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
import javax.swing.JOptionPane;
import proedros.ProedrosForm;
  

 
 
/**
 *
 * @author Chameleon
 */
public class PlayerToTeam extends javax.swing.JFrame implements Runnable{
 
    String getUsername;
    String getRole;
    static String driverClassName="oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@192.168.6.21:1521/dblabs";
    static Connection dbConnection = null;
    static String username = "it175093";
    static String passwd = "Powerteam1515";
    static Statement statement =null; 
    static PreparedStatement  insertionList =null;
    static ResultSet rs   = null;
    static DefaultListModel mylist;
    
    
    public PlayerToTeam()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
         String getInputSearch = searchInputPlayers.getText().toString();
         fillthePlayers(getInputSearch);
    }
   
     
                  
   public PlayerToTeam(String username,String role) {
         
           initComponents(); 
           centreWindow(this);
           Thread t=new Thread(this);
           getRole = role;
           getUsername = username;
           
           String getInputSearchPlayers = searchInputPlayers.getText().toString();
           fillthePlayers(getInputSearchPlayers);
            String getInputSearchTeams = searchInputTeams.getText().toString();
           filltheTeams(getInputSearchTeams);
         
         }
    
   
     void fillthePlayers(String inSearch)
      
      {
             DefaultListModel mylist =new DefaultListModel();
             
             try{  
                    dbConnection= DriverManager.getConnection(url,username,passwd);  
                    statement = dbConnection.createStatement();
                    
                    if (inSearch.equals("")){
                    String selectString ="select * from  players";                                    
                    rs=statement.executeQuery(selectString);  
                    }else
                    {
                    
                     String selectString=   " select * from PLAYERS where  name  LIKE "+"'"+ inSearch+"%'";
                     rs=statement.executeQuery(selectString); 
                    
                    
                    }
                    
                    
                    while(rs.next())
                    {
                       int   id = rs.getInt("id");
                       String pName = rs.getString("name");
                       String pTown = rs.getString("town");
                       String pTeam = rs.getString("team");
                       mylist.addElement(id+"---"+pName+"---"+pTeam);
                    
                    }
                    
                   listPlayers.setModel(mylist);
                   statement.close();
                   dbConnection.close();
                    
                 }   
               
               catch(SQLException ex) 
                {
                   System.out.print("\n -- SQL Exception -- \n" + ex.getMessage());
                   ex=ex.getNextException();         
                }
      
      }
     
     
     
     void filltheTeams(String inSearch)
      
      {
             DefaultListModel mylist =new DefaultListModel();
             
             try{  
                    dbConnection= DriverManager.getConnection(url,username,passwd);  
                    statement = dbConnection.createStatement();
                    String selectString;
                      if (inSearch.equals("")){
                        selectString ="select * from  teams";
                      }
                      else {
                       selectString=   " select * from Teams where  name  LIKE "+"'"+ inSearch+"%'";
                         rs=statement.executeQuery(selectString); 
                      
                      
                      }
                    rs=statement.executeQuery(selectString);  
                    
                    while(rs.next())
                    {
                        int   id = rs.getInt("id");
                       String tName = rs.getString("name");
                       String tTown = rs.getString("town");
                       String tchamp = rs.getString("champ");
                        mylist.addElement(id+"---"+tName+"---"+tchamp);
                    
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
    
     
     
       void filltheChamp(String inSearch)
      
      {
             DefaultListModel mylist =new DefaultListModel();
             
             try{  
                    dbConnection= DriverManager.getConnection(url,username,passwd);  
                    statement = dbConnection.createStatement();
                    String selectString;
                     if (inSearch.equals("")){
                     selectString ="select * from  championships";                                    
                    rs=statement.executeQuery(selectString);  
                     }else
                     {
                         selectString=   " select * from Championships where  name  LIKE "+"'"+ inSearch+"%'";
                         rs=statement.executeQuery(selectString); 
                     
                     
                     }
                    while(rs.next())
                    {
                        int   id = rs.getInt("id");
                       String champName = rs.getString("name");
                       String numberOfTeams = rs.getString("teamsnumber");
                     
                        mylist.addElement(id+"---"+champName+"---"+ numberOfTeams);
                    
                    }
                    
                   listPlayers.setModel(mylist);
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        searchInputPlayers = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPlayers = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOfTeams = new javax.swing.JList<>();
        searchInputTeams = new javax.swing.JTextField();
        findTeamsButton = new javax.swing.JButton();
        findPlayersButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

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

        searchInputPlayers.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchInputPlayersInputMethodTextChanged(evt);
            }
        });
        searchInputPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputPlayersActionPerformed(evt);
            }
        });
        searchInputPlayers.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchInputPlayersPropertyChange(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        searchButton.setText("Submit");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listPlayers);

        jScrollPane2.setViewportView(listOfTeams);

        searchInputTeams.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchInputTeamsInputMethodTextChanged(evt);
            }
        });
        searchInputTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputTeamsActionPerformed(evt);
            }
        });
        searchInputTeams.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchInputTeamsPropertyChange(evt);
            }
        });

        findTeamsButton.setText("Find");
        findTeamsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findTeamsButtonActionPerformed(evt);
            }
        });

        findPlayersButton.setText("Find");
        findPlayersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPlayersButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText(">>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Players");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Teams");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchInputPlayers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(findPlayersButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(searchInputTeams)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findTeamsButton)))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchInputPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(findPlayersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchInputTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(findTeamsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void searchInputPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputPlayersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputPlayersActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       
        if (getRole.equals("Admin"))
            {
            AdminForm adminForm = new AdminForm(getUsername,getRole);
            adminForm.setVisible(true);
            this.hide();
            }
        else if (getRole.equals("Simple User"))
        
            {
                SimpleUser simpleUser = new SimpleUser(getUsername,getRole);
                simpleUser.setVisible(true);
                this.hide();

            }
         else if (getRole.equals("Γραμματεια"))
        
            {
                GramateiaForm  grammateiaForm = new  GramateiaForm(getUsername,getRole);
                 grammateiaForm.setVisible(true);
                 this.hide();

            } 
                else if(getRole.equals("Προεδρος"))
             {
                 ProedrosForm  proedrosForm = new  ProedrosForm(getUsername,getRole);
                 proedrosForm.setVisible(true);
                 this.hide();
             }
        
        
    }//GEN-LAST:event_backActionPerformed

    private void searchInputPlayersPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchInputPlayersPropertyChange

    }//GEN-LAST:event_searchInputPlayersPropertyChange

    private void searchInputPlayersInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchInputPlayersInputMethodTextChanged
      
      
        
        
    }//GEN-LAST:event_searchInputPlayersInputMethodTextChanged

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        String s = searchInputPlayers.getText().toString();
        
        String aPlayer =listPlayers.getSelectedValue().toString();
        String parts[] = aPlayer.split("---");
        System.out.println(parts[0]);
         String aTeam =listOfTeams.getSelectedValue().toString();
        String parts2[] = aTeam.split("---");
        System.out.println(parts2[0]);
        
        if(aTeam.equals("") || aPlayer.equals(""))
        {
        
             JOptionPane.showMessageDialog(jPanel1, "Choose a player and a team");
        
        }
        
        
        
         try{
              dbConnection= DriverManager.getConnection(url,username,passwd);  
             statement = dbConnection.createStatement();
             
          
              
             String SelectString="{  call updatePlayer(?,?,?,?)}";         
               insertionList= dbConnection.prepareStatement(SelectString);
               insertionList.setString(1,parts[0]);
               insertionList.setString(2,parts2[1]);
               insertionList.setString(3,getUsername);
               insertionList.setString(4,getRole);
               
               insertionList.executeUpdate();
               
                JOptionPane.showMessageDialog(jPanel1, "Successful Join of "+"'"+parts[1] +"'"+" to "+"'"+parts2[1]+"'");
              
                 String getInputSearchPlayers = searchInputPlayers.getText().toString();
           fillthePlayers(getInputSearchPlayers);
            String getInputSearchTeams = searchInputTeams.getText().toString();
           filltheTeams(getInputSearchTeams);
                
              statement.close();
              dbConnection.close();
           
         } catch(SQLException ex) 
         {
            System.out.print("\n -- SQL Exception -- \n" + ex.getMessage());
            ex=ex.getNextException();  
              JOptionPane.showMessageDialog(jPanel1, "Something Goes Wrong. Try again please");
         }  
        
        
        
        
        
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputTeamsInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchInputTeamsInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputTeamsInputMethodTextChanged

    private void searchInputTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputTeamsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputTeamsActionPerformed

    private void searchInputTeamsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchInputTeamsPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputTeamsPropertyChange

    private void findPlayersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPlayersButtonActionPerformed
             String getInputSearchPlayers = searchInputPlayers.getText().toString();
                fillthePlayers(getInputSearchPlayers);

    }//GEN-LAST:event_findPlayersButtonActionPerformed

    private void findTeamsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findTeamsButtonActionPerformed
        String getInputSearchTeams = searchInputTeams.getText().toString();
           filltheTeams(getInputSearchTeams);
    }//GEN-LAST:event_findTeamsButtonActionPerformed

   
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
              
            }
        });
    }
   

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton findPlayersButton;
    private javax.swing.JButton findTeamsButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList<String> listOfTeams;
    private javax.swing.JList<String> listPlayers;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInputPlayers;
    private javax.swing.JTextField searchInputTeams;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






