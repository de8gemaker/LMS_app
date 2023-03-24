package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.courseware.courseware.manage.base.Result;
import com.courseware.courseware.manage.entity.TemplateInfoEntity;
import com.courseware.courseware.manage.mapper.TemplateInfoDao;
import com.courseware.courseware.manage.param.TemplateInfoParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ltf
 */
@Slf4j
@RestController
public class TemplateInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateInfoController.class);

    @Autowired
    private TemplateInfoDao templateInfoDao;

    @Value("${spring.upload.path}")
    private String path;

    @Value("${spring.file.domain}")
    private String domainUrl;

    @GetMapping("/template/list")
    public Result<TemplateInfoEntity> list(@ModelAttribute TemplateInfoParam param){
        Result result = new Result();
        result.setCode(200);
        try {
            IPage<TemplateInfoEntity> page = new Page<>(param.getPage(),param.getSize());
            QueryWrapper<TemplateInfoEntity> wrapper = new QueryWrapper<>();
            TemplateInfoEntity classFeeEntity = new TemplateInfoEntity();
            BeanUtils.copyProperties(param,classFeeEntity);
            wrapper.setEntity(classFeeEntity);
            result.setEntity(templateInfoDao.selectPage(page,wrapper));
        }catch (Exception e){
            log.error("TemplateInfoController list error",e);
            result.setCode(500);
            result.setMessage("查询失败");
        }
        return result;
    }

    @PostMapping("/template/add")
    public Result<TemplateInfoEntity> add(@ModelAttribute TemplateInfoParam param){
        Result result = new Result();
        result.setCode(200);
        try {
            TemplateInfoEntity templateInfoEntity = new TemplateInfoEntity();
            BeanUtils.copyProperties(param,templateInfoEntity);
            templateInfoDao.insert(templateInfoEntity);
        }catch (Exception e){
            result.setCode(500);
            result.setMessage("添加失败");
        }
        return result;
    }


    @PostMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) {
        Result result = new Result();
        result.setCode(200);
        if (file.isEmpty()) {
            result.setCode(400);
            result.setMessage("上传失败，请选择文件");
            return result;
        }
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length()).toLowerCase();
        fileName = UUID.randomUUID().toString()+ext;

        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            Map<String,String> map =  new HashMap<>();
            map.put("url",domainUrl+fileName);
            result.setEntity(map);
            return result;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            result.setCode(500);
            result.setMessage("上传失败！");
        }
        return result;
    }

    @PostMapping("/uploadOther")
    @ResponseBody
    public Result uploadOther(@RequestParam("file") MultipartFile file) {
        Result result = new Result();
        result.setCode(200);
        if (file.isEmpty()) {
            result.setCode(400);
            result.setMessage("上传失败，请选择文件");
            return result;
        }
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length()).toLowerCase();
        fileName = UUID.randomUUID().toString()+ext;
        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            Map<String,String> map =  new HashMap<>();
            map.put("url",fileName);
            result.setEntity(map);
            return result;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            result.setCode(500);
            result.setMessage("上传失败！");
        }
        return result;
    }

    @GetMapping("/download")
    public String download(String fileName, HttpServletResponse response) {
        File file = new File(path+fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

}
