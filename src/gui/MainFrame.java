/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package gui;

import java.awt.Color;
import neural_network.NeuralNetwork;
import neural_network.Teacher;
import task.Task;

public class MainFrame extends javax.swing.JFrame {

    private Task task;
    
    private NeuralNetwork network;
    private final int INPUT_SIGNALS = 4;
    private final int OUTPUT_SIGNALS = 2;
    
        
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        
        initComponents();
        
        this.initNetwork();
        
        this.render();
        
    }
    
    
    
    
    private void initNetwork() {
        this.network = new NeuralNetwork(this.INPUT_SIGNALS, OUTPUT_SIGNALS);
    }
    
    private void render() {
        this.displayTask();
        
        this.displayNeuralNetwork();
    }
    
    /**
     * Displaying NeuralNetwork and its response.
     */
    private void displayNeuralNetwork() {
        
        float[] inputSignals = this.task.getInputSignalsVector();
        
        float positiveState = network.getNeuralLayer().getNeuron(0).getState(inputSignals);
        float negativeState = network.getNeuralLayer().getNeuron(1).getState(inputSignals);
        
        this.neuralLayerPanel.displayNeuralLayer(network.getNeuralLayer().getNeuron(0).getWeightsVector(),
                                                 positiveState,
                                                 network.getNeuralLayer().getNeuron(1).getWeightsVector(),
                                                 negativeState); 
        
        String answer = "not your color";
        if (positiveState > negativeState) {
            answer = "your color";
        }
        this.answerLabel.setText(answer);
        
    }
    
    /**
     * Generating and displaying new Task.
     */
    private void displayTask() {
        this.task = new Task();
        Color color = this.task.getColor();
        this.taskPanel.displayColor(color);
    }
    
    
    private void correctNetwork(boolean evaluation) {
        
        Teacher teacher = new Teacher(this.network);
        float[] inputSignals = this.task.getInputSignalsVector();
        
        teacher.correctNeuralNetwork(inputSignals, evaluation);
        
        this.render();
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskPanel = new gui.TaskPanel();
        answerLabel = new javax.swing.JLabel();
        rightButton = new javax.swing.JButton();
        wrongButton = new javax.swing.JButton();
        neuralLayerPanel = new gui.NeuralLayerPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Recognition");
        setLocation(new java.awt.Point(200, 200));
        setResizable(false);

        answerLabel.setText("not your color");

        rightButton.setText("right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        wrongButton.setText("wrong");
        wrongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrongButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(taskPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(answerLabel))
                    .addComponent(rightButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wrongButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(neuralLayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(neuralLayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(answerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(wrongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        
        boolean evaluation = true;
        this.correctNetwork(evaluation);
        
    }//GEN-LAST:event_rightButtonActionPerformed

    private void wrongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrongButtonActionPerformed
        
        boolean evaluation = false;
        this.correctNetwork(evaluation);
        
    }//GEN-LAST:event_wrongButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answerLabel;
    private gui.NeuralLayerPanel neuralLayerPanel;
    private javax.swing.JButton rightButton;
    private gui.TaskPanel taskPanel;
    private javax.swing.JButton wrongButton;
    // End of variables declaration//GEN-END:variables
}
