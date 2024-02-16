package admin;


 
 
import SimpleUser.SimpleUser;
import Ui.LoginForm;
import static admin.DeleteTeamPage.dbConnection;
import static admin.DeleteTeamPage.passwd;
import static admin.DeleteTeamPage.rs;
import static admin.DeleteTeamPage.statement;
import static admin.DeleteTeamPage.url;
import static admin.DeleteTeamPage.username;
import static admin.GivesRoleForm.centreWindow;
import gramateia.GramateiaForm;
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import proedros.ProedrosForm;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
  
import java.sql.CallableStatement;

 
 
/**
 *
 * @author Chameleon
 */
public class KlirosiProtForm extends javax.swing.JFrame implements Runnable{
 
   String getUsername;
   String getRole;
   String [] fillTeams;
   Random rand = new Random();
     int rand_int1;
     String carry;
      String endingString="" ;
        
     String teams1[];
    
    public KlirosiProtForm()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        
    }
   
     
       public KlirosiProtForm(String username,String role) {
         
           initComponents(); 
           centreWindow(this);
           Thread t=new Thread(this);
           getRole = role;
           getUsername = username;
           String inSearch = nameChamp.getText().toString();
           
           filltheChamp(inSearch);
           
           
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
                     
                        mylist.addElement(champName);
                    
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
    
    
       
       
         void filltheteams(String inSear)
      
      {
           
             
             try{  
                    dbConnection= DriverManager.getConnection(url,username,passwd);  
                    statement = dbConnection.createStatement();
                    String selectString;
                    String selectString2;
                    selectString2= "select count(*) as numTeam from teams where champ="+"'"+inSear+"'";
                    rs=statement.executeQuery(selectString2); 
                      int  numteam=0;
                    while(rs.next())
                    {
                     
                       numteam = rs.getInt("numTeam");
                       
                      
                    }
                   
                      
                      fillTeams= new String[numteam];
                    
                       selectString=   " select * from Teams where  champ= "+"'"+ inSear+"'";
                         rs=statement.executeQuery(selectString); 
                      
                      
                   rs=statement.executeQuery(selectString);  
                    int i =0;
                    while(rs.next())
                    {
                        int   id = rs.getInt("id");
                       String tName = rs.getString("name");
                       String tTown = rs.getString("town");
                       fillTeams[i] = tName;
                        System.out.println(fillTeams[i]);
                       
                       String tchamp = rs.getString("champ");
                      
                       i++;
                    }
                    
                 
                  
                    
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        lotteryButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JList<>();
        findButton = new javax.swing.JButton();
        nameChamp = new javax.swing.JTextField();

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

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 24)); // NOI18N
        jLabel1.setText("Κλήρωση Πρωταθλήματος");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(10);
        jLabel1.setPreferredSize(new java.awt.Dimension(39, 30));
        jLabel1.setSize(new java.awt.Dimension(41, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        lotteryButton.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 14)); // NOI18N
        lotteryButton.setText("Κλήρωση");
        lotteryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotteryButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listTable);

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(nameChamp, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(151, 151, 151))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lotteryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameChamp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lotteryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        String s = nameChamp.getText();
        
       filltheChamp(s);
       
    }//GEN-LAST:event_findButtonActionPerformed

    private void lotteryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotteryButtonActionPerformed
      
        
        String selectionTable3 = listTable.getSelectedValue().toString();
        System.out.println("\n\nbefore\n\n");
        filltheteams(selectionTable3);
        teams1 = new String [fillTeams.length];
        for(int i=0; i<fillTeams.length; i++)
        {
            
            
            rand_int1 = rand.nextInt(fillTeams.length);
            while (teams1[rand_int1]!=null){
            rand_int1 = rand.nextInt(fillTeams.length);
         }
              teams1[rand_int1]=fillTeams[i];
                
             
        }
        
         System.out.println("\n\nafter\n\n");
         for(int i=0; i<fillTeams.length; i++)
        {
        
          System.out.println(teams1[i]);
        
        
        }
        
    try{      
         
       String roundAsString = null ;
       String ending = "";
       String cleaning="" ;
       int weekCount = 0;
      
        
          
    
    int teams = teams1.length;
    // Generate the schedule using round robin algorithm.
    int totalRounds = (teams - 1) * 2;
    int matchesPerRound = teams / 2;
    String[][] rounds = new String[totalRounds][matchesPerRound];
    for (int round = 0; round < totalRounds; round++) {
      for (int match = 0; match < matchesPerRound; match++) {
        int home = (round + match) % (teams - 1);
        int away = (teams - 1 - match + round) % (teams - 1);
        // Last team stays in the same place
        // while the others rotate around it.
        if (match == 0) {
          away = teams - 1;
        }
        // Add one so teams are number 1 to teams
        // not 0 to teams - 1 upon display.
        rounds[round][match] = ("" +teams1[home ]   
            + " vs " +    teams1[away ]+"");
      }
    }
    // Display the rounds
    for (int i = 0; i < rounds.length; i++) {
     // System.out.println("Round " + (i + 1)); 
      roundAsString =  "\nWeek " + (i + 1)+": \n" +Arrays.toString(rounds[i]);
      
        String  parts[]= Arrays.toString(rounds[i]).split("\\[");
       
         for (int h = 0; h < parts.length;h++){
        
          cleaning = cleaning + parts[h];
         }
         String parts2[]= cleaning.split("\\]");
         cleaning ="";
         
         for (int h = 0; h < parts2.length;h++){
        
          cleaning = cleaning + parts2[h];
         }
          
        
      ending  = ending +",Week:," + cleaning;
      cleaning ="";
      //System.out.println(Arrays.asList(rounds[i]));
      System.out.println();
    }
    
        
       String parts3[]= ending.split(",");
        String  changerPotition[]= new String[rounds.length]; 
         
        int counter=1;
         
        
        
        
         for (int h = 0; h < parts3.length; h++){
            
          
             
                    
                    
                
                    for(int l=0; l<h-1; l++){
                        
                         
                        
                        if (parts3[l].equals(parts3[h])   )
                        {
                            
                            if(!parts3[l].equals("Week:") && !parts3[l].equals("")){
                             // System.out.println (parts3[l]);
                            String parts4[]= parts3[l].split("vs");
                           parts3[l] =parts4[1]+ " vs "+ parts4[0]+ "" ;
                            
                            
                       // System.out.println (parts3[h] +  " here i am"  );
                         }
                        
                        }  
                    
                    
                    
                    
            }
       
           
               
       
         }
        
            counter=1;
        for (int h = 0; h < parts3.length; h++){
            
           
            if(parts3[h].equals("Week:"))
            {
                                       
                    
                    endingString = endingString+ "Week:"+ counter+","+parts3[h+1]+ "," +parts3[h+2]+",";
                    counter++;
                                      
                    
            }
       
           
               
       
         }
        
        
        
                 
        try{
        
          
            CallableStatement  insertChamp = dbConnection.prepareCall("{call  klirosiEsake(?,?,?,?)}"); 
         
            insertChamp.setString(1, selectionTable3);
            insertChamp.setString(2, endingString);
            insertChamp.setString(3, getUsername);
            insertChamp.setString(4, getRole);
            insertChamp.execute();
            JOptionPane.showMessageDialog(jPanel1, "Η κλήρωση ολοκληρώθηκε επιτυχώς");
            dbConnection.close();
            statement.close();
        
        
        } catch (Exception ex)
        
        {
            JOptionPane.showMessageDialog(jPanel1, "Η κλήρωση για το συγκεκριμένο πρωτάθλημα έχει γίνει ήδη");
            System.out.println("Exception:  "+ex);
        
        }
        
        
        
        
        
        
        
        
        
        
        
        System.out.println(endingString);
        
    } catch (Exception ex)
    {
            
     JOptionPane.showMessageDialog(jPanel1, "Ο αριθμός των ομάδων που συμμέτεχουν δεν ειναι ο καταλλήλος");
    
    
    }
        
 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         
         
         
        
    }//GEN-LAST:event_lotteryButtonActionPerformed

   
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
              
            }
        });
    }
   

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton findButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList<String> listTable;
    private javax.swing.JButton lotteryButton;
    private javax.swing.JTextField nameChamp;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






