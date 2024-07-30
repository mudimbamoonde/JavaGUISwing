/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author moondem
 */
public class AddNewJob extends javax.swing.JFrame {

    ArrayList<Job> jobs;
    /**
     * Creates new form AddNewJob
     */
    public AddNewJob() {
        initComponents();
         setLocationRelativeTo(null);
        jobs = new ArrayList<Job>();
        populateArrayList();
    }

   public void populateArrayList(){
       try{
           
           FileInputStream file = new FileInputStream("job.dat");
           ObjectInputStream inputFile = new ObjectInputStream(file);
           
           boolean endOfFile = false;
           while(!endOfFile){
             try{
                 jobs.add((Job)inputFile.readObject());
             
             }catch(EOFException e ){
                endOfFile = true;
             }catch(ClassNotFoundException fe){
              JOptionPane.showMessageDialog(null,fe.getMessage());
             }
           }
          inputFile.close();
          
       }catch(IOException f){
          JOptionPane.showMessageDialog(null,f.getMessage());
       }
   }
   
   public void saveJobsToFile()
   {
       try
       {
           FileOutputStream file  = new FileOutputStream("job.dat");
           ObjectOutputStream outputFile = new ObjectOutputStream(file);
           
           for(int i=0; i<jobs.size(); i++){
            outputFile.writeObject(jobs.get(i));
           }
           
           outputFile.close();
             JOptionPane.showMessageDialog(null,"Successfully Saved!");
             this.dispose();
           
       }catch(IOException f)
       {
           JOptionPane.showMessageDialog(null,f.getMessage());
       }
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbSalary = new javax.swing.JTextField();
        saveJobBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Job");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Create a New Job by Entering the data below");

        jLabel2.setText("Name of the Job: ");

        jbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Salary for this Job:");

        saveJobBTN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saveJobBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/save.png"))); // NOI18N
        saveJobBTN.setText("Save");
        saveJobBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJobBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbName)
                                    .addComponent(jbSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(saveJobBTN))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveJobBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNameActionPerformed

    private void saveJobBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJobBTNActionPerformed
      if (jbName.getText().isEmpty() || jbSalary.getText().isEmpty()){
         JOptionPane.showMessageDialog(null,"Please Enter All Fields!!");
      }else
      {
        String name = jbName.getText().trim();
        String salary  =  jbSalary.getText().trim();
        
        Job job = new Job(Double.parseDouble(salary),name);
        jobs.add(job);
        
        saveJobsToFile();
      }
       
        
        
    }//GEN-LAST:event_saveJobBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jbName;
    private javax.swing.JTextField jbSalary;
    private javax.swing.JButton saveJobBTN;
    // End of variables declaration//GEN-END:variables
}
