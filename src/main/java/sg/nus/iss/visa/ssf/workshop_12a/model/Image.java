package sg.nus.iss.visa.ssf.workshop_12a.model;

// Model class to just populate data, no beans/objects/entities need to be created, hence no annotations are required 
// Annotations: (Controller, Service, Repository, Component)
public class Image {

    /*
     *  1. Getters and Setters
     *  2. Constructors
     *  3. toString() method
     */
    
    private String name;
    private String path;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }
    @Override
    public String toString() {
        return "Image [name=" + name + ", path=" + path + "]";
    }


}
