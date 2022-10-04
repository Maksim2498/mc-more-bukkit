package space.moontalk.mc.more.bukkit.message;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import lombok.val;

public interface MessageProvider {
    default @NotNull String makeMessage(@NotNull String name, @UnknownNullability Object ...args) {
        val messageMakers = getMessageMakers();
        val messageMaker  = messageMakers.get(name);
        return messageMaker.makeMessage(args);
    }

    @NotNull Map<String, MessageMaker> getMessageMakers();
}
