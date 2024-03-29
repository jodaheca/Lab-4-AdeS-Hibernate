package peliculahibernate;

import com.udea.DAO.ActorDAO;
import com.udea.modelo.Actor;
import com.udea.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Joaquin Hernandez
 */


public class PeliculaForm extends javax.swing.JFrame {

    /**
     * Creates new form PeliculaForm
     */
    public PeliculaForm() {
        initComponents();
        resultTable.setVisible(false);
    }

    private static String QUERY_BASED_ON_FIRST_NAME=
            "from Actor a where a.firstName like '";
    private static String QUERY_BASED_ON_LAST_NAME=
            "from Actor a where a.lastName like '";
    private static String QUERY_ALL="from Actor ";
    
    private void runQueryBasedOnFirstName() {
        executeHQLQuery(QUERY_BASED_ON_FIRST_NAME + firstNameTextField.getText() + "%'");
    }
    
    private void runQueryBasedOnLastName() {
        executeHQLQuery(QUERY_BASED_ON_LAST_NAME + lastNameTextField.getText() + "%'");
    }
    
    private void runQueryAll() {
        executeHQLQuery(QUERY_ALL);
    }
    
    private void executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            displayResult(resultList);
            session.getTransaction().commit();
            
            
            
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
    private void displayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ActorId");
        tableHeaders.add("FirstName");
        tableHeaders.add("LastName");
        tableHeaders.add("LastUpdated");

        for (Object o : resultList) {
            Actor actor = (Actor) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(actor.getActorId());
            oneRow.add(actor.getFirstName());
            oneRow.add(actor.getLastName());
            oneRow.add(actor.getLastUpdate());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        queryButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        identificacion = new javax.swing.JTextField();
        BotonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Perfil actor");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        queryButton.setText("Consultar");
        queryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryButtonActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jLabel4.setText("Identificacion ");

        BotonActualizar.setText("Actualizar");
        BotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(BotonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(queryButton)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonActualizar)
                    .addComponent(botonEliminar)
                    .addComponent(botonGuardar))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryButtonActionPerformed
        // TODO add your handling code here:
        resultTable.setVisible(true);
        if (!firstNameTextField.getText().trim().equals("")) {
            runQueryBasedOnFirstName();
        } else if (!lastNameTextField.getText().trim().equals("")) {
            runQueryBasedOnLastName();
        } else runQueryAll();
    }//GEN-LAST:event_queryButtonActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        String nombre=firstNameTextField.getText();
        String apellido=lastNameTextField.getText();
        String id=identificacion.getText();
        if(nombre.length()==0 ||apellido.length()==0){
            JOptionPane.showMessageDialog(this,"Ingrese todos los datos para poder registrar el Actor","Datos Faltantes",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date fechaHoy= new Date();
        Actor nuevo = new Actor();
        nuevo.setFirstName(nombre);
        nuevo.setLastName(apellido);
        nuevo.setLastUpdate(fechaHoy);
        ActorDAO managerActor = new ActorDAO();
        managerActor.guardaActor(nuevo);
        runQueryBasedOnFirstName();
        //JOptionPane.showMessageDialog(this,"Actor ingresado exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE ); 
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        identificacion.setText("");
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        String id=identificacion.getText();
        if(id.length()==0){
          JOptionPane.showMessageDialog(this,"Ingrese la identificacion del Actor","Error",JOptionPane.ERROR_MESSAGE );  
          return;
        }
        Short ident;
        try{
          ident= Short.parseShort(id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"la identificacion debe ser numerica","Error",JOptionPane.ERROR_MESSAGE );  
          return;
        }
//        Actor nuevo = new Actor();
//        nuevo.setActorId(ident);
        ActorDAO managerActor = new ActorDAO();
        managerActor.eliminaActor(ident);
        runQueryAll();
      //  JOptionPane.showMessageDialog(this,"Actor eliminado exitosamente","Logro",JOptionPane.INFORMATION_MESSAGE ); 
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void BotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarActionPerformed
        String nombre=firstNameTextField.getText();
        String apellido=lastNameTextField.getText();
        String id=identificacion.getText();
        if(id.length()==0||nombre.length()==0 ||apellido.length()==0){
            JOptionPane.showMessageDialog(this,"Ingrese todos los datos para poder registrar el Actor","Datos Faltantes",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Short ident;
        try{
          ident= Short.parseShort(id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"la identificacion debe ser numerica","Error",JOptionPane.ERROR_MESSAGE );  
          return;
        }
        Date fechaHoy= new Date();
        Actor nuevo = new Actor();
        nuevo.setActorId(ident);
        nuevo.setFirstName(nombre);
        nuevo.setLastName(apellido);
        nuevo.setLastUpdate(fechaHoy);
        ActorDAO managerActor = new ActorDAO();
        managerActor.actualizaActor(nuevo);
        runQueryBasedOnFirstName();
       // JOptionPane.showMessageDialog(this,"Actor ingresado exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE );  
        
    }//GEN-LAST:event_BotonActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(PeliculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeliculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeliculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeliculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeliculaForm().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField identificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton queryButton;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
}
