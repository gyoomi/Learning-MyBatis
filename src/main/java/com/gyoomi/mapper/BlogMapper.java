/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.mapper;

import com.gyoomi.entity.Blog;

import java.util.List;

/**
 * 接口功能描述
 *
 * @author Leon
 * @version 2019/1/18 11:09
 */
public interface BlogMapper {

    List<Blog> findByList();
}
