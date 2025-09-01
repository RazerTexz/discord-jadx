package com.discord.api.botuikit;

import kotlin.Metadata;

/* compiled from: Component.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/api/botuikit/ComponentType;", "", "Ljava/lang/Class;", "Lcom/discord/api/botuikit/Component;", "clazz", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "", "type", "I", "getType", "()I", "<init>", "(Ljava/lang/String;IILjava/lang/Class;)V", "UNKNOWN", "ACTION_ROW", "BUTTON", "SELECT", "TEXT", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.botuikit.ComponentType, reason: use source file name */
/* loaded from: classes.dex */
public enum Component6 {
    UNKNOWN(0, Component9.class),
    ACTION_ROW(1, ActionRowComponent.class),
    BUTTON(2, ButtonComponent.class),
    SELECT(3, SelectComponent.class),
    TEXT(4, TextComponent.class);

    private final Class<? extends Component> clazz;
    private final int type;

    Component6(int i, Class cls) {
        this.type = i;
        this.clazz = cls;
    }

    public final Class<? extends Component> getClazz() {
        return this.clazz;
    }

    public final int getType() {
        return this.type;
    }
}
