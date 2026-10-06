package ec.com.leodev.msh.hotels.commons;

import java.text.MessageFormat;

public abstract class AbstractPropertyResolver {
    public AbstractPropertyResolver() {
    }

    public abstract String resourceValue(String var1);

    public String getString(String key, String... parameters) {
        MessageFormat formatter = new MessageFormat(this.resourceValue(key));
        return formatter.format(parameters);
    }

    public Integer getInteger(String key) {
        String value = this.getString(key);
        return Integer.valueOf(value);
    }

    public Boolean getBoolean(String key) {
        String value = this.getString(key);
        return Boolean.valueOf(value);
    }
}
