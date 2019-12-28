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
class LSTScheduling implements Scheduler
{
    Schedule LSTschedule = new Schedule();
    public void setTasks(List<Task >tasks)
    {
        
    }
    public Schedule getSchedule()
    {
        return LSTschedule; 
    }
    public void startSchedule(final List<PeriodicTask> taskList)
    {
        double lcm = calcLCM(taskList);
        
        for(int timeUnit = 0; timeUnit < lcm; timeUnit++) 
        {
            double minSlacktime = lcm;
            PeriodicTask highestPriTask = new PeriodicTask();
            for(PeriodicTask t : taskList) 
            {
                if ((timeUnit == t.rDeadline) && (t.e != 0))
                {
                    
                }
                else if ((timeUnit == t.rDeadline) && (t.e == 0))
                {
                    t.phase = timeUnit;
                }
                double slacktime = t.phase + t.getRDeadline() - (timeUnit + t.e);
                if (minSlacktime > slacktime)
                {
                    minSlacktime = slacktime;
                    highestPriTask = t;
                }
            }
            // Decrease the execution time of the highest pri task.
            highestPriTask.e = highestPriTask.e - 1;
            // Add current task into the task list.
            LSTschedule.getJobAssignments().add(l);
        }
    }
    static double calcLCM(List<PeriodicTask> taskList) {

        double lcm = taskList.get(0).getPeriod();
        for(boolean flag = true; flag; ) {
            for(PeriodicTask x : taskList) {
                if(lcm % x.getPeriod() != 0) {
                    flag = true;
                    break;
                }
                flag = false;
            }
            lcm = flag? (lcm + 1) : lcm;
        }
        return lcm;

    }
}