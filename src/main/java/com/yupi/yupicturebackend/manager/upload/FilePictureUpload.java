package com.yupi.yupicturebackend.manager.upload;

import cn.hutool.core.io.FileUtil;
import com.yupi.yupicturebackend.exception.ErrorCode;
import com.yupi.yupicturebackend.exception.ThrowUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class FilePictureUpload extends PictureUploadTemplate {

    @Override
    protected void validPicture(Object inputSource) {
        // 将输入源转换为 MultipartFile 类型
        MultipartFile multipartFile = (MultipartFile) inputSource;
        // 如果文件为空，则抛出异常
        ThrowUtils.throwIf(multipartFile == null, ErrorCode.PARAMS_ERROR, "文件不能为空");
        // 获取文件大小
        long fileSize = multipartFile.getSize();
        // 定义1M的大小
        final long ONE_M = 1024 * 1024L;
        // 如果文件大小超过5M，则抛出异常
        ThrowUtils.throwIf(fileSize > 5 * ONE_M, ErrorCode.PARAMS_ERROR, "文件大小不能超过 5M");
        // 获取文件后缀
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        // 允许上传的文件后缀
        final List<String> ALLOW_FORMAT_LIST = Arrays.asList("jpeg", "jpg", "png", "webp");
        // 如果文件后缀不在允许的列表中，则抛出异常
        ThrowUtils.throwIf(!ALLOW_FORMAT_LIST.contains(fileSuffix), ErrorCode.PARAMS_ERROR, "文件类型错误");
    }

    @Override
    // 重写父类方法，获取原始文件名
    protected String getOriginFilename(Object inputSource) {
        // 将输入源转换为MultipartFile类型
        MultipartFile multipartFile = (MultipartFile) inputSource;
        // 返回原始文件名
        return multipartFile.getOriginalFilename();
    }

    @Override
    // 重写父类方法，处理文件
    protected void processFile(Object inputSource, File file) throws Exception {
        // 将输入源转换为MultipartFile类型
        MultipartFile multipartFile = (MultipartFile) inputSource;
        // 将MultipartFile类型的文件保存到指定的文件中
        multipartFile.transferTo(file);
    }
}
