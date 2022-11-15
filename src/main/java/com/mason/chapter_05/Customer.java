package com.mason.chapter_05;

import lombok.Data;

/**
 * @author yongshi
 * @date 2022/11/13 17:01
 * @Description 用户类型
 */
@Data
public class Customer {
    private String name;
    private String jobTitle;

    public Customer(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", title='" + jobTitle + '\'' +
                '}';
    }
}
