/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package org.apache.ibatis.parsing;

import java.util.Properties;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/11/27 16:07
 */
public class Main {

    public static void main(String[] args) {
        String username = "${username:root}";
        Properties props = new Properties();
        props.put("username", "xiaoming");
        VariableTokenHandler tokenHandler = new VariableTokenHandler(props);
        GenericTokenParser parser = new GenericTokenParser("${", "}", tokenHandler);
        String result = parser.parse(username);
        System.out.println(result);
    }

    private static class VariableTokenHandler implements TokenHandler {
        private final Properties variables;
        private final boolean enableDefaultValue;
        private final String defaultValueSeparator;

        private VariableTokenHandler(Properties variables) {
            this.variables = variables;
            this.enableDefaultValue = true;
            this.defaultValueSeparator = ":";
        }

        private String getPropertyValue(String key, String defaultValue) {
            return (variables == null) ? defaultValue : variables.getProperty(key, defaultValue);
        }

        @Override
        public String handleToken(String content) {
            if (variables != null) {
                String key = content;
                if (enableDefaultValue) {
                    final int separatorIndex = content.indexOf(defaultValueSeparator);
                    String defaultValue = null;
                    if (separatorIndex >= 0) {
                        key = content.substring(0, separatorIndex);
                        defaultValue = content.substring(separatorIndex + defaultValueSeparator.length());
                    }
                    if (defaultValue != null) {
                        return variables.getProperty(key, defaultValue);
                    }
                }
                if (variables.containsKey(key)) {
                    return variables.getProperty(key);
                }
            }
            return "${" + content + "}";
        }
    }
}
