package com.shareTools.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bookmark")
public class bookmarkController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  描述：上传 bookmark.html
     *
     *          使用 js 把 数据源 处理 有层级 json
     *          使用自己制定算法，写list tree
     *          传递到后台，进行存储，
     *          转换 成为 tree 给 前台
     */

    /**
     *  解析书签并转化Tree 结构.
     */
    @RequestMapping(value="/ParseBookMarkConversionTrees", method= RequestMethod.POST)
    @ResponseBody
    public String ParseBookMarkConversionTrees(@RequestParam("FilePath") String FilePath, @RequestParam("FileContent") String FileContent) {

        logger.info("FilePath -> "+ FilePath + " FileContent -> "+ FileContent);

        return "Request successful. Post param : Integer - " ;
    }











}
