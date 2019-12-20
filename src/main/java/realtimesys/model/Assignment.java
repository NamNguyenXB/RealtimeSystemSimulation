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
public class Assignment {
    double beginTime;
    double endTime;
    Job job;

    public double getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(double beginTime) {
        this.beginTime = beginTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
    public boolean isMissDeadline(){
        if((job!=null)&& (job.getDeadline() > 0)){
            return job.getDeadline() < this.endTime;
        }
        return false;
    }
}
