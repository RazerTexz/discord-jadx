package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ModelRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/api/application/Application;", "application", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/application/Application;)Lcom/discord/widgets/user/presence/ModelRichPresence;", "com/discord/widgets/user/presence/ModelRichPresence$Companion$get$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelRichPresence2<T, R> implements Func1<Application, ModelRichPresence> {
    public final /* synthetic */ Presence $presence$inlined;

    public ModelRichPresence2(Presence presence) {
        this.$presence$inlined = presence;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ ModelRichPresence call(Application application) {
        return call2(application);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelRichPresence call2(Application application) {
        return new ModelRichPresence(this.$presence$inlined, application);
    }
}
