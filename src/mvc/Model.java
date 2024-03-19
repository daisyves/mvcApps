package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {

    public Boolean unsavedChanges;
    public String fileName;

    // TODO: All methods below

    public Model(){
        unsavedChanges = false;
        fileName = null;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void changed(){
        this.unsavedChanges = true;
        notifySubscribers();
    }
}
