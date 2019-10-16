package com.szabodev.examples.tdd.money;

public class Money implements Expression {

    final double amount;
    private final String currency;

    Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    String currency() {
        return currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        if (!(object instanceof Money)) {
            return false;
        }
        Money money = (Money) object;
        return amount == money.amount
                && this.currency.equals(money.currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
