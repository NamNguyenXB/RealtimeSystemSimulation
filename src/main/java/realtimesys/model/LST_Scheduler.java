class LSTScheduling implements Scheduler
{
    List<PeriodicTask> taskList = new ArrayList<>();
    Schedule LSTschedule = new Schedule();
    public void setTasks(List<Task>tasks)
    {
        taskList = Arrays.copyOf(tasks, tasks.lenght, PeriodicTask[].class); //(PeriodicTask)tasks;
    }
    public Schedule getSchedule()
    {
        return LSTschedule; 
    }
    public void startSchedule()
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
            LSTschedule.getJobAssignments().add(highestPriTask);
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