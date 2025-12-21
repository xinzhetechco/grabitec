package com.dlxz.grabitec.entity;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

@Getter
public enum EcUserState implements IEnum<Integer> {
    PENDING(0),  // 待激活
    ACTIVE(1);   // 已激活

    private final int value;


    EcUserState(int value) {
        this.value = value;
    }
    @Override
    public Integer getValue() {
        return value;
    }


    // 根据数据库值获取枚举
    public static EcUserState fromValue(int value) {
        for (EcUserState state : EcUserState.values()) {
            if (state.value == value) return state;
        }
        throw new IllegalArgumentException("Unknown UserState value: " + value);
    }
}
