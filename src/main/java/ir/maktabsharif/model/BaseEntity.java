package ir.maktabsharif.model;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
//@Getter
//@Setter

public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_at" , nullable = false , updatable = false)
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    @PrePersist
    protected void OnCreate(){
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void OnUpdate(){
        this.updateAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
}
