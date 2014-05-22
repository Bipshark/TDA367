package edu.chalmers.sankoss.desktop.mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

/**
 * Abstraction of the game model.
 * The model will handle the client.
 *
 * @author Mikael Malmqvist
 * @date 3/24/14
 */
public abstract class AbstractModel {
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public AbstractModel() {

    }

    public void dispose() {

    }

    public PropertyChangeSupport getPcs() {
        return pcs;
    }

    public void addPcl(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }

    public void fireChange(String msg, Object value) {
        pcs.firePropertyChange(msg, null, value);
    }

}