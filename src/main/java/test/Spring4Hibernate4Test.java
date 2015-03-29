package test;

import hibernate.AppConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.LoginDao;

public class Spring4Hibernate4Test {
    public static void main1(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        LoginDao pdao = ctx.getBean(LoginDao.class);
//        pdao.saveLogin();/
        System.out.println("Done");
    }
}