package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.NoveltyStatus;
import java.util.List;

public interface NoveltyStatusService {
    public List<NoveltyStatus> findAll() throws Exception;
    public NoveltyStatus findById(int id);
    public void create(NoveltyStatus noveltyStatus);
    public void update(NoveltyStatus noveltyStatus);
    public void delete(NoveltyStatus noveltyStatus);
}
