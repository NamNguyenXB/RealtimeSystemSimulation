/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author namng
 */
public class Schedule {
    List<Assignment> jobAssignments;
    
    public Schedule(){
        jobAssignments = new ArrayList<>();
    }
    
    public List<Assignment> getJobAssignments(){
        return this.jobAssignments;
    }
}
