package com.ziponia.util;

import org.junit.Assert;
import org.junit.Test;

public class VerifyUtilComponentTest {

    @Test
    public void passwordThen8AndSpecialCharactersTest() {

        // only number length 4
        boolean p1 = VerifyUtilComponent.passwordThen8AndSpecialCharacters("1234");

        // number is not found
        boolean p2 = VerifyUtilComponent.passwordThen8AndSpecialCharacters("p@sswordsIsTrue");

        // Special Characters is not found
        boolean p3 = VerifyUtilComponent.passwordThen8AndSpecialCharacters("passwordIsTrue78");

        // Good Password
        boolean p4 = VerifyUtilComponent.passwordThen8AndSpecialCharacters("p@ss3WordIl0veU");

        Assert.assertFalse(p1);
        Assert.assertFalse(p2);
        Assert.assertFalse(p3);
        Assert.assertTrue(p4);
    }
}
