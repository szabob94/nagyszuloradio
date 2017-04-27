package hu.sajat.radio;

public class RadioEntity {
    private Integer id;
    private Integer iconResource;
    private String dataStreamUrl;
    private String name;

    public RadioEntity() {
    }

    public RadioEntity(Integer id, Integer iconResource, String dataStreamUrl, String name) {
        this.id = id;
        this.iconResource = iconResource;
        this.dataStreamUrl = dataStreamUrl;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIconResource() {
        return iconResource;
    }

    public void setIconResource(Integer iconResource) {
        this.iconResource = iconResource;
    }

    public String getDataStreamUrl() {
        return dataStreamUrl;
    }

    public void setDataStreamUrl(String dataStreamUrl) {
        this.dataStreamUrl = dataStreamUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RadioEntity that = (RadioEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iconResource != null ? !iconResource.equals(that.iconResource) : that.iconResource != null)
            return false;
        if (dataStreamUrl != null ? !dataStreamUrl.equals(that.dataStreamUrl) : that.dataStreamUrl != null)
            return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iconResource != null ? iconResource.hashCode() : 0);
        result = 31 * result + (dataStreamUrl != null ? dataStreamUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RadioEntity{" +
                "id=" + id +
                ", iconResource=" + iconResource +
                ", dataStreamUrl='" + dataStreamUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
