/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimesys.presenter;

import realtimesys.model.Task;

/**
 *
 * @author namng
 */
public interface ShortViewPresenter {
    public void Edit(Task task);
    public void Delete(Task task);
}
