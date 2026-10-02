package ir.maktabsharif.model;

import ir.maktabsharif.enums.Role;
import jakarta.persistence.*;
//import lombok.*;

import java.math.BigDecimal;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Video extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String filePath;
    @Column(nullable = false)
    private Long fileSize;
    private BigDecimal price;
    @JoinColumn(nullable = false ,name = "uploader_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users uploader;

    public Video() {
    }

    public Video(String title, String description, String filePath, Long fileSize, String price) {
        this.title = title;
        this.description = description;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.price = new BigDecimal(price);
        this.uploader = new Users("Ali" , "123456" , "Ali@gmail.com" , Role.USER);
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Users getUploader() {
        return uploader;
    }

    public void setUploader(Users uploader) {
        this.uploader = uploader;
    }
}
