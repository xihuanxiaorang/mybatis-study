package top.xiaorang.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer id;
    private String name;
    /**
     * 一对多和多对一只选一种方式维护即可，这里是测试，所以才在teacher中维护students集合的同时，又在student中维护teacher
     */
    private List<Student> students;
}
