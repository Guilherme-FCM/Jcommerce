package br.edu.ifto.model.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author GuilhermeFCM
 */
@Component
@Scope("session")
@Entity
public class Sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date = LocalDate.now();

    @OneToMany(mappedBy = "sale", cascade = CascadeType.PERSIST)
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    private User user = new User();
    
    public double total(){
        double sum = 0;
        for ( Item item : items ) sum += item.total();
        return sum;
    }

    public void addItem(Item item){
        item.setSale(this);
        items.add(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
