package ir.maktabsharif.repository;

import ir.maktabsharif.model.Video;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

import java.util.Optional;

public class VideoRepositoryImpl extends BaseRepositoryImpl<Video, Long> implements VideoRepository {
    public VideoRepositoryImpl() {
        super(Video.class);
    }

    @Override
    protected Long getId(Video video) {
        return video.getId();
    }

    @Override
    protected void copyProperties(Video source, Video target) {
        if (Optional.ofNullable(source.getTitle()).isPresent()) {
            target.setTitle(source.getTitle());
        }
        if (Optional.ofNullable(source.getDescription()).isPresent()) {
            target.setDescription(source.getDescription());
        }
        if (Optional.ofNullable(source.getFilePath()).isPresent()) {
            target.setFilePath(source.getFilePath());
        }
        if (Optional.ofNullable(source.getFileSize()).isPresent()) {
            target.setFileSize(source.getFileSize());
        }
if(Optional.ofNullable(source.getPrice()).isPresent()){
    target.setPrice(source.getPrice());
}
if(Optional.ofNullable(source.getUploader()).isPresent()){
    target.setUploader(source.getUploader());
}
    }
}
