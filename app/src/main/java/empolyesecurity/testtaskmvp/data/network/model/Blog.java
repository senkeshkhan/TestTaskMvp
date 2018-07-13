package empolyesecurity.testtaskmvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "blog")
public  class Blog {


    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;


    @Expose
    @SerializedName("blog_url")
    @Property(nameInDb = "blog_url")
    private String blogUrl;

    @Expose
    @SerializedName("img_url")
    @Property(nameInDb = "img_url")
    private String coverImgUrl;

    @Expose
    @SerializedName("title")
    @Property(nameInDb = "title")
    private String title;

    @Expose
    @SerializedName("description")
    @Property(nameInDb = "description")
    private String description;

    @Expose
    @SerializedName("author")
    @Property(nameInDb = "author")
    private String author;

    @Expose
    @SerializedName("published_at")
    @Property(nameInDb = "published_at")
    private String date;

    @Generated(hash = 685401094)
    public Blog(Long id, String blogUrl, String coverImgUrl, String title,
                String description, String author, String date) {
        this.id = id;
        this.blogUrl = blogUrl;
        this.coverImgUrl = coverImgUrl;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    @Generated(hash = 1388801592)
    public Blog() {
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;

        Blog blog = (Blog) o;

        if (!blogUrl.equals(blog.blogUrl)) return false;
        if (!coverImgUrl.equals(blog.coverImgUrl)) return false;
        if (!title.equals(blog.title)) return false;
        if (!description.equals(blog.description)) return false;
        if (!author.equals(blog.author)) return false;
        return date.equals(blog.date);

    }

    @Override
    public int hashCode() {
        int result = blogUrl.hashCode();
        result = 31 * result + coverImgUrl.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}