package j1.l.p0071_taskmanagement;

/**
 * Task class
 *
 * @version 10.00pm 25 Jan 2025
 * @author VQPC
 */
public class Task {
    private int id;
    private int typeid;
    private String name;
    private String date;
    private double planfrom;
    private double planto;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int typeid, String name, String date, double planfrom, double planto, String assignee, String reviewer) {
        this.id = id;
        this.typeid = typeid;
        this.name = name;
        this.date = date;
        this.planfrom = planfrom;
        this.planto = planto;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return typeid;
    }

    public void setType(int typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanfrom() {
        return planfrom;
    }

    public void setPlanfrom(double planfrom) {
        this.planfrom = planfrom;
    }

    public double getPlanto() {
        return planto;
    }

    public void setPlanto(double planto) {
        this.planto = planto;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    
}
