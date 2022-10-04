package space.moontalk.mc.more.bukkit.message;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import lombok.val;

public interface MessageProvider {
    default @NotNull String makeMessage(@NotNull String name, @UnknownNullability Object ...args) {
        val message = makeMessageOrNull(name, args);

        if (message == null) {
            val errorMessage = String.format("no message maker found for %s", name);
            throw new IllegalArgumentException(errorMessage);
        }

        return message;
    }

    default @Nullable String makeMessageOrNull(@NotNull String name, @UnknownNullability Object ...args) {
        val messageMakers = getMessageMakers();
        val messageMaker  = messageMakers.get(name);
        return messageMaker != null ? messageMaker.makeMessage(args) : null;
    }

    @NotNull Map<String, MessageMaker> getMessageMakers();
}
