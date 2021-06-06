package com.whoiszxl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.whoiszxl.dao.BlogCommentDao;
import com.whoiszxl.entity.BlogComment;
import com.whoiszxl.repository.BlogCommentRepository;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao {

	
	@Autowired
	private BlogCommentRepository blogCommentRepository;
	

	@Override
    public Page<BlogComment> findAll(Pageable pageable) {
        return blogCommentRepository.findAll(pageable);
    }

    @Override
    public List<BlogComment> findAll() {
        return blogCommentRepository.findAll();
    }

    @Override
    public List<BlogComment> findAll(Sort var1) {
        return blogCommentRepository.findAll(var1);
    }

    @Override
    public List<BlogComment> findAllById(Iterable<Long> var1) {
        return blogCommentRepository.findAllById(var1);
    }

    @Override
    public <S extends BlogComment> List<S> saveAll(Iterable<S> var1) {
        return blogCommentRepository.saveAll(var1);
    }

    @Override
    public void flush() {
        blogCommentRepository.flush();
    }

    @Override
    public <S extends BlogComment> S saveAndFlush(S var1) {
        return blogCommentRepository.saveAndFlush(var1);
    }

    @Override
    public void deleteInBatch(Iterable<BlogComment> var1) {
        blogCommentRepository.deleteInBatch(var1);
    }

    @Override
    public void deleteAllInBatch() {
        blogCommentRepository.deleteAllInBatch();
    }

    @Override
    public BlogComment getOne(Long var1) {
        return blogCommentRepository.getOne(var1);
    }

    @Override
    public <S extends BlogComment> List<S> findAll(Example<S> var1) {
        return blogCommentRepository.findAll(var1);
    }

    @Override
    public <S extends BlogComment> List<S> findAll(Example<S> var1, Sort var2) {
        return blogCommentRepository.findAll(var1, var2);
    }

	@Override
	public int deleteBlogCommentByIdAndMemberId(Long id, Long memberId) {
		return blogCommentRepository.deleteBlogCommentByIdAndMemberId(id, memberId);
	}

}
