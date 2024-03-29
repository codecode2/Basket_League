package admin;


 
 
import Ui.LoginForm;
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.Window;
  

 
 
/**
 *
 * @author Chameleon
 */
public class AdminForm extends javax.swing.JFrame implements Runnable{
 
    String getUsername;
    String getRole;
    
    
   
    public AdminForm()
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        
    }
   
     
     public AdminForm(String username, String role)
    {      
        initComponents(); 
        centreWindow(this);
        Thread t=new Thread(this);
        getRole = role;
        getUsername = username;
    
        
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
        create = new javax.swing.JButton();
        programmaProt = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        role = new javax.swing.JButton();
        klirosiProt = new javax.swing.JButton();
        logfile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

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

        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        programmaProt.setText("Πρόγραμμα Πρωταθλήματος");
        programmaProt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmaProtActionPerformed(evt);
            }
        });

        modify.setText("Modify");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        role.setText("Gives a Role");
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });

        klirosiProt.setText("Κλήρωση Πρωταθλήματος");
        klirosiProt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klirosiProtActionPerformed(evt);
            }
        });

        logfile.setText("Logfile");
        logfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logfileActionPerformed(evt);
            }
        });

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(logfile, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(klirosiProt, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(programmaProt, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(create, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(logout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(klirosiProt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programmaProt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logfile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void programmaProtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmaProtActionPerformed
        
       ProgrammaProtForm programmaProt = new ProgrammaProtForm( getUsername,  getRole);
       programmaProt.setVisible(true);
       this.hide();
       
        
        
    }//GEN-LAST:event_programmaProtActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
      
        CreateForm createForm = new CreateForm(getUsername,  getRole);
        createForm.setVisible(true);
        this.hide();
        
        
    }//GEN-LAST:event_createActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        
        ModifyForm modifyForm = new ModifyForm(getUsername,  getRole);
        modifyForm.setVisible(true);
        this.hide();
        
    }//GEN-LAST:event_modifyActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
      InsertForm insertForm = new InsertForm(getUsername,  getRole);
      insertForm.setVisible(true);
      this.hide();
        
        
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
     
        DeleteForm deleteForm = new DeleteForm(getUsername,  getRole);
        deleteForm.setVisible(true);
        this.hide();
        
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
       GivesRoleForm giveRole = new GivesRoleForm(getUsername,  getRole);
       giveRole.setVisible(true);
       this.hide();
        
        
        
    }//GEN-LAST:event_roleActionPerformed

    private void klirosiProtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klirosiProtActionPerformed
       KlirosiProtForm enarxiProt = new KlirosiProtForm(getUsername,  getRole);
       enarxiProt.setVisible(true);
       this.hide();
    }//GEN-LAST:event_klirosiProtActionPerformed

    private void logfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logfileActionPerformed
       
        LogFileForm logfile = new LogFileForm(getUsername,  getRole);
        logfile.setVisible(true);
        this.hide();
        
        
    }//GEN-LAST:event_logfileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
       
        LoginForm Loginform = new LoginForm();
        Loginform.setVisible(true);
        this.hide();
        
        
    }//GEN-LAST:event_logoutActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       
        SearchForm searchForm = new SearchForm( getUsername,getRole);
        searchForm.setVisible(true);
        this.hide();
        
        
    }//GEN-LAST:event_searchButtonActionPerformed

   
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
              
            }
        });
    }
   

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton insert;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton klirosiProt;
    private javax.swing.JButton logfile;
    private javax.swing.JButton logout;
    private javax.swing.JButton modify;
    private javax.swing.JButton programmaProt;
    private javax.swing.JButton role;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

 
        


    @Override
    public void run() 
    {
           
    }
   
}






