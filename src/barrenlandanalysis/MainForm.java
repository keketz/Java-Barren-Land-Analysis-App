/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barrenlandanalysis;

import java.util.Arrays;

public class MainForm extends javax.swing.JFrame {
    ForestFireFillLand land = new ForestFireFillLand(); 
    
    public MainForm() {
        initComponents();
    }
    
    private boolean IsValidInput(String plot) {        
        String[] c = plot.split(" ");
        if (c.length != 4) { InputErrorLabel.setText("<html>Invalid Input: Input requires four numbers separated by a space.</html>"); return false; }
        if (isNaN(c[0]) || isNaN(c[1]) || isNaN(c[2]) || isNaN(c[3])) { 
            InputErrorLabel.setText("<html>Invalid Input: Input is not a number.</html>"); return false; 
        }
        if (Integer.parseInt(c[0], 10) >= Integer.parseInt(c[2], 10) || Integer.parseInt(c[1], 10) >= Integer.parseInt(c[3], 10)) { 
            InputErrorLabel.setText("<html>Invalid Input: Input does not contain the bottom left and the top right coordinates in the correct order.</html>"); return false;
        }
        if (Integer.parseInt(c[0], 10) < 0 || Integer.parseInt(c[1], 10) < 0 || Integer.parseInt(c[2], 10) >= 400 || Integer.parseInt(c[3], 10) >= 600) { 
            InputErrorLabel.setText("<html>Invalid Input: Input exceeds farm area.</html>"); return false; 
        }
        
        if (BarrenLandListTextarea.getText().contains(plot)) { 
            InputErrorLabel.setText("<html>Invalid Input: Area already exists.</html>"); 
            return false; 
        } 
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BarrenLandInput = new javax.swing.JTextField();
        AddBarrenLandBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BarrenLandListTextarea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FertileLandListTextarea = new javax.swing.JTextArea();
        ResetBtn = new javax.swing.JButton();
        InputErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Barren Land Analysis");

        jLabel2.setText("Input");

        BarrenLandInput.setToolTipText("0 292 399 307");

        AddBarrenLandBtn.setText("Add");
        AddBarrenLandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBarrenLandBtn(evt);
            }
        });

        BarrenLandListTextarea.setColumns(20);
        BarrenLandListTextarea.setRows(5);
        jScrollPane1.setViewportView(BarrenLandListTextarea);

        jLabel3.setText("Output");

        FertileLandListTextarea.setColumns(20);
        FertileLandListTextarea.setRows(5);
        jScrollPane2.setViewportView(FertileLandListTextarea);

        ResetBtn.setText("RESET");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        InputErrorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        InputErrorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        InputErrorLabel.setMaximumSize(new java.awt.Dimension(292, 0));
        InputErrorLabel.setMinimumSize(new java.awt.Dimension(292, 0));
        InputErrorLabel.setPreferredSize(new java.awt.Dimension(292, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InputErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ResetBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BarrenLandInput, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(AddBarrenLandBtn)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(InputErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarrenLandInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBarrenLandBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBarrenLandBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBarrenLandBtn
        String input = (BarrenLandInput.getText()).replace('"', '{').replace("{", "").replace("}", "");        
        String inputList = BarrenLandListTextarea.getText();
        if(IsValidInput(input)){
            if(inputList.length() > 0){inputList += ("\n"+ input);}
            else {inputList = input;}        
            BarrenLandListTextarea.setText(inputList);

            land.ResetPlots();
            //FloodFillLand land = new FloodFillLand(); //Marks all plots of land to 0, resetting them all to fertile

            String[] coordinates = input.split(",");
            //BarrenLandListTextarea.setText(input.replace(",","\n"));        
            land.MarkBarrenLand(coordinates);
            //{"0 292 399 307"};
            //{"48 192 351 207","48 392 351 407","120 52 135 547","260 52 275 547"};

            int[] fertileLand = land.FertileLand();
            String output = Integer.toString(fertileLand[0]);
            for(int i = 1; i < fertileLand.length; i++){
                output += "\n" + fertileLand[i];
            }

            FertileLandListTextarea.setText(output);
        }
    }//GEN-LAST:event_AddBarrenLandBtn

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        BarrenLandInput.setText("");        
        BarrenLandListTextarea.setText("");
        FertileLandListTextarea.setText("");
        land = new ForestFireFillLand();
    }//GEN-LAST:event_ResetBtnActionPerformed

    public static void main(String args[]) {       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBarrenLandBtn;
    private javax.swing.JTextField BarrenLandInput;
    private javax.swing.JTextArea BarrenLandListTextarea;
    private javax.swing.JTextArea FertileLandListTextarea;
    private javax.swing.JLabel InputErrorLabel;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private boolean isNaN(String coord) {
        try { 
            Integer.parseInt(coord); 
        } 
        catch(NumberFormatException | NullPointerException e) { 
            return true; 
        }
        return false;
    }
}
