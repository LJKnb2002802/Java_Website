package com.tfswufe.resume;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept(int i, String sales, String newyork) {
        this.deptno = i;
        this.dname = sales;
        this.loc = newyork;
    }
}
