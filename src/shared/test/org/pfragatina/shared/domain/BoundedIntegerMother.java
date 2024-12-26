package org.pfragatina.shared.domain;

public final class BoundedIntegerMother {
    public static Integer randomWithMin(int min) {
        return MotherCreator.random().number().numberBetween(min, Integer.MAX_VALUE);
    }

    public static Integer randomWithMax(int max) {
        return MotherCreator.random().number().numberBetween(Integer.MIN_VALUE, max);
    }

    public static Integer randomBetween(int min, int max) {
        return MotherCreator.random().number().numberBetween(min, max);
    }

}
