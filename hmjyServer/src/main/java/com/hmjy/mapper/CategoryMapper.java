package com.hmjy.mapper;
 
import com.hmjy.pojo.Category;
import com.hmjy.util.Page;

import java.util.List;
 
public interface CategoryMapper {
    public List<Category> list(Page page);
    public int total();
    void add(Category category);
    void delete(int id);
    Category get(int id);

}