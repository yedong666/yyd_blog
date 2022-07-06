package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.util.PrintfMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @Value("${coverImgFilePath}")
    private String coverImgFilePath;

    @RequestMapping(value = "uploadCoverImg", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('USER')")
    public Result uploadCoverImg(@RequestParam("file") MultipartFile file){
        PrintfMessage.logRequest("uploadCoverImg");
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        String path = "C:\\Users\\lee\\Desktop\\myblog\\blog_back\\src\\main\\resources\\static\\imgs\\articleCoverImg\\";
        String filePath = this.coverImgFilePath;
        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            return Result.success("http://localhost:8888/imgs/articleCoverImg/"+fileName);
        } catch (IOException e) {
            return Result.error("上传失败, 请重试");
        }
    }
}
