package com.mawen.lambda.chapter08.template;

/**
 * 使用模板方法模式描述申请贷款过程
 */
public abstract class LoanApplication {

    public void checkLoanApplication() {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity();

    protected abstract void checkCreditHistory();

    protected abstract void checkIncomeHistory();

    private void reportFindings() {

    }
}
