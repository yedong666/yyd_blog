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

    @Value("${file.location}")
    private String filePath;

    @Value("${address}")
    private String address;

    @RequestMapping(value = "uploadCoverImg", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result uploadCoverImg(@RequestParam("file") MultipartFile file){
        PrintfMessage.logRequest("uploadCoverImg");
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        File dest = new File(this.filePath + "imgs\\articleCoverImg\\" + fileName);
        try {
            file.transferTo(dest);
            //返回访问路径
            return Result.success("/imgs/articleCoverImg/" + fileName);
        } catch (IOException e) {
            return Result.error("上传失败, 请重试");
        }
    }

    @RequestMapping(value = "uploadTagImg", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result uploadTagImg(@RequestParam("file") MultipartFile file){
        PrintfMessage.logRequest("uploadTagImg");
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        File dest = new File(this.filePath + fileName);
        try {
            file.transferTo(dest);
            return Result.success("/imgs/tagImg/" + fileName);
        } catch (IOException e) {
            return Result.error("上传失败, 请重试");
        }
    }

    @RequestMapping(value = "uploadAvatarImg", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result uploadAvatarImg(@RequestParam("file") MultipartFile file){
        PrintfMessage.logRequest("uploadAvatarImg");
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        File dest = new File(this.filePath + fileName);
        try {
            file.transferTo(dest);
            return Result.success("imgs/avatarImg/" + fileName);
        } catch (IOException e) {
            return Result.error("/上传失败, 请重试");
        }
    }
}
