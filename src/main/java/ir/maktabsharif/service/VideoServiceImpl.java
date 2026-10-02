package ir.maktabsharif.service;

import ir.maktabsharif.model.Video;
import ir.maktabsharif.repository.VideoRepositoryImpl;
import ir.maktabsharif.service.base.BaseServiceImpl;

public class VideoServiceImpl extends BaseServiceImpl<Video,Long, VideoRepositoryImpl> implements VideoService {
    public VideoServiceImpl(VideoRepositoryImpl repository) {
        super(repository);
    }
}
