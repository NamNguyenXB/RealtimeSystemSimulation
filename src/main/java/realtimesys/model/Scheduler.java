/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.model;

import java.util.List;

/**
 *
 * @author namng
 */
public interface Scheduler {
    List<Task> getTasks();
    void setTasks(List<Task >tasks);
    PeriodicTask getTask(int taskId);
    void addTask(Task task);
    void removeTask(int taskId);
    void startSchedule();
    Schedule getSchedule();
}
