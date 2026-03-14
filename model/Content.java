public class Content {
    private int id;
    private String title;
    private int week;
    private String type;
    private int durationHours;
    public Content(int id, String title, int week, String type, int durationHours) {
        this.id = id;
        this.title = title;
        this.week = week;
        this.type = type;
        this.durationHours = durationHours;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDurationHours() {
        return durationHours;
    }
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }
    @Override
    public String toString() {
        return "Content [id=" + id + ", title=" + title + ", week=" + week + ", type=" + type + ", durationHours="
                + durationHours + "]";
    }
    
}
