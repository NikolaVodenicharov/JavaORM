package entities.labels;

import entities.shampoos.BasicShampoo;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class BasicLabel implements Label {
    public BasicLabel(){}

    public BasicLabel(String title, String subtitle){
        this.setTitle(title);
        this.setSubtitle(subtitle);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class, cascade = CascadeType.ALL)
    private BasicShampoo basicShampoo;

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubtitle() {
        return this.subtitle;
    }
    @Override
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
