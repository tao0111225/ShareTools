package com.shareTools.web.Utils;


import com.fasterxml.jackson.core.TreeNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shareTools.entity.BookMarkTreeEntity;
import com.shareTools.entity.TreeEntity;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  处理 书签 转换为  tree
 */
public class SouceConverTreeUtils {
    static Gson gson = new Gson();


    /**
     *  需求：
     *          只是显示 一层.
     *          在深入层级全部归为 第一层.
     *
     * @param SouceList
     * @param rootName   // 书签栏
     */
    private void SouceConverTree(String SouceList , String  rootName){

        if (StringUtils.isEmpty(SouceList)) return;



    }

    /**
     *  发生问题    :
     *           Id 和预想不一样.
     *           Id 解决之后 怎么输出   带FId CId 的list
     *
     */
    private void InitTestTree(){
        BookMarkTreeEntity testBookMark=new BookMarkTreeEntity();
        testBookMark.setFname("");;
        testBookMark.setFolder(true);
        testBookMark.setFid(0);
        testBookMark.setName("书签栏");

        TreeEntity TestTree=new TreeEntity();
        TestTree.setId(0);
        TestTree.setName("书签栏");
        TestTree.setFolder(true);


        ConverTreeAlgorithm(testBookMark,TestTree);

        String end=null;
        //  需要把進行id


    }

    @Test
    public void initData(){

      String treeList=  ReadFile("C:\\Users\\Administrator\\Desktop\\nodeTree\\output.json");
       BookMarkList= gson.fromJson(treeList, new TypeToken<List<BookMarkTreeEntity>>() {}.getType());
        InitTestTree();

    }

    public static String ReadFile(String path){
        String laststr="";
        File file=new File(path);
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader(file));
            String tempString=null;
//int line=1;
            while((tempString=reader.readLine())!=null){
//System.out.println("line"+line+":"+tempString);
                laststr=laststr+tempString;
//line++;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException el){
                }  }  }
        return laststr;
    }


    public static  long ID=1;  // ID  唯一的Id
    List<BookMarkTreeEntity> BookMarkList=null ;
    /**
     *  转换 Tree 算法
     */
    private void ConverTreeAlgorithm(BookMarkTreeEntity Entity, TreeEntity  rootTree){





            // 返回上一级
            if (!Entity.isFolder()){

                // addNewNode
                TreeEntity  childTree=new TreeEntity();
                childTree.setId(ID);
                childTree.setFid(Entity.getFid());
                childTree.setFolder(Entity.isFolder());
                childTree.setName(Entity.getName());
                childTree.setFname(Entity.getName());
                rootTree.addNode(childTree);

                return;
            }
        // 继续向下找
        for (int i= 0;i<BookMarkList.size();i++){
            BookMarkTreeEntity nextEntity=  BookMarkList.get(i);

                // AddNode   添加Nodes 集合中.
            if (Entity.getName().equalsIgnoreCase(nextEntity.getFname())){
                //集合继续向下查找


                nextEntity.setFid(Entity.getId());
                nextEntity.setId(ID);

                TreeEntity  childTree=new TreeEntity();
                childTree.setId(ID);
                childTree.setFid(Entity.getFid());
                childTree.setFolder(nextEntity.isFolder());
                childTree.setName(nextEntity.getName());
                childTree.setFname(Entity.getName());

                rootTree.addNode(childTree);

                ++ID;
                ConverTreeAlgorithm(nextEntity,childTree);
            }
        }

    }


}
