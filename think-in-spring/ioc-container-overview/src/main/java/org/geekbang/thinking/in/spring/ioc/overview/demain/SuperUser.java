package org.geekbang.thinking.in.spring.ioc.overview.demain;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 超级用户
 *
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}';
    }
}
