/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.presenter;

import java.util.List;
import javax.swing.JFrame;
import realtimesys.model.DMScheduler;
import realtimesys.model.EDFScheduler;
import realtimesys.model.LSTScheduler;
import realtimesys.model.PeriodicTask;
import realtimesys.model.RMScheduler;
import realtimesys.model.Scheduler;
import realtimesys.model.Task;
import realtimesys.view.AddTaskFrame;
import realtimesys.view.ApplicationFrame;
import realtimesys.view.EditTaskView;

/**
 *
 * @author namng
 */
public class Presenter implements AddTaskPresenter, AppPresenter, EditTaskPresenter, ShortViewPresenter {

    Scheduler scheduler;
    @Override
    public void addTask(Task task) {
        if(appView != null && task instanceof PeriodicTask){
            appView.addTask((PeriodicTask)task);
        }
    }
    private ApplicationFrame appView;

    /**
     * Get the value of appView
     *
     * @return the value of appView
     */
    public ApplicationFrame getAppView() {
        return appView;
    }

    /**
     * Set the value of appView
     *
     * @param appView new value of appView
     */
    @Override
    public void setAppView(ApplicationFrame appView) {
        this.appView = appView;
    }


    @Override
    public void requestAddTask() {
        AddTaskFrame f = new AddTaskFrame();
        f.setPresenter(this);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void changeScheduler(int id) {
        switch(id){
            case 0: 
                System.out.print("Switch to RMScheduler");
                scheduler = new RMScheduler();
                break;
            case 1:
                System.out.print("Switch to DMScheduler");
                scheduler = new DMScheduler();
                break;
            case 2:
                System.out.print("Switch to LSTScheduler");
                scheduler = new LSTScheduler();
                break;
            case 3:
                System.out.print("Switch to EDFScheduler");
                scheduler = new EDFScheduler();
                break;
        }
    }

    @Override
    public void schedule(List<Task> tasks) {
        if(scheduler != null){
            scheduler.setTasks(tasks);
            scheduler.startSchedule();
            if(appView != null){
                appView.displaySchedule(scheduler.getSchedule());
            }
        }
    }

    @Override
    public void EditTask(Task task) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        appView.UpdateTask(task);
    }

    @Override
    public void Edit(Task task) {
        System.out.print("Edit task");
        EditTaskView editView = new EditTaskView();
        editView.setTask((PeriodicTask)task);
        editView.setPresenter(this);
        editView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editView.setVisible(true);
        
    }

    @Override
    public void Delete(Task task) {
        appView.DeleteTask(task);
    }
    
}
