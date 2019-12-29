/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.view;

import realtimesys.presenter.AppPresenter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import realtimesys.model.Assignment;
import realtimesys.model.PeriodicTask;
import realtimesys.model.Schedule;
import realtimesys.model.Task;
import realtimesys.presenter.Presenter;
import realtimesys.presenter.ShortViewPresenter;

/**
 *
 * @author namng
 */
public class ApplicationFrame extends javax.swing.JFrame {

    /**
     * Creates new form ApplicationFrame
     */
    public ApplicationFrame() {
        this.conflictColor = Color.RED;
        this.colorTable = new Hashtable();
        initComponents();
    }
    
    private ArrayList<PeriodicTask> tasks;
    private Hashtable colorTable;
    private int colorSeed=0;
    private final Color conflictColor;
    private AppPresenter presenter;
    
    public void setTasks(ArrayList<PeriodicTask> tasks){
        if(tasks != null){
            if(this.tasks != null){
                colorTable = new Hashtable();
                taskShorts = new ArrayList<>(); 
            }
            this.tasks = tasks;
            for(int i = 0; i < tasks.size(); i++){
                registerColor(tasks.get(i).getId());
            }
            updateShortViews();
        }
    }
    
    public void addTask(PeriodicTask task){
        
        if(!colorTable.containsKey(task.getId())){
            if(tasks == null){
                tasks = new ArrayList<>();
            }
            tasks.add(task);
            registerColor(task.getId());
            TaskInfoShortViewWithEdit v = createShortView(task);
            addShortView(v);
        }
    }
    
    public ArrayList<PeriodicTask> getTasks(){
        return tasks;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        taskInfoPanel = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskShortView = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        addTaskButton = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        schedulePanel = new javax.swing.JPanel();
        rulerView2 = new realtimesys.view.RulerView();
        scheduleChart = new realtimesys.view.BarChart();
        logPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new java.awt.BorderLayout());

        taskInfoPanel.setBackground(new java.awt.Color(240, 240, 0));
        taskInfoPanel.setLayout(new java.awt.BorderLayout());

        taskShortView.setAutoscrolls(true);
        taskShortView.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        taskShortView.setPreferredSize(new java.awt.Dimension(350, 234));
        jScrollPane1.setViewportView(taskShortView);

        taskInfoPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        addTaskButton.setText("Add Task");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        reloadButton.setText("Schedule");
        reloadButton.setMaximumSize(new java.awt.Dimension(77, 23));
        reloadButton.setMinimumSize(new java.awt.Dimension(77, 23));
        reloadButton.setPreferredSize(new java.awt.Dimension(77, 23));
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RM", "DM", "LST", "EDF" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTaskButton)
                    .addComponent(reloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        schedulePanel.setAutoscrolls(true);

        javax.swing.GroupLayout rulerView2Layout = new javax.swing.GroupLayout(rulerView2);
        rulerView2.setLayout(rulerView2Layout);
        rulerView2Layout.setHorizontalGroup(
            rulerView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        rulerView2Layout.setVerticalGroup(
            rulerView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout scheduleChartLayout = new javax.swing.GroupLayout(scheduleChart);
        scheduleChart.setLayout(scheduleChartLayout);
        scheduleChartLayout.setHorizontalGroup(
            scheduleChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        scheduleChartLayout.setVerticalGroup(
            scheduleChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addGroup(schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rulerView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, schedulePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scheduleChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rulerView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(taskInfoPanel)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schedulePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskInfoPanel))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(schedulePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        if(presenter != null){
            presenter.requestAddTask();
        }
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        if(presenter != null)
            presenter.schedule(getEnabledTasks());
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(this);
        if (choice != JFileChooser.APPROVE_OPTION) return;
        File chosenFile = chooser.getSelectedFile();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(chosenFile.getAbsolutePath());
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                ArrayList<PeriodicTask> ret = (ArrayList)getEnabledTasks();
                objectOut.writeObject(ret);
                System.out.print("Write OK " + ret.size());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //setTasks()
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(this);
        if (choice != JFileChooser.APPROVE_OPTION) return;
        File chosenFile = chooser.getSelectedFile();
        
        FileInputStream fileIn;
        try {
            PeriodicTask.resetCnt();
            this.colorTable = new Hashtable();
            this.colorSeed = 0;
            fileIn = new FileInputStream(chosenFile.getAbsolutePath());
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            ArrayList<PeriodicTask> ts = (ArrayList)obj;
            
            if(ts.size() > 0){
                System.out.print("Parse OK");
            }
            else{
                System.out.print("Parse result: " + ts.size());
            }
            setTasks(ts);
            System.out.println("The Object has been read from the file");
            objectIn.close();
            this.pack();
            this.repaint();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    int currentSchedulerId = 0;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int schedulerId = jComboBox1.getSelectedIndex();
        if(presenter != null && currentSchedulerId != schedulerId){
            
            presenter.changeScheduler(schedulerId);
            currentSchedulerId = schedulerId;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private List<Task> getEnabledTasks(){
        List<Task> ret = new ArrayList<>();
        if(taskShorts != null){
            for(int i = 0; i < taskShorts.size(); i++){
                if(!taskShorts.get(i).isExcludeFromSchedule()){
                    ret.add(taskShorts.get(i).getTaskInfo());
                }
            }
        }
        return ret;
    }
    
    private TaskInfoShortViewWithEdit createShortView(PeriodicTask task){
        TaskInfoShortViewWithEdit ret = new TaskInfoShortViewWithEdit();
        ret.setTaskInfo(task);
        return ret;
    }
    
    private List<TaskInfoShortViewWithEdit> taskShorts = new ArrayList<>();
    
    private void updateShortViews(){
        taskShortView.removeAll();
        taskShorts = new ArrayList<>();
        if(tasks != null){
            for(int i = 0; i < tasks.size(); i++){
                TaskInfoShortViewWithEdit v = createShortView(tasks.get(i));
                addShortView(v);
            }
        }
        this.repaint();
    }
    
    public void DeleteTask(Task task){
        if(task != null){
            tasks.remove((PeriodicTask)task);
            updateShortViews();
        }
    }
    
    public void UpdateTask(Task task){
        if(task != null)
        {
            int id = task.getId();
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getId()==id){
                    tasks.set(i, (PeriodicTask)task);
                }
            }
            updateShortViews();
        }
    }
    
    private void addShortView(TaskInfoShortViewWithEdit v){
        v.setVisible(true);
        v.setPresenter((ShortViewPresenter)presenter);
        this.taskShortView.add(v);
        taskShorts.add(v);
        this.pack();
    }

    /**
     * Get the value of presenter
     *
     * @return the value of presenter
     */
    public AppPresenter getPresenter() {
        return presenter;
    }

    /**
     * Set the value of presenter
     *
     * @param presenter new value of presenter
     */
    public void setPresenter(AppPresenter presenter) {
        this.presenter = presenter;
        presenter.setAppView(this);
    }

    private Color genColor(){
        int v = ((colorSeed++ * 10) % 255);
        return new Color(v * 10, v * 10, v * 10);
    }
    
    public void displaySchedule(double frameSize, Schedule schedule){
        if (schedule != null){
            scheduleChart.clearView();
            double max = frameSize;
            ArrayList<BlockInfo> blocks = new ArrayList<>();
            List<Assignment> assignments = schedule.getJobAssignments();
            for(int i = 0; i < assignments.size(); i++){
                Color blkColor = assignments.get(i).getEndTime() > assignments.
                        get(i).getJob().getDeadline()? conflictColor:getColor(
                                assignments.get(i).getJob().getTask().getId());
                double blklen = assignments.get(i).getEndTime() - assignments.get(i).getBeginTime();
                BlockInfo b = new BlockInfo(assignments.get(i).getBeginTime(), 
                        blklen, blkColor, Color.BLACK);
                blocks.add(b);
            }
            scheduleChart.setFrameSize(max);
            double min = (double) Math.round(max / 20 * 100) / 100;;

            rulerView2.setMax(max);
            rulerView2.setMin(min);
            rulerView2.setInterval(min*5);
            scheduleChart.setBlocks(blocks);
            this.pack();
            this.repaint();
        }
    }
    
    public Color getColor(int taskId){
        registerColor(taskId);
        return (Color)colorTable.get(taskId);
    }

    private void registerColor(int taskId){
        if(!colorTable.containsKey(taskId)){
            Color c = genColor();
            colorTable.put(taskId, c);
        }
    }
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
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationFrame f = new ApplicationFrame();
                
                Presenter p = new Presenter();
                f.setPresenter(p);
                f.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logPanel;
    private javax.swing.JButton reloadButton;
    private realtimesys.view.RulerView rulerView2;
    private realtimesys.view.BarChart scheduleChart;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JLayeredPane taskInfoPanel;
    private javax.swing.JPanel taskShortView;
    // End of variables declaration//GEN-END:variables
}
