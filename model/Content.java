public class Content extends BaseClass{
    private String title;
    private String description;
    private ContentType type;
    private int durationHours;
    public Content(){

    }
    public Content(String id, String title, String description, ContentType type, int durationHours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.durationHours = durationHours;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ContentType getType() {
        return type;
    }
    public void setType(ContentType type) {
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
        return "Content [id=" + id + ", title=" + title + ", description=" + description + ", type=" + type
                + ", durationHours=" + durationHours + "]";
    }

    
}