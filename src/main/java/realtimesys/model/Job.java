/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.model;

/**
 *
 * @author namng
 */
public class Job {
    int id;
    Task task;
    double releaseTime;
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int val){
        this.id = val;
    }
    
    public Task getTask(){
        return this.task;
    }
    
    public double getReleaseTime(){
        return this.releaseTime;
    }
    
    public Job(Task task, int id, double releaseTime){
        this.task = task;
        this.id = id;
        this.releaseTime = releaseTime;
    }
    
    public double getDeadline(){
        if((this.task != null) && (this.task instanceof RestrictedTimeTask))
        {
            RestrictedTimeTask t = (RestrictedTimeTask)this.task;
            return this.releaseTime + t.getRDeadline();
        }
        else return -1;
    }
}
