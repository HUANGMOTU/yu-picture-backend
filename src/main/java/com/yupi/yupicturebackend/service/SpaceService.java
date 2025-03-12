package com.yupi.yupicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.yupi.yupicturebackend.model.dto.space.SpaceQueryRequest;
import com.yupi.yupicturebackend.model.entity.Space;
import com.yupi.yupicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupicturebackend.model.vo.SpaceVO;
import com.yupi.yupicturebackend.model.entity.Space;

import javax.servlet.http.HttpServletRequest;

/**
* @author 24826
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-03-11 15:15:34
*/
public interface SpaceService extends IService<Space> {

    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest SpaceQueryRequest);

    SpaceVO getSpaceVO(Space Space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> SpacePage, HttpServletRequest request);

}
