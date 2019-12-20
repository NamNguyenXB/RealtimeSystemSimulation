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
public class PeriodicTask extends RestrictedTimeTask{
    double phase;
    double p;
    
    public void setPhase(double val){
        this.phase = val;
    }
    
    public double getPhase(){
        return this.phase;
    }
    
    public double getPeriod(){
        return this.p;
    }
    
    public void setPeriod(double val){
        this.p = val;
    }
    
    public PeriodicTask(){
        this.phase = 0;
        this.p = 0;
    }
    
    public PeriodicTask(double phase, double p, double e, double rDeadline){
        this.phase = phase;
        this.p = p;
        this.e = e;
        this.rDeadline = rDeadline;
    }
    
    public PeriodicTask(double p, double e){
        this.phase = 0;
        this.p = p;
        this.e = e;
        this.rDeadline = p;
    }
}
