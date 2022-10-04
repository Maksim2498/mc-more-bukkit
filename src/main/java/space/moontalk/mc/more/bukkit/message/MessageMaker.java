package space.moontalk.mc.more.bukkit.message;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public interface MessageMaker {
    @NotNull String makeMessage(@UnknownNullability Object ...args); 
}
