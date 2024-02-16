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
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import proedros.ProedrosForm;
  

 
 
/**
 *
 * @author Chameleon
 */
public class SearchForm extends javax.swing.JFrame implements Runnable{
 
    String getUsername;
    String getRole;
    
    
    
    public SearchForm()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        
    }
   
     
                  
   public SearchForm(String username,String role) {
         
           initComponents(); 
           centreWindow(this);
           Thread t=new Thread(this);
           getRole = role;
           getUsername = username;
         
         
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
                       mylist.addElement(id+"---"+pName+"---"+ pTown+"---"+pTeam);
                    
                    }
                    
                   listTable.setModel(mylist);
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
                        mylist.addElement(id+"---"+tName+"---"+ tTown+"---"+tchamp);
                    
                    }
                    
                   listTable.setModel(mylist);
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
                    
                   listTable.setModel(mylist);
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
        chooseOptions = new javax.swing.JComboBox<>();
        searchInput = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JList<>();
        profileView = new javax.swing.JButton();

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

        chooseOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Players", "Teams", "Championships" }));
        chooseOptions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chooseOptionsItemStateChanged(evt);
            }
        });
        chooseOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseOptionsActionPerformed(evt);
            }
        });

        searchInput.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchInputInputMethodTextChanged(evt);
            }
        });
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });
        searchInput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchInputPropertyChange(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listTable);

        profileView.setText("Profile View");
        profileView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chooseOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(profileView, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(chooseOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(profileView, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void chooseOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseOptionsActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

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

    private void chooseOptionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chooseOptionsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseOptionsItemStateChanged

    private void searchInputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchInputPropertyChange

    }//GEN-LAST:event_searchInputPropertyChange

    private void searchInputInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchInputInputMethodTextChanged
      
      
        
        
    }//GEN-LAST:event_searchInputInputMethodTextChanged

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        String s = searchInput.getText().toString();
        String tableSelection = String.valueOf(chooseOptions.getSelectedItem());
        System.out.println(s);
        
        
        if (tableSelection.equals("Players"))
        {
         fillthePlayers(s);
        }
        
        
        else if (tableSelection.equals("Teams"))
        {
             filltheTeams(s);
        }
        else if (tableSelection.equals("Championships"))
        {
            filltheChamp(s);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void profileViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileViewActionPerformed
      
        String s = searchInput.getText().toString();
        String tableSelection = String.valueOf(chooseOptions.getSelectedItem());
        String tableSelection2 = String.valueOf( listTable.getSelectedValue());
       
        
        if (tableSelection.equals("Players"))
        {
            PlayerProfileView  playerProfileView = new PlayerProfileView(getUsername,getRole,tableSelection2);
            playerProfileView.setVisible(true);
            this.hide();
            
         
        }
        
        
        else if (tableSelection.equals("Teams"))
        {
            
           TeamProfileView teamProfileView = new TeamProfileView(getUsername,getRole,tableSelection2);
           teamProfileView.setVisible(true);
           this.hide();
            
             
        }
        else if (tableSelection.equals("Championships"))
        {
                ChampionshipProfileView championshipProfileView = new ChampionshipProfileView(getUsername,getRole,tableSelection2);
                championshipProfileView.setVisible(true);
                this.hide();
            
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_profileViewActionPerformed

   
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
              
            }
        });
    }
   

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> chooseOptions;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList<String> listTable;
    private javax.swing.JButton profileView;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






