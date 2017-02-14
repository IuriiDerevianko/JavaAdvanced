package ua.itea.ijavaadv.lesson04.setmath;

import java.util.HashSet;
import java.util.Set;

/**
 * Created
 * at 18:21
 * on 07.02.17
 * by Iurii Derevianko;
 */

class SetMath {

    static Set<Object> union(Set<Object> firstSet, Set<Object> secondSet){
        Set<Object> resultUnion = new HashSet<>(firstSet);
        resultUnion.addAll(secondSet);
        return resultUnion;
    }

    static Set<Object> intersection(Set<Object> firstSet, Set<Object> secondSet){
        Set<Object> resultIntersection = new HashSet<>(firstSet);
        resultIntersection.retainAll(secondSet);
        return resultIntersection;
    }

    static Set<Object> difference(Set<Object> firstSet, Set<Object> secondSet){
        Set<Object> resultDifference = new HashSet<>(union(firstSet, secondSet));
        resultDifference.removeAll(intersection(firstSet, secondSet));
        return resultDifference;
    }
}
