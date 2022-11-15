package com.mason.chapter_05;


import com.mason.chapter_04.Document;
import lombok.var;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @date 2022/11/13 11:11
 * @Description 基于业务规则引擎类的测试类
 * 主要测试公共的API
 * 这里使用的是测试驱动开发(TDD)的方法：TDD的理念是开始编写一些
 * 测试，这些测试将为你知道代码的实现。换句话说，在实际实现之前你要先编写
 * 测试代码。这个与目前很多人的开发方式相反：之前是为一个需求编写了完整的代码，然后测试它。
 * 现在将更多地关注测试。在一个周期中，TDD方法大致上包括以下步骤：
 * 1.编写一个失败的测试。
 * 2。运行所有测试
 * 3。使实现能正常工作
 * 4。运行所有测试
 */
public class BusinessRuleEngineTest {

    @Test
    public void shouldHaveNoRulesInitially() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
//        assertEquals(0, businessRuleEngine.count());

    }

    @Test
    public void shouldAddTwoActions() {
        final Facts facts = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        businessRuleEngine.addAction(facts1 -> {
//            final String jobTitle = facts.getFact("jobTitle");
//            if ("CEO".equals(jobTitle)) {
//                final String name = facts.getFact("name");
//                Mailer.sendEmail("sales@company.com", "Relevant customer" + name);
//
//            }
//        });

        //一个计算特定交易预测金额的规则：实现方法1
//        businessRuleEngine.addAction(facts -> {
//            double forecastedAmount = 0.0;
//            final Stage[] stages = Stage.values(facts.getFact("satge"));
//            final double amount = Double.parseDouble(facts.getFact("amount"));
//            //通过if、else if的循环判断
//            if (stages == Stage.LEAD) {
//                forecastedAmount = amount * 0.5;
//            } else if (stages == Stage.EVALUATING) {
//                forecastedAmount = amount * 0.5;
//            } else if (stages == Stage.INTERESTED) {
//                forecastedAmount = amount * 0.8;
//            } else if (stages == Stage.CLOSED) {
//                forecastedAmount = amount;
//            }
//            facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
//
//
//        });
        //一个计算特定交易预测金额的规则：通过switch语句实现，显得更加简洁
        businessRuleEngine.addAction(facts1 -> {
            double forecastAmount = 0.0;
            final Stage dealStage = Stage.valueOf(facts.getFact("stage"));
            final double amount = Double.parseDouble(facts.getFact("amount"));
            switch (dealStage){
                case LEAD:
                    forecastAmount = amount * 0.2;
                    break;
                case EVALUATING:
                    forecastAmount = amount * 0.5;
                    break;
                case INTERESTED:
                    forecastAmount = amount * 0.8;
                    break;
                case CLOSED:
                    forecastAmount = amount;
                    break;


            }

        });
        //一个计算特定交易预测金额的规则：通过不同的switch语法来重写它，以避免出现fall-through和多次break，switch现在可以通过一个表达式
        businessRuleEngine.addAction(facts1 ->{
            final Stage dealStage = Stage.valueOf(facts.getFact("stage"));
            final double amount = Double.parseDouble(facts.getFact("amount"));
            final double forecastedAmount= amount * switch (dealStage) {
                //这是一种增强的switch形式好处是，除了增强可读性之外，还具有穷尽性
                case LEAD -> 0.2;
                case EVALUATING -> 0.5;
                case INTERESTED -> 0.8;
                case CLOSED -> 1;
            };
            facts.addFact("forecastedAmount",String.valueOf(forecastedAmount));
        } );


//            businessRuleEngine.addAction(()->{});
//            businessRuleEngine.addAction(()->{});
//            assertEquals(2,businessRuleEngine.count());
        //final Customer customer = new Customer("Mark", "CEO");
        //1.使用匿名类添加一个动作
//            businessRuleEngine.addAction(new Action() {
//                @Override
//                public void execute() {
//                    if ("CEO".equals(customer.getJobTitle())){
//                        //只有潜在客户的职位为CEO时，才通知销售团队
//                        Mailer.sendEmail("sales@company.com","Relevant customer: " + customer);
//                    }
//                }
//            });

        //2.使用lambda表达式添加一个动作
//            businessRuleEngine.addAction(()->{
//                if ("CEO".equals(customer.getJobTitle())){
//                    Mailer.sendEmail("sales@company.com","Relevant customer: " + customer);
//                }
//            });

        // businessRuleEngine.addAction(facts -> {});

    }


    /**
     * mocking技术允许你验证正在执行run()方法时，添加到业务规则引擎到每个动作都实际执行了。但是目前rn()方法
     * 返回了void。我们无法编写一个断言。我们这里简单使用Mockito,它是java中一款非常流行的mocking库
     * mock的意思是对于不容易创建的对象及行为，通过模拟的方式来实现
     */
    @Test
    public void shouldExecuteOneAction() {

        //final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        //创建一个mock对象,通过将类作为参数传递给mock方法来实现
        //  final Action mockkAction = mock(Action.class);
        //验证是否调用了某个方法
//        businessRuleEngine.addAction(mockkAction);
//        businessRuleEngine.run();
//        verify(mockkAction).execute();


    }


}
