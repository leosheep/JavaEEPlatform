// JavaEEPlatform by School of Informatics Xiamen University, GPL-3.0 license
package cn.edu.xmu.javaee.autowiredemo.cirualbean.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircualB {

    private CircualC c;

    @Autowired
    @Lazy
    public void setC(CircualC c) {
        this.c = c;
    }
}