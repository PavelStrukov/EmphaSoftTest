/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.emphasofttest;

import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author Dell
 */
public class GenerateText {

    public static String generateMessage() {

        int length = 25;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return (generatedString.toLowerCase());
    }

}
