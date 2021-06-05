package com.whoiszxl.dao.impl;

import com.whoiszxl.dao.MicroBlogDao;
import com.whoiszxl.entity.MicroBlog;
import com.whoiszxl.repository.MicroBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MicroBlogDaoImpl implements MicroBlogDao {

    @Autowired
    private MicroBlogRepository microBlogRepository;


    @Override
    public int deleteMicroBlogByIdAndMemberId(Long id, Long memberId) {
        return microBlogRepository.deleteMicroBlogByIdAndMemberId(id, memberId);
    }

    @Override
    public Page<MicroBlog> findAll(Pageable pageable) {
        return microBlogRepository.findAll(pageable);
    }

    @Override
    public List<MicroBlog> findAll() {
        return microBlogRepository.findAll();
    }

    @Override
    public List<MicroBlog> findAll(Sort var1) {
        return microBlogRepository.findAll(var1);
    }

    @Override
    public List<MicroBlog> findAllById(Iterable<Long> var1) {
        return microBlogRepository.findAllById(var1);
    }

    @Override
    public <S extends MicroBlog> List<S> saveAll(Iterable<S> var1) {
        return microBlogRepository.saveAll(var1);
    }

    @Override
    public void flush() {
        microBlogRepository.flush();
    }

    @Override
    public <S extends MicroBlog> S saveAndFlush(S var1) {
        return microBlogRepository.saveAndFlush(var1);
    }

    @Override
    public void deleteInBatch(Iterable<MicroBlog> var1) {
        microBlogRepository.deleteInBatch(var1);
    }

    @Override
    public void deleteAllInBatch() {
        microBlogRepository.deleteAllInBatch();
    }

    @Override
    public MicroBlog getOne(Long var1) {
        return microBlogRepository.getOne(var1);
    }

    @Override
    public <S extends MicroBlog> List<S> findAll(Example<S> var1) {
        return microBlogRepository.findAll(var1);
    }

    @Override
    public <S extends MicroBlog> List<S> findAll(Example<S> var1, Sort var2) {
        return microBlogRepository.findAll(var1, var2);
    }
}
