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
public class RestrictedTimeTask extends Task{
    double rDeadline;
    
    public double getRDeadline(){
        return this.rDeadline;
    }
    
    public void setRDeadline(double val){
        this.rDeadline = val;
    }
    
    public RestrictedTimeTask(){
        this.rDeadline = 0;
    }
}
