package dev.cephx.makeru.r2dbc;

import dev.cephx.makeru.reactor.ReactiveConnection;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Data
public class R2DBCConnection implements ReactiveConnection {
    private final io.r2dbc.spi.Connection connection;

    @Override
    public Publisher<Void> close() {
        return connection.close();
    }

    @Override
    public @NotNull R2DBCStatement createStatement(@NotNull String sql) {
        return new R2DBCStatement(connection.createStatement(sql));
    }
}
