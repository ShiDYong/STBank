package com.mason.chapter_05;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/11/13 10:48
 * @Description 业务规则引擎的的基础API和基本实现
 * 业务规则引擎：是执行一个或多个业务规则的软件，这些业务规则通常使用
 * 简单的定制化语言进行声明。业务规则引擎可以支持多个不同的组件：
 * 事实：规则可以访问的信息   动作：想要执行的动作  条件：它们指定何时触发某个动作
 * 规则：它们指定你想要执行的业务逻辑，本质上是将事实、条件和动作聚合在了一起
 * 业务规则引擎在生产效率方面的主要优势在于，它支持在一个地方维护、执行和测试规则，而
 * 不需要与主运用程序集成。
 * 目前用于生产的Java的业务规则引擎，Activiti7X、Drools等
 * 该类从简单地列出你需要用户完成的基本功能开始：
 */
public class BusinessRuleEngine {
    private List<Action> actions;
    private Facts facts;

    public BusinessRuleEngine(Facts facts) {
        this.actions = new ArrayList<>();
        this.facts = facts;
    }


    /**
     * 添加一个动作
     *
     * @param action
     */
    public void addAction(Action action) {
        //throw new UnsupportedOperationException();
        this.actions.add(action);
    }

    /**
     * 执行一个动作
     */
    public void run() {
        // throw new UnsupportedOperationException();
        // this.actions.forEach(Action::execute);
        this.actions.forEach(action -> action.execute(facts));
    }

    /**
     * 获取基本的报告数量
     *
     * @return
     */
    public int count() {
        //  throw new UnsupportedOperationException();
        return this.actions.size();
    }
}
