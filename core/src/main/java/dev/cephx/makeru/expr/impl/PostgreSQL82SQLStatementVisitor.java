package dev.cephx.makeru.expr.impl;

import dev.cephx.makeru.expr.InvalidExpressionDefinitionException;
import dev.cephx.makeru.expr.StatementFormattingStrategy;
import dev.cephx.makeru.expr.table.DropTableSQLExpression;

public class PostgreSQL82SQLStatementVisitor extends PostgreSQL81SQLStatementVisitor {
    public PostgreSQL82SQLStatementVisitor(StatementFormattingStrategy strategy) {
        super(strategy);
    }

    // support IF EXISTS
    @Override
    public void visitDropTable(DropTableSQLExpression expr) {
        writeKeyword("drop table ");
        if (expr.isIfExists()) {
            writeKeyword("if exists ");
        }
        if (expr.getTableNames().isEmpty()) {
            throw new InvalidExpressionDefinitionException("At least one table must be specified in DROP TABLE");
        }
        write(String.join(", ", expr.getTableNames()));
        if (expr.getAction() != null) {
            writeKeyword(" " + expr.getAction());
        }
    }
}
