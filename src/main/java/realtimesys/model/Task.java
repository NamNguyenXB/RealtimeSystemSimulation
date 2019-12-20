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
public class Task {
    int id;
    String name;
    static int cnt;
    double e;
    
    public double getExeTime(){
        return this.e;
    }
    
    public void setExeTime(double val){
        this.e = val;
    }
    
    public void setName(String val){
        this.name = val;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Task(){
        this.id = getNewId();
        this.name = "task_" + String.valueOf(this.id);
    }
    
    private int getNewId(){
        return cnt++;
    }
}