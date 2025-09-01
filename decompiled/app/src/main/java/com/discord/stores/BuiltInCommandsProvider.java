package com.discord.stores;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/BuiltInCommandsProvider;", "", "Lcom/discord/models/commands/Application;", "getFrecencyApplication", "()Lcom/discord/models/commands/Application;", "getBuiltInApplication", "", "Lcom/discord/models/commands/ApplicationCommand;", "getBuiltInCommands", "()Ljava/util/List;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface BuiltInCommandsProvider {
    Application getBuiltInApplication();

    List<ApplicationCommand> getBuiltInCommands();

    Application getFrecencyApplication();
}
