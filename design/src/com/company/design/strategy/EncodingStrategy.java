package com.company.design.strategy;

// Strategy Pattern
// 원본은 그대로 두고 전략만 추가 또는 변경한다.
// 전략 메서드를 가진 전략 객체와 전략 객체를 사용하는 컨텍스트가 필요
// 전략객체를 생성해 주입하는 방식
public interface EncodingStrategy {

    String encode(String text);
}
