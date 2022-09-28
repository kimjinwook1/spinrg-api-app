package com.app.global.p6spy;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import java.util.Locale;
import org.hibernate.engine.jdbc.internal.FormatStyle;

public class P6spyPrettySqlFormatter implements MessageFormattingStrategy {



    @Override
    public String formatMessage(final int connectionId, final String now, final long elapsed, final String category, final String prepared, final String sql, final String url) {

        String message = new StringBuilder()
                .append("\n\n\tExecution Time: ").append(elapsed).append(" ms\n")
                .toString();

        return sqlFormat(sql, category, message);
    }

    private String sqlFormat(String sql, String category, String message) {
        if(sql.trim() == null || sql.trim().isEmpty()) {
            return "";
        }

        if(Category.STATEMENT.getName().equals(category)) {
            String s = sql.trim().toLowerCase(Locale.ROOT);
            if(s.startsWith("create") || s.startsWith("alter") || s.startsWith("comment")) {
                sql = FormatStyle.DDL
                        .getFormatter()
                        .format(sql);
            }
            else {
                sql = FormatStyle.BASIC
                        .getFormatter()
                        .format(sql);
            }
        }

        return new StringBuilder().append("\n")
                .append(sql)
                .append(message)
                .toString();
    }

}
