/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.presenter;

import java.util.List;
import realtimesys.model.Task;
import realtimesys.view.ApplicationFrame;

/**
 *
 * @author namng
 */
public interface AppPresenter {
    public void requestAddTask();
    public void changeScheduler(int id);
    public void setAppView(ApplicationFrame appView);
    public void schedule(List<Task> tasks);
}
