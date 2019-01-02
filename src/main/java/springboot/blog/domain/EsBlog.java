package springboot.blog.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author kuangfeng
 * @date 2019-01-02 23:56
 * 博客文档类
 */
@Data
//Documented给类添加注释
@Document(indexName = "blog",type = "blog")
public class EsBlog implements Serializable { //实现可序列化接口
    //实现java.io.Serializable这个接口是为序列化,
    // serialVersionUID 用来表明实现序列化类的不同版本间的兼容性
    private  static final long serialVersionUID = 1L;
    @Id
    private String id;  //ES里面使用String来定义id
    private String title;
    private String summary;
    private String content;

    protected EsBlog(){ //JPA 规范要求，防止直接使用
        }
    public EsBlog(String title,String summary,String content){
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    @Override
    public String toString(){   //方便信息打印，重写toString方法
        return String.format(
                "Esblog[id='%s',title='%s',summary='%s',content='%s']",
                id,title,summary,content);
    }

}
