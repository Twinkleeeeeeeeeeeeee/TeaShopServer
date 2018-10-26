package com.hmjy.service;
import com.hmjy.pojo.Category;
import com.hmjy.util.Page;

import java.util.List;
public interface CategoryService{
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
    Category get(int id);

}