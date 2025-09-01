package com.discord.widgets.chat.input.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommandOptionValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\n\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "", "value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "Lcom/discord/widgets/chat/input/models/SnowflakeOptionValue;", "Lcom/discord/widgets/chat/input/models/IntegerOptionValue;", "Lcom/discord/widgets/chat/input/models/NumberOptionValue;", "Lcom/discord/widgets/chat/input/models/StringOptionValue;", "Lcom/discord/widgets/chat/input/models/BooleanOptionValue;", "Lcom/discord/widgets/chat/input/models/RoleOptionValue;", "Lcom/discord/widgets/chat/input/models/UserOptionValue;", "Lcom/discord/widgets/chat/input/models/ChannelOptionValue;", "Lcom/discord/widgets/chat/input/models/AttachmentOptionValue;", "Lcom/discord/widgets/chat/input/models/RawOptionValue;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class CommandOptionValue {
    private final Object value;

    private CommandOptionValue(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    public /* synthetic */ CommandOptionValue(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }
}
