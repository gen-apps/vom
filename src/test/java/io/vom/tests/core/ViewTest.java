package io.vom.tests.core;

import com.google.common.primitives.Chars;
import io.vom.appium.AppiumDriverImpl;
import io.vom.core.Context;
import io.vom.views.LoginView;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ViewTest {


    @Test
    public void common_selector_test() {
        Integer[] arr = new Integer[]{5, 8, 6, 3, 4};

        Arrays.sort(arr, (a, b) -> {
            if (a > b) {
                return 1;
            } else if (a < b && b % 2 == 0) {
                return -1;
            } else {
                return Integer.compare(a, b);
            }

        });

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void context_builder() {
        Context context = Context.getBuilder()
                .setDriver(new AppiumDriverImpl())
                .build();

        context.loadView(LoginView.class)
                .job(loginView -> System.out.println(loginView.getSelectorTest()))
                .login()
                .clickButton()
                .job((it) -> System.out.println(it.collect()))
                .scrollUpToStart();


    }
}
